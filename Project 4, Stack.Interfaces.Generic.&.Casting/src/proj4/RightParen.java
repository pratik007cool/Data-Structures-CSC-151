package proj4;

/**
 * Write a description of class RightParen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RightParen implements Token{


    public String handle(Stack<Token> stack) {
       String addToPostfix = "";
       while(!stack.peek().equals("(")){
           addToPostfix += stack.pop();

       }
       stack.pop();
       return addToPostfix;

    }
}
