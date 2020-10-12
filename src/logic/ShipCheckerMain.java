package logic;
import interfaces.IIOHelper;
import utils.ConfigReader;
import interfaces.ICruncher;

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

		IIOHelper myFile = new FileHelper();
		ICruncher myPairs = new ZipcodeCruncher();
		
		ConfigReader.InitReader();
		// parsePackage parses the input, sortPairs sorts the input, findFinalPairs gets the final list
		// sendPackage outputs the results.
		myFile.sendPackage(myPairs.findFinalPairs(myPairs.sortPairs(myFile.parsePackage())));
		
		
		// this may be easier to read if done this way:
		// List<NumberPair> parsedList = new ArrayList<NumberPair>();
		// List<NumberPair> sortedList = new ArrayList<NumberPair>();
		// List<NumberPair> finalList = new ArrayList<NumberPair>();
		// parsedList.addAll(myHelper.parsePackage());
		// sortedList.addAll(myOutput.sortPairs(parsedList));
		// finalList.addAll(sortedList);
		// myHelper.sendPackage(finalList);
		
		// parsedList.clear();
		// sortedList.clear();
		// finalList.clear();

	}

}
