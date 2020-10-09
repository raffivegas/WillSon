package interfaces;

import java.util.List;

import utils.NumberPair;

public interface IIOHelper {
	
	List<NumberPair> parsePackage();
	
	List<NumberPair> validateInput();

	void sendPackage(List<NumberPair> finalList);
	
}
