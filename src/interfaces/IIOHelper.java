package interfaces;

import java.util.List;

public interface IIOHelper <T>{
	
	List<T> parsePackage();
	
	void validateInput();

	void sendPackage(List<T> finalList);
	
}
