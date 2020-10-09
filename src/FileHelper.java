import interfaces.IIOHelper;
import utils.NumberPair;

import java.io.BufferedReader;
import java.io.File; // Import the File class
import java.io.FileInputStream;
import java.io.FileNotFoundException; // Import this class to handle errors
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files

public class FileHelper implements IIOHelper {

	@Override
	public boolean isValid() {

		return true;

	}

	@Override
	public List<NumberPair> parsePackage() {

		List<NumberPair> list = new ArrayList<NumberPair>();

		// disclaimer - I copied this code (how to read a file) off the net and modified
		// it.

		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream("C:\\Users\\Raffi\\Desktop\\ZipChecker\\zipcodes.txt"), "UTF8"));

			String line;
			String left = "";
			String right = "";
			boolean grabLeft = false;
			boolean grabRight = false;
			boolean begin = false;

			while ((line = br.readLine()) != null) {

				for (int i = 0; i < line.length(); i++) {
					// System.out.println("Char at: " + line.charAt(i));
					if (i != 0) {
						if (line.charAt(i - 1) == '[') {
							begin = true;
						}
					}

					if (line.charAt(i) == '[') {
						grabLeft = true;
						// i++;
					}

					if (grabLeft == true && begin == true) {
						if (line.charAt(i) == ',') {
							grabLeft = false;
							grabRight = true;
							i++;
						} else {
							left = left + line.charAt(i);
						}
					}
					if (grabRight == true) {
						if (line.charAt(i) != ']') {
							right = right + line.charAt(i);
						} else {

							// i++;
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
				for (NumberPair test : list) {
					System.out.println(test.getLeft() + "," + test.getRight());
				}

			}
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

		// NumberPair mytest = new NumberPair(1,2);
		return list;
	}

	@Override
	public List<NumberPair> validList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void sendPackage() {
		// TODO Auto-generated method stub
		
	}

}
