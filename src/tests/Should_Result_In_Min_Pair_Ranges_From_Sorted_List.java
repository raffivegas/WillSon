package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import interfaces.ICruncher;
import logic.ZipcodeCruncher;
import utils.NumberPair;

/**
 * @author Raffi
 * This tests the FindValidPairs function in the ZipcodeCruncher class.
 * 
 */
class Should_Result_In_Min_Pair_Ranges_From_Sorted_List {

	@Test
	void test() {
		// test 1
		// create mock input list which will be sorted later before running through 
		// final valid pair algo.
		List<NumberPair> mockInputList = new ArrayList<NumberPair>();
		mockInputList.add(new NumberPair("00000", "10000"));
		mockInputList.add(new NumberPair("01323", "19000"));
		mockInputList.add(new NumberPair("01323", "09000"));
		mockInputList.add(new NumberPair("18999", "21000"));
		mockInputList.add(new NumberPair("21002", "21004"));
		mockInputList.add(new NumberPair("01323", "09000"));
		mockInputList.add(new NumberPair("21004", "21006"));
		mockInputList.add(new NumberPair("21005", "21005"));
		mockInputList.add(new NumberPair("21006", "21007"));
		mockInputList.add(new NumberPair("21009", "21010"));
		mockInputList.add(new NumberPair("01323", "09000"));
		mockInputList.add(new NumberPair("99999", "99999"));
		mockInputList.add(new NumberPair("90000", "99998"));
		mockInputList.add(new NumberPair("01323", "09000"));
		mockInputList.add(new NumberPair("40000", "40002"));
		mockInputList.add(new NumberPair("39999", "40001"));
		mockInputList.add(new NumberPair("01323", "19000"));
		
		// validate the sorted mockInputList against the expected mockFinalList.
		// They should be equal.
		List<NumberPair> mockFinalList = new ArrayList<NumberPair>();
		mockFinalList.add(new NumberPair("00000", "21000"));
		mockFinalList.add(new NumberPair("21002", "21007"));
		mockFinalList.add(new NumberPair("21009", "21010"));
		mockFinalList.add(new NumberPair("39999", "40002"));
		mockFinalList.add(new NumberPair("90000", "99999"));
		
		List<NumberPair> placeHolderList = new ArrayList<NumberPair>();
		
		ICruncher mockPairs = new ZipcodeCruncher();
		placeHolderList.addAll(mockPairs.findFinalPairs(mockPairs.sortPairs(mockInputList)));
		mockInputList.clear();
		mockInputList.addAll(placeHolderList);
		
		// I was having issues with the list equals function not returning true when the lists had identical values.
		// I kludged this together since I've run out of time to look for a solution to the list equals issue.
		boolean pass1 = false;
		if (mockFinalList.size() == mockInputList.size())
		for (int i = 0; i < mockFinalList.size(); i++) {
			if ((mockFinalList.get(i).getLeft().equals(mockInputList.get(i).getLeft()) 
					&& (mockFinalList.get(i).getRight().equals(mockInputList.get(i).getRight())))) {
				pass1 = true;
			} else {
				pass1 = false;
			}
		}

		// was going to add more tests in this test() function and add them to the assertTrue(boolean),
		// then I could do assertTrue(pass1 && pass2 && passN+1).
		assertTrue(pass1);
		
	}

}
