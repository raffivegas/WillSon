package utils;

/**
 * @author Raffi
 * An object which holds a pair of strings.
 * The strings are cast to int elsewhere.
 */
public class NumberPair {

	private String left = "";
	private String right = "";

	public NumberPair(String left, String right) {
		this.setLeft(left);
		this.setRight(right);
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

}
