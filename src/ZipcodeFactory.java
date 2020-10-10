import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import interfaces.ICruncher;
import interfaces.IIOHelper;
import utils.NumberPair;

public class ZipcodeFactory implements ICruncher {
	/**
	 * @author Raffi
	 * this method sorts a List of NumberPair objects using the left hand value, only in ascending order.
	 * I just wanted to brute force this algo in an effort to save time. 
	 * I scribbled a quick pseudo-code algo on paper, then I kludged the code together, or in other words,
	 * threw stuff at the wall until something stuck, and it came together this way.  In a nutshell,
	 * the algo looks at a pair and compares it to every other pair in the stack until it reaches the end 
	 * or finds a number greater than it (comparing only the left numbers), then it either has reached the end
	 * and starts over comparing from the beginning one pair vs the one next to it, or if there are still pairs after it
	 * it grabs the next pair immediately after it and starts to move that down the list.
	 * Here's the pattern as the code orders 5,2,3,7,1,0 (I made the example single rows for simplicity, my algo does pairs):
	 * start -----------------------------------> end
	 * 5	2	2	2	2	2	2	2	2	1	1	0
	 * 2	5	3	3	3	3	3	1	1	2	0	1
	 * 3	3	5	5	5	1	1	3	0	0	2	2
	 * 7	7	7	1	1	5	0	0	3	3	3	3
	 * 1	1	1	7	0	0	5	5	5	5	5	5
	 * 0	0	0	0	7	7	7	7	7	7	7	7
	 * Ultimately, it just works.
	 */
	@Override
	public List<NumberPair> sortPairs(List<NumberPair> myList) {

		List<NumberPair> sortedList = new ArrayList<NumberPair>();
		
		int counter = 0;
		int maxCounter = 0;
		boolean repeat = true;
		boolean reachedMax = false;
		
		if (myList.size() > 1)
		do {
			int leftCurrent = Integer.parseInt(myList.get(counter).getLeft());
			int rightCurrent = Integer.parseInt(myList.get(counter).getRight());
			int nextLeft = Integer.parseInt(myList.get(counter + 1).getLeft());
			int nextRight = Integer.parseInt(myList.get(counter + 1).getRight());
			
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

		return myList;
	}

	public List<NumberPair> findFinalPairs(List<NumberPair> mySortedList) {

		List<NumberPair> finalList = new ArrayList<NumberPair>();

		int counter = 0;

			while (counter < mySortedList.size() - 1) {
				finalList.clear();
				finalList.addAll(mySortedList);
				int leftCurrent = Integer.parseInt(mySortedList.get(counter).getLeft());
				int rightCurrent = Integer.parseInt(mySortedList.get(counter).getRight());
				int nextLeft = Integer.parseInt(mySortedList.get(counter + 1).getLeft());
				int nextRight = Integer.parseInt(mySortedList.get(counter + 1).getRight());

				NumberPair newPair = new NumberPair(String.valueOf(leftCurrent), String.valueOf(nextRight));
				if (rightCurrent >= nextLeft) {
					if (nextRight < rightCurrent) {
						newPair.setRight(String.valueOf(rightCurrent));
					}
					
					finalList.remove(counter);
					finalList.remove(counter);
					finalList.add(newPair);
					finalList = sortPairs(finalList);
					mySortedList.clear();
					mySortedList.addAll(finalList);
					counter--;
				}
				counter++;
			}

		return mySortedList;
	}

}
