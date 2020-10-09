import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import interfaces.ICruncher;
import interfaces.IIOHelper;
import utils.NumberPair;

public class ZipcodeFactory implements ICruncher {

	@Override
	public List<NumberPair> sortPairs(List<NumberPair> myList) {
		// sort list using left value smallest to largest
		List<NumberPair> sortedList = new ArrayList<NumberPair>();
		// List<NumberPair> sortedList = myList;
		/*
		 * for (NumberPair myPair : myList) { if (my) }
		 */

		// I have no idea how I figured this out. I prayed. It's a miracle.
		//NumberPair test = myList.get(3);
		//sortedList.addAll(myList);
		//sortedList.set(2, test);
		int counter = 0;
		int maxCounter = 0;
		boolean repeat = true;
		boolean reachedMax = false;
		do {
			if (Integer.parseInt(myList.get(counter).getLeft()) > Integer.parseInt(myList.get(counter + 1).getLeft())) {
				sortedList.clear();
				sortedList.addAll(myList);
				NumberPair whyIsThisHappeningToMe = myList.get(counter);
				sortedList.set(counter + 1, whyIsThisHappeningToMe);
				sortedList.set(counter, myList.get(counter + 1));
				myList.clear();
				myList.addAll(sortedList);
				repeat = true;
				counter = 0;
				maxCounter = 0;
			} else if (reachedMax == true) {
				repeat = false;
			}
			maxCounter++;
			if (maxCounter == myList.size()) {
				reachedMax = true;
			}
			counter++;
			if (counter + 1 == myList.size()) {
				counter = 0;
			}
		} while (repeat);

		for (NumberPair raf : myList) {
			System.out.println(raf.getLeft() + "," + raf.getRight());
		}
		
		//repeat = 
		return myList;
	}

	public List<NumberPair> findValidPairs(List<NumberPair> mySortedList) {

		List<NumberPair> finalList = new ArrayList<NumberPair>();

		int counter = 0;
		int maxCounter = 0;
/*
		while (maxCounter < mySortedList.size()) {
			finalList.clear();
			finalList.addAll(mySortedList);
*/
		//do {
			while (counter < mySortedList.size() - 1) {
				finalList.clear();
				finalList.addAll(mySortedList);
				int leftCurrent = Integer.parseInt(mySortedList.get(counter).getLeft());
				int rightCurrent = Integer.parseInt(mySortedList.get(counter).getRight());
				int nextLeft = Integer.parseInt(mySortedList.get(counter + 1).getLeft());
				int nextRight = Integer.parseInt(mySortedList.get(counter + 1).getRight());

				NumberPair newPair = new NumberPair(String.valueOf(leftCurrent), String.valueOf(nextRight));
				if (rightCurrent >= nextLeft) {
					//NumberPair newPair = new NumberPair();
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
		//}while (maxCounter < mySortedList.size());

		//}

		
		System.out.println("Final List");
		for (NumberPair raf : finalList) {
			System.out.println(raf.getLeft() + "," + raf.getRight());
		}

		return mySortedList;
	}

}
