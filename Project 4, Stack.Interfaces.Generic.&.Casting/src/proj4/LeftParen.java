package proj4;

/**
 * The LeftParen class implements Token interface and contains
 * an instance method, handle() which when called can push it onto the stack.
 *
 * @author Pratik Raj
 * @version May 18, 2022
 */
public class LeftParen implements Token{

    public String toString(){
        return "(";
    }

    /**
     * handle() method dictate how to process the token when it is encountered.
     * @param stack the Stack the token uses, if necessary, when processing itself.
     * @return ""
     */
    public String handle(Stack<Token> stack){
        stack.push(this);
        return "";
    }
}
