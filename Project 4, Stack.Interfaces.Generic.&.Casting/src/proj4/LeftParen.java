package proj4;

/**
 * Write a description of class LeftParen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LeftParen implements Token{

    public String handle(Stack<Token> stack){
        stack.push(this);
        return "";
    }
}
