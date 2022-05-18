package proj4;

/**
 * The RightParen class implements Token interface and contains
 * an instance method, handle() which when called can pop and append it to the postfix string all
 * operators on the stack down to the most recently scanned left parenthesis. Then discard
 * this pair of parentheses.
 *
 * @author Pratik Raj
 * @version May 18, 2022
 */
public class RightParen implements Token{

    public String toString(){
        return ")";
    }

    public String handle(Stack<Token> stack) {
       String addToPostfix = "";
       while(!(stack.peek() instanceof LeftParen)){
           addToPostfix += stack.pop().toString();

       }
       stack.pop();
       return addToPostfix;

    }
}
