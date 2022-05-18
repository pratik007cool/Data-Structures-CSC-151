package proj4;

import java.io.File;

/**
 * The Converter class contains an instance method, convert(),
 * that reads in a token, identifies it, makes a new Token type from it,
 * and then calls the item's handle() method to take care of it. It repeats this
 * process until all tokens have been read and processed.
 *
 * @author Pratik Raj
 * @version May 18, 2022
 */
public class Converter {

	private String file;
	/**
	 * non-default constructor; Gradescope needs this to run tests
	 * @param infile path to the input file 
	 */
    public Converter(String infile)
    {
        file = infile;
    }

	public String convert() {
		String Postfix = "";
		String Print = "";
		FileReader reader = new FileReader(file);

		String temp = reader.nextToken();
		Stack<Token> a = new Stack<Token>();

		while (!temp.equals("E")) {
			if (getToken(temp) != null) {
				if(!temp.equals(";")){
					Print += temp;}
				Postfix += (getToken(temp)).handle(a);
				temp = reader.nextToken();
			} else{
				Print += temp;
				Postfix += temp;
				temp = reader.nextToken();
			}
		}
		String C = Print+ " --> "+ Postfix;
		System.out.println(C);
		return C;
		//return Postfix;
	}

	private Token getToken(String token){
		if ("+".equals(token)){
			return new Plus();
		}
		if("-".equals(token)){
			return new Minus();
		}
		if ("*".equals(token)){
			return new Multiply();
		}
		if ("/".equals(token)){
			return new Divide();
		}
		if ("^".equals(token)){
			return new Exponent();
		}
		if ("(".equals(token)){
			return new LeftParen();
		}
		if (")".equals(token)){
			return new RightParen();
		}
		if (";".equals(token)){
			return new Semicolon();
		}
		return null;
	}

}
