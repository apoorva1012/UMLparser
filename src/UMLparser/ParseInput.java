package UMLparser;

public class ParseInput {
	public static void main (String [] args) {
		if(args[0].equals("class")) {
			Parser pe = new Parser(args[1], args[2]);
		}
	}
}
