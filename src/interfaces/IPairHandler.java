package interfaces;

import java.util.List;

public interface IPairHandler <T>{
	
	List<T> sortPairs(List<T> myList);
	
	List<T> findFinalPairs(List<T> mySortedList);

}
