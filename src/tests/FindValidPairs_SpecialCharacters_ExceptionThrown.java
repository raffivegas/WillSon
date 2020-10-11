package tests;
import logic.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import interfaces.IIOHelper;
import utils.ConfigReader;

import interfaces.ICruncher;
import utils.NumberPair;


class FindValidPairs_SpecialCharacters_ExceptionThrown {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		try {
		// needs at least 2 pairs to sort.
		List<NumberPair> mockList = new ArrayList<NumberPair>();
		mockList.add(new NumberPair("43%34", "1213"));
		mockList.add(new NumberPair("43034", "1213"));
		//IIOHelper myHelper = new FileHelper();
		ICruncher mockCruncher = new ZipcodeCruncher();
		mockCruncher.sortPairs(mockList);
		fail("Exception not thrown.");
		}catch (NumberFormatException e) {
			assertEquals(e, e);		
		}
	}

}
