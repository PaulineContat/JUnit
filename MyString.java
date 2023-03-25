import java.util.ArrayList;
import java.util.Arrays;

public class MyString {

	private final static ArrayList<Character> voyelles = new ArrayList<>(Arrays.asList('a','e','i','o','u'));
	private StringBuffer sb;

	public MyString(String s) {
		this.sb = new StringBuffer(s);
	}

	public String getString() { 
		return this.sb.toString();
	}

	public void setString(String s) { 
		this.sb = new StringBuffer(s);
	}

	public void sbToUpperCase() {
		for (int i = 0; i<this.sb.length(); i++) {
			char c = Character.toUpperCase(this.sb.charAt(i));
			this.sb.setCharAt(i, c);
		}
	}

	public int getOccurence(char c) {
		int occurence = 0;
		for (int i = 0; i<this.sb.length(); i++) {
			if (this.sb.charAt(i)==c) {
				occurence++;
			}
		}
		return occurence;
	}

	public int getNbVoyelles() {
		int nbVoy = 0;
		for (int i = 0; i<this.sb.length(); i++) {
			for (int j = 0; j<MyString.voyelles.size(); j++) {
				if(this.sb.charAt(i)==MyString.voyelles.get(j)) {
					nbVoy++;
				}
			}
		}
		return nbVoy;	
	}

	public String getPremierMot() {
		int finPremierMot = this.sb.lastIndexOf(" ");
		if(finPremierMot==-1) {
			finPremierMot = this.sb.length();
		}
		return this.sb.substring(0, finPremierMot);
	}
}
