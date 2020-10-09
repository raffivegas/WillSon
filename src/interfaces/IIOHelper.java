package interfaces;

import java.util.List;

import utils.NumberPair;

public interface IIOHelper {

	boolean isValid();
	
	List<NumberPair> parsePackage();
	
	List<NumberPair> validList();
	
	//void findValidPairs(List<NumberPair> myList);
	
	void sendPackage();
	
}
