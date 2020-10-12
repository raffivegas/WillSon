package logic;
import java.util.ArrayList;
import java.util.List;

import interfaces.ICruncher;
import utils.NumberPair;
//TODO add an exception handler class to be able to do something meaningful with exceptions.

/**
 * @author Raffi
 * Class which handles business logic.  In this case, manipulates pairs of zip-codes.
 */
public class ZipcodeCruncher implements ICruncher {
	
	public ZipcodeCruncher() {
		
	}
	
	/**
	 * @author Raffi
	 * bubble sorter - there may have been a recursive way to write this, or the option
	 * to use an insertion sort instead, but I chose this since it came to mind first.
	 * Also, might want to consider using a Factory pattern.
	 * Here's the pattern as the code orders 5,2,3,7,1,0 (columns get sorted)
	 * (I made this example with single rows for simplicity, my algo does pairs):
	 * start -----------------------------------> end
	 * 5	2	2	2	2	2	2	2	2	1	1	0
	 * 2	5	3	3	3	3	3	1	1	2	0	1
	 * 3	3	5	5	5	1	1	3	0	0	2	2
	 * 7	7	7	1	1	5	0	0	3	3	3	3
	 * 1	1	1	7	0	0	5	5	5	5	5	5
	 * 0	0	0	0	7	7	7	7	7	7	7	7
	 */
	@Override
	public List<NumberPair> sortPairs(List<NumberPair> myList) {

		List<NumberPair> sortedList = new ArrayList<NumberPair>();
		
		int counter = 0;
		int maxCounter = 0;
		boolean repeat = true;
		boolean reachedMax = false;
		
		try {
			
		if (myList.size() > 1)
		do {
			int leftCurrent = Integer.parseInt(myList.get(counter).getLeft());
			int nextLeft = Integer.parseInt(myList.get(counter + 1).getLeft());
			
			// if the left side number in the current pair is greater than the pair following it
			if (leftCurrent > nextLeft) {
				sortedList.clear();
				// initialize or re-init the new partially sorted list and the space in it.
				sortedList.addAll(myList);
				// gets the current and next pairs from the source list.
				NumberPair currentPair = myList.get(counter);
				NumberPair nextPair = myList.get(counter + 1);
				// sets (overwrites) the pair in the next position with the current pair.
				sortedList.set(counter + 1, currentPair);
				// sets (overwrites) the current pair with the next pair, swapping positions with the pairs. 
				sortedList.set(counter, nextPair);
				// clearing and initializing the control list to match the sorted list.
				myList.clear();
				myList.addAll(sortedList);
				// we're going to repeat this, for as long as we haven't reached the maxCounter,
				// starting from the first pair every time and checking the first pair against every successive
				// pair and swapping until the first pair is the least/lowest pair.
				repeat = true;
				// resetting the max counter because we had a leftCurrent > nextLeft encounter.
				maxCounter = 0;
				
			} else if (reachedMax == true) {  // have we iterated over the whole stack?  If so, we're done.
				repeat = false;
			}
			maxCounter++;
			if (maxCounter == myList.size()) {
				// we've iterated over the whole stack with no leftCurrent > nextLeft encounters.
				reachedMax = true;
			}
			
			counter++;
			// this keeps track of the pair we're moving down the list
			// and resets to 0 once we've reached the end of the list with our pair.
			if (counter + 1 == myList.size()) {
 
				counter = 0;
			}
		} while (repeat);  // keep going while repeat is true.
		
		} catch (Exception e) {
			throw e;//e.printStackTrace();
		}
		
		return myList;
	}
	
	
	/**
	 * @author Raffi
	 * This method returns the final set of zip-codes which can't be shipped to.
	 * The final arrangement provides ranges which do not overlap and the minimum 
	 * number of ranges required to represent the same restrictions as the input.
	 * I ended up kludging this during unit testing since I've run out of time.
	 */
	public List<NumberPair> findFinalPairs(List<NumberPair> mySortedList) {

		// placeholder for final sorted list which will have the minimum
		// number of pairs to show which zip-codes can't be shipped to.
		List<NumberPair> finalList = new ArrayList<NumberPair>();

		int counter = 0;

		try {
			while (counter < mySortedList.size() - 1) {
				// initialize and fill the final sorted list.
				finalList.clear();
				finalList.addAll(mySortedList);
				
				// get the current and next left,right pairs.
				// int leftCurrent = Integer.parseInt(mySortedList.get(counter).getLeft());
				int rightCurrent = Integer.parseInt(mySortedList.get(counter).getRight());
				int nextLeft = Integer.parseInt(mySortedList.get(counter + 1).getLeft());
				int nextRight = Integer.parseInt(mySortedList.get(counter + 1).getRight());
				
				// Would have to pad if casting from int back to string values.  Using this as workaround.
				String stringLeftCurrent = mySortedList.get(counter).getLeft();
				String stringRightCurrent = mySortedList.get(counter).getRight();
				// String stringNextLeft = mySortedList.get(counter + 1).getLeft();
				String stringNextRight = mySortedList.get(counter + 1).getRight();

				// doing this backwards.  Creates a new pair with the current left value, and the 
				// next right value.
				NumberPair newPair = new NumberPair(stringLeftCurrent, stringRightCurrent);
				// the next if statement checks to see if the right value of the current pair
				// is greater than, equal to, or one less than the right value of the next pair.
				if (rightCurrent > nextLeft || (rightCurrent == nextLeft) || (rightCurrent + 1 == nextLeft)) {
					// the next if statement checks to see if the right pair is nested within the left pair.
					if (nextRight <= rightCurrent) { 
						newPair.setRight(stringRightCurrent);
					}
					else {
						newPair.setRight(stringNextRight);
					}
					// the remove operation removes the position indicated and shifts everything up.
					// From Example 1 above, (5,10 and 7,12), I remove the (5,10) and the (7,12) and replace it with
					// the new pair (5,12).  With Example 2, I remove the (5,10) and the (7,9) and replace with (5,10).
					finalList.remove(counter);
					finalList.remove(counter);
					finalList.add(newPair);
					// The list needs to be resorted and the algo needs to run through the whole list without
					// any rightCurrent >= nextLeft hits to exit this while block.
					finalList = sortPairs(finalList);
					mySortedList.clear();
					mySortedList.addAll(finalList);
					counter--;
				}
				counter++;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return mySortedList;
	}

}
