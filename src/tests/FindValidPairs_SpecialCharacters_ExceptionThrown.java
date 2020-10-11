package tests;
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
		List<NumberPair> mockList = new ArrayList<NumberPair>();
		NumberPair mockPair = new NumberPair("43%34", "12313");		
		mockList.add(mockPair);
		IIOHelper myHelper = new FileHelper();
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void test() {
		IIOHelper myHelper = new FileHelper();
		fail("Not yet implemented");
	}

}
