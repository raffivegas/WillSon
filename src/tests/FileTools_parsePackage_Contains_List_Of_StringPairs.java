package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import interfaces.IIOHandler;
import logic.FileTools;
import utils.ConfigReader;
import utils.StringPair;

class FileTools_parsePackage_Contains_List_Of_StringPairs {

	// this test requires a valid and populated input file with the path configured in /resources/config.properties
	@Test
	void test() {
		ConfigReader.InitReader();
		List<StringPair> myMockPairs = new ArrayList<StringPair>();
		IIOHandler<StringPair> myMockFile = new FileTools();
		myMockPairs = myMockFile.parsePackage();
		// verify the mock list is not empty.
		assertTrue(!myMockPairs.isEmpty());
		//fail("Not yet implemented");
	}

}
