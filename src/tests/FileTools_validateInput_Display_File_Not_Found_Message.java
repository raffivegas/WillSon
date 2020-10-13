package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import logic.FileTools;
import utils.ConfigReader;

// you have to put a bad file name in /resources/config.properties for this test to pass.
class FileTools_validateInput_Display_File_Not_Found_Message {

	@Test
	void test() {
		ConfigReader.InitReader();
		FileTools fileNotFound = new FileTools();
		assertFalse(fileNotFound.validateInput());
		//fail("Not yet implemented");
	}

}
