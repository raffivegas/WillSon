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
		System.out.println("test");
		List<NumberPair> finalList = new ArrayList<NumberPair>();
		
		IIOHelper myChecker = new FileHelper();
		ICruncher myOutput = new ZipcodeFactory();
		
		finalList = myOutput.findValidPairs(myOutput.sortPairs(myChecker.parsePackage()));
		/*
		 * finalList = myOutput.sortPairs(finalList); finalList =
		 * myOutput.findValidPairs(finalList);
		 */
		

	}

}
