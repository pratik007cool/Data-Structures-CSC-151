package proj4;

/**
 * The Plus class implements Token, Operator and Comparable<Operator> interface
 * and contains an instance method, handle() which when called can push it onto the stack,
 * until one of the following condition occurs:
 * 1. the stack is empty
 * 2. the top of the stack is a left parenthesis (which stays on the stack)
 * 3. the operator on top of the stack has a lower precedence than the current operator
 * @author Pratik Raj
 * @version May 18, 2022
 */
public class Plus implements Token, Operator, Comparable<Operator> {

    int Precedence = 1;

    /**
     * handle() method dictate how to process the token when it is encountered.
     * @param stack the Stack the token uses, if necessary, when processing itself.
     * @return Postfix String
     */
    public String handle(Stack<Token> stack) {
        String addToPostfix = "";
        while (!(stack.isEmpty() || (stack.peek() instanceof LeftParen) || compareTo((Operator)stack.peek()) < 0)) {
            addToPostfix += stack.pop().toString();
        }
        stack.push(this);
        return addToPostfix;
    }

    public int getPrecedence() {
        return Precedence;
    }

    public String toString(){
        return "+";
    }

    public int compareTo(Operator c) {
        if (this.getPrecedence() > c.getPrecedence()) {
            return 1;
        }
        if (this.getPrecedence() == c.getPrecedence()) {
            return 0;
        } else {
            return -1;
        }
    }
}
