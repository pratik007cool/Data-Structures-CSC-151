package proj4;

/**
 * Write a description of class Divide here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Divide implements Token{
    int Precedence = 2;
    public String handle(Stack<Token> stack){
        stack.push(this);
        return "";
    }
    public int getPrecedence(){
        return Precedence;
    }

}
