package proj4;

/**
 * Write a description of class Plus here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Plus implements Token,Operator {

    int Precedence = 1;
    public String toString() {
    	return "erase this";
    }

    String Postfix;
    public String handle(Stack<Token> s)
    {
        
    	return "erase this";
    }
    public int getPrecedence(){
        return Precedence;
    }
}
