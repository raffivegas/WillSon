package interfaces;

import java.util.List;

import utils.NumberPair;

public interface IIOHelper {
	
	List<NumberPair> parsePackage();
	
	void validateInput();

	void sendPackage(List<NumberPair> finalList);
	
}
