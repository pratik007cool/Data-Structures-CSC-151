package proj4;

/**
 * The Semicolon class implements Token interface and contains
 * an instance method, handle() which when called indicates that
 * the infix expression has been completely scanned all remaining
 * operators should be popped and appended to the postfix string.
 *
 * @author Pratik Raj
 * @version May 18, 2022
 */

public class Semicolon implements Token {

    public String handle(Stack<Token> stack) {
        String addToPostfix = "";
        while (!stack.isEmpty()) {
            addToPostfix += stack.pop().toString();
        }
        return addToPostfix;
    }
    public String toString(){
        return ";";
    }
}
