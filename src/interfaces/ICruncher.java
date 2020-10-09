package interfaces;

import java.util.List;

import utils.NumberPair;

public interface ICruncher {
	
	List<NumberPair> sortPairs(List<NumberPair> myList);
	
	List<NumberPair> findFinalPairs(List<NumberPair> mySortedList);

}
