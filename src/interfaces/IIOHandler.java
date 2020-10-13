package interfaces;

import java.util.List;

public interface IIOHandler <T>{
	
	List<T> parsePackage();
	
	boolean validateInput();

	void sendPackage(List<T> finalList);
	
}
