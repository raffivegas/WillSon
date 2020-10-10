import interfaces.IIOHelper;
import utils.NumberPair;

import java.util.ArrayList;
import java.util.List;

import interfaces.ICruncher;

/**
 * 
 */

/**
 * @author Raffi
 *
 */
public class ShipCheckerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<NumberPair> finalList = new ArrayList<NumberPair>();
		
		IIOHelper myHelper = new FileHelper();
		ICruncher myOutput = new ZipcodeFactory();
		
		myHelper.sendPackage(myOutput.findFinalPairs(myOutput.sortPairs(myHelper.parsePackage())));
		

	}

}
