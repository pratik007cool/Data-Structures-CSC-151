package proj4;

import java.io.File;

/**
 * Write a description of class Converter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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

	public <T> String convert() {
		FileReader reader = new FileReader(file);
		String temp = reader.nextToken();
		Stack<Token> a = new Stack<Token>();
		while (!temp.equals("EOF")) {
			if (getToken(temp) != null) {
				(getToken(temp)).handle(a);
				temp = reader.nextToken();
			} else{

			}
			return null;
		}
		return temp;
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
