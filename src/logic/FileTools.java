package logic;

import utils.ConfigReader;
import utils.StringPair;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import interfaces.IIOHandler;
//TODO add an exception handler formatter/logger class to be able to do something meaningful with exceptions.

/**
 * @author Raffi 
 * Class to validate, read and send a file.
 */
public class FileTools implements IIOHandler<StringPair> {

	/**
	 * @author Raffi 
	 * This method consumes a file (via FileInputStream) and returns a parsed list of zipcode ranges.
	 */
	@Override
	public List<StringPair> parsePackage() {

		List<StringPair> list = new ArrayList<StringPair>();

		try {
			// reads config file for input file location (tab delimited file containing zipcode pairs)
			// [55656,73343] [42342,45654]
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(ConfigReader.getMyProperties().getProperty("filePath")), "UTF8"));

			String line = "";
			String left = "";
			String right = "";
			boolean grabLeft = false;
			boolean grabRight = false;
			boolean begin = false;

			// loop and look for left bracket, get numbers up to comma, then get numbers after comma
			// ending at right bracket, until no more new left bracket in stream.
			while ((line = br.readLine()) != null) {

				for (int i = 0; i < line.length(); i++) {

					// found a left bracket, we need to grab the characters which will
					// represent the left part of the set/pair on the successive loops.
					if (line.charAt(i) == '[') {
						grabLeft = true;
					}

					// 'begin' flag to know we're past a left bracket to start capturing characters.
					// The 'not 0' check is there because on the initial run we want to make sure
					// we're past the first character of the stream or else i - 1 will throw an exception.
					if (i != 0) {
						if (line.charAt(i - 1) == '[') {
							begin = true;
						}
					}

					// make sure we're past the bracket and we can begin grabbing the left values.
					if (grabLeft == true && begin == true) {
						// we want to grab left values until we hit a comma.
						if (line.charAt(i) == ',') {
							// we're at a comma, i++ to move the cursor to the next character,
							// which will be the beginning of the number to the right side of
							// the comma.
							grabLeft = false;
							grabRight = true;
							i++;
						} else {
							// continue concatenating chars for left value.
							left = left + line.charAt(i);
						}
					}
					if (grabRight == true) {
						if (line.charAt(i) != ']') {
							// we're not at the end of the pair, concatenate the right number.
							right = right + line.charAt(i);
						} else {
							// we've reached the end of a pair of numbers, add the number pair to our list.
							// The List will hold duplicates.
							list.add(new StringPair(left, right));
							// reset flags and vars, rinse and repeat.
							grabLeft = false;
							grabRight = false;
							begin = false;
							left = "";
							right = "";
						}
					}
				}
			}
			// reset var
			line = "";
			br.close();

		} catch (IOException e) {
			// TODO implement a class which outputs a message to the user.
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "ZIP code validator", JOptionPane.INFORMATION_MESSAGE);
		}

		return list;
	}

	/**
	 * @author Raffi This method validates the input stream. Should give a useful
	 *         notification to the user of what is wrong in the event validation
	 *         fails.
	 */
	@Override
	public boolean validateInput() {
		boolean pass = false;
		try {
			// checks if a file exists. If there is no file, it won't pass and will output a
			// relevant message to the user. This can be extended to cover a multitude of validation
			// scenarios like checking for formatting, special characters, etc. Writing this code 
			// is out of scope for the current project.
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new FileInputStream(ConfigReader.getMyProperties().getProperty("filePath")), "UTF8"));

			// check if file is empty
			if (br.readLine() == null) {
				pass = false;
				JOptionPane.showMessageDialog(null, "Input file is empty.", "ZIP code validator",
						JOptionPane.INFORMATION_MESSAGE);
			} else {
				pass = true;
			}

		} catch (IOException e) {
			// TODO implement a class which outputs a message to the user.
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, e.getMessage(), "ZIP code validator", JOptionPane.INFORMATION_MESSAGE);
		}

		return pass;

	}

	/**
	 * @author Raffi 
	 * This method outputs or "ships" the results. If this was using a
	 * REST API to send, it might handle formatting or serializing of the
	 * package to send to an endpoint.
	 */
	@Override
	public void sendPackage(List<StringPair> finalList) {

		String myOutputString = "Can't ship to Zipcodes within the following ranges:\n";

		try {
			System.out.println("Can't ship to Zipcodes within the following ranges:");
			// add final sorted pairs to the string
			for (StringPair raf : finalList) {
				System.out.println(raf.getLeft() + ", " + raf.getRight());
				myOutputString += raf.getLeft() + ", " + raf.getRight() + "\n";
			}

			// output the results to the user. Will need to add JTextArea embedded in a
			// JScrollPane if the messages get too long.
			JOptionPane.showMessageDialog(null, myOutputString, "ZIP code validator", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e) {
			// TODO implement a class which outputs a message to the user.
			e.printStackTrace();
		}

	}

}
