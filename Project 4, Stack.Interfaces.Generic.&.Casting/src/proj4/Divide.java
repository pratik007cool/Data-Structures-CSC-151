package proj4;

/**
 * Write a description of class Divide here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Divide implements Token, Operator, Comparable<Operator>{
    int Precedence = 2;
    public String handle(Stack<Token> stack){
        String addToPostfix = "";
        while (!(stack.isEmpty() || (stack.peek()instanceof LeftParen) || compareTo((Operator)stack.peek()) < 1)){
            addToPostfix += stack.pop().toString();
        }
        stack.push(this);
        return addToPostfix;
    }
    public int getPrecedence(){
        return Precedence;
    }

    public int compareTo(Operator c){
        if (this.getPrecedence() > c.getPrecedence()){
            return 1;
        }
        if (this.getPrecedence() == c.getPrecedence()){
            return 0;
        }
        else{
            return -1;
        }

    }

}
