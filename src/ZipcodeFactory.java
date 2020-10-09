import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import interfaces.ICruncher;
import utils.NumberPair;

public class ZipcodeFactory implements ICruncher {

	@Override
	public void findValidPairs(List<NumberPair> myList) {
		// sort list using left value smallest to largest
		List<NumberPair> sortedList = new ArrayList<NumberPair>();
		// List<NumberPair> sortedList = myList;
		/*
		 * for (NumberPair myPair : myList) { if (my) }
		 */
		
		//I have no idea how I figured this out.  I prayed.  It's a miracle.
		NumberPair test = myList.get(3);
		sortedList.addAll(myList);
		sortedList.set(2, test);
		int counter = 0;
		int maxCounter = 0;
		boolean repeat = false;
		boolean reachedMax = false;
		do {
			if (Integer.parseInt(myList.get(counter).left) > Integer.parseInt(myList.get(counter + 1).left)) {
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
			}else if (reachedMax == true)
			{
				repeat = false;
			}
			maxCounter++;
			if(maxCounter == myList.size())
			{
				reachedMax = true;
			}
			counter++;
			if(counter + 1 == myList.size()) {
				counter = 0;
			}
		} while (repeat);

		for (NumberPair raf : myList) {
			System.out.println(raf.left + "," + raf.right);
		}
	}

}
