import interfaces.IInputValidator;
import utils.NumberPair;

import java.io.BufferedReader;
import java.io.File;  // Import the File class
import java.io.FileInputStream;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files

public class FileFormatChecker implements IInputValidator {
	
	public boolean isValid() {

		return true;
		
	}
	
	public List<NumberPair> parsePackage() {
		
		List<NumberPair> list = new ArrayList<NumberPair>();
		//MultiValuedMap<String, String> map = new ArrayListValuedHashMap<>();
		
		//disclaimer - I copied this code (how to read a file) off the net and modified it.
		try {
		      File myObj = new File("C:\\Users\\Raffi\\Desktop\\ZipChecker\\zipcodes.txt");
		      Scanner myReader = new Scanner(myObj);
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        System.out.println(data);
		      }
		      myReader.close();
		    } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		try {
		    BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("C:\\Users\\Raffi\\Desktop\\ZipChecker\\zipcodes.txt"), "UTF8"));

		    String line;
		    String left = "";
	    	String right = "";
	    	boolean grabLeft = false;
	    	boolean grabRight = false;
	    	boolean begin = false;
	    	
		    while ((line = br.readLine()) != null) {
		    	
		    for (int i = 0; i < line.length(); i++) {
		        //System.out.println("Char at: " + line.charAt(i));
	    		if(i != 0)
	    		{
	    			if (line.charAt(i - 1) == '[') {
	    				begin = true;
	    			}
	    		}
	    		
		    	if (line.charAt(i) == '[') {
		    		grabLeft = true;
		    		//i++;
		    	}
		    	

		    	
		    	if (grabLeft == true && begin == true) {
		    		if (line.charAt(i) == ',')
		    		{
		    			grabLeft = false;
		    			grabRight = true;
		    			i++;
		    		}
		    		else {
		    			left = left + line.charAt(i);
		    		}
		    	}
		    	if (grabRight == true) {
		    		if (line.charAt(i) != ']')
		    		{
		    			right = right + line.charAt(i);
		    		}
		    		else
		    		{

		    			//i++;
		    			list.add(new NumberPair(left, right));
		    			grabLeft = false;
		    			grabRight = false;
		    			begin = false;
		    			left = "";
		    			right = "";
		    		}		
		    		

		    	}
		    	

		    	
		    }
		    System.out.println("Another line");
		    for(NumberPair test:list) {
		    	System.out.println(test.left + "," + test.right);
		    }
		    
		    }
		    br.close();

		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		
		//NumberPair mytest = new NumberPair(1,2);
		return list;
	}
	

}
