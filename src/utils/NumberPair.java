package utils;

public class NumberPair {
	//make private
	  private String left = "";
	  private String right = "";

	  
	  public NumberPair(String left, String right)
	  {
	     this.setLeft(left);
	     this.setRight(right);
	  }


	public NumberPair() {
		// TODO Auto-generated constructor stub
		
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
