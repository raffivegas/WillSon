package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import interfaces.ICruncher;
import logic.ZipcodeCruncher;
import utils.StringPair;

/**
 * @author Raffi
 * This tests the SortPairs function in the ZipcodeCruncher class.
 * Please note it only cares about the sort of the left hand column.
 */
class Should_Sort_Unsorted_Pairs {

	@Test
	void test() {
		// create mock unsorted list.
		List<StringPair> mockUnsortedList = new ArrayList<StringPair>();
		mockUnsortedList.add(new StringPair("01323", "19000"));
		mockUnsortedList.add(new StringPair("01323", "09000"));
		mockUnsortedList.add(new StringPair("99999", "99999"));
		mockUnsortedList.add(new StringPair("18999", "21000"));
		mockUnsortedList.add(new StringPair("21002", "21004"));
		mockUnsortedList.add(new StringPair("00000", "10000"));	
		mockUnsortedList.add(new StringPair("21005", "21005"));
		mockUnsortedList.add(new StringPair("21006", "21007"));	
		mockUnsortedList.add(new StringPair("90000", "99998"));
		mockUnsortedList.add(new StringPair("21004", "21006"));
		mockUnsortedList.add(new StringPair("40000", "40002"));
		mockUnsortedList.add(new StringPair("39999", "40001"));
		mockUnsortedList.add(new StringPair("21009", "21010"));
		
		// validate the sorted mockUnsortedList against the sorted list.
		// They should be equal.
		List<StringPair> mockSortedList = new ArrayList<StringPair>();
		mockSortedList.add(new StringPair("00000", "10000"));
		mockSortedList.add(new StringPair("01323", "09000"));
		mockSortedList.add(new StringPair("01323", "19000"));
		mockSortedList.add(new StringPair("18999", "21000"));
		mockSortedList.add(new StringPair("21002", "21004"));
		mockSortedList.add(new StringPair("21004", "21006"));
		mockSortedList.add(new StringPair("21005", "21005"));
		mockSortedList.add(new StringPair("21006", "21007"));
		mockSortedList.add(new StringPair("21009", "21010"));
		mockSortedList.add(new StringPair("39999", "40001"));
		mockSortedList.add(new StringPair("40000", "40002"));
		mockSortedList.add(new StringPair("90000", "99998"));
		mockSortedList.add(new StringPair("99999", "99999"));
		
		List<StringPair> sortedList = new ArrayList<StringPair>();
		
		ICruncher mockOutput = new ZipcodeCruncher();
		sortedList.addAll(mockOutput.sortPairs(mockUnsortedList));

		// I was having issues with the list equals function not returning true when the lists had identical values.
		// I kludged this together since I've run out of time to look for a solution to the list equals issue.
		boolean pass = false;
		if (mockSortedList.size() == sortedList.size())
		for (int i = 0; i < mockSortedList.size(); i++) {
			if ((mockSortedList.get(i).getLeft().equals(sortedList.get(i).getLeft()) 
					&& (mockSortedList.get(i).getRight().equals(sortedList.get(i).getRight())))) {
				pass = true;
			} else {
				pass = false;
			}
		}

		assertTrue(pass);
		
		
		// fail("Not yet implemented");
	}

}
