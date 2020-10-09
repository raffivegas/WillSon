import interfaces.IIOHelper;
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
		
		IIOHelper myChecker = new FileHelper();
		ICruncher myOutput = new ZipcodeFactory();
		
		myOutput.findValidPairs(myChecker.parsePackage());
		
		

	}

}
