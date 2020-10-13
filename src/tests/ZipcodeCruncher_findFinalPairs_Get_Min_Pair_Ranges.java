package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import interfaces.IPairHandler;
import logic.ZipcodeCruncher;
import utils.StringPair;

/**
 * @author Raffi
 * This tests the FindValidPairs function in the ZipcodeCruncher class.
 * 
 */
class ZipcodeCruncher_findFinalPairs_Get_Min_Pair_Ranges {

	@Test
	void test() {
		// test 1
		// create mock input list which will be sorted later before running through 
		// final valid pair algo.
		List<StringPair> mockInputList = new ArrayList<StringPair>();
		mockInputList.add(new StringPair("00000", "10000"));
		mockInputList.add(new StringPair("01323", "19000"));
		mockInputList.add(new StringPair("01323", "09000"));
		mockInputList.add(new StringPair("18999", "21000"));
		mockInputList.add(new StringPair("21002", "21004"));
		mockInputList.add(new StringPair("01323", "09000"));
		mockInputList.add(new StringPair("21004", "21006"));
		mockInputList.add(new StringPair("21005", "21005"));
		mockInputList.add(new StringPair("21006", "21007"));
		mockInputList.add(new StringPair("21009", "21010"));
		mockInputList.add(new StringPair("01323", "09000"));
		mockInputList.add(new StringPair("99999", "99999"));
		mockInputList.add(new StringPair("90000", "99998"));
		mockInputList.add(new StringPair("01323", "09000"));
		mockInputList.add(new StringPair("40000", "40002"));
		mockInputList.add(new StringPair("39999", "40001"));
		mockInputList.add(new StringPair("01323", "19000"));
		
		// validate the sorted mockInputList against the expected mockFinalList.
		// They should be equal.
		List<StringPair> mockFinalList = new ArrayList<StringPair>();
		mockFinalList.add(new StringPair("00000", "21000"));
		mockFinalList.add(new StringPair("21002", "21007"));
		mockFinalList.add(new StringPair("21009", "21010"));
		mockFinalList.add(new StringPair("39999", "40002"));
		mockFinalList.add(new StringPair("90000", "99999"));
		
		List<StringPair> placeHolderList = new ArrayList<StringPair>();
		
		IPairHandler<StringPair> mockPairs = new ZipcodeCruncher();
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
