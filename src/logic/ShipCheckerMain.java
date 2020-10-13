package logic;
import interfaces.IIOHandler;
import utils.ConfigReader;
import utils.StringPair;
import interfaces.IPairHandler;

/**
 * 
 */

/**
 * @author Raffi
 * Main class, calls all the logic.
 */
public class ShipCheckerMain {

	/**
	 * @author Raffi
	 * go time.
	 */
	public static void main(String[] args) {

		IIOHandler<StringPair> myFile = new FileTools();
		IPairHandler<StringPair> myPairs = new ZipcodeCruncher();
		
		// static config class
		ConfigReader.InitReader();
		
		// if the validation passes, parsePackage parses the input, sortPairs sorts the input,
		// findFinalPairs gets the final listsendPackage outputs the results.
		if(myFile.validateInput()) {
		myFile.sendPackage(myPairs.findFinalPairs(myPairs.sortPairs(myFile.parsePackage())));
		}		

	}

}
