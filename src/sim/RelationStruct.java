package sim;

import java.util.Arrays;

public class RelationStruct {
    String lexicon_String;
    public RelationStruct() {
		// TODO Auto-generated constructor stub
    	
	}
	public String getLexicon_String() {
		return lexicon_String;
	}
	public void setLexicon_String(String lexicon_String) {
		this.lexicon_String = lexicon_String;
	}

	public static void main(String[] args) {
		double[][] a = new double[3][2];
		for (int i = 0; i < 3; i++) {
			System.out.println(Arrays.toString(a[i]));
		}

	}
}
