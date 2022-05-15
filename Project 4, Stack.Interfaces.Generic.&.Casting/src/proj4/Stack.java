package proj4;

// Don't forget the Javadocs!
// Notice that the generic type parameter does NOT implement
// the Token interface.  Make sure you understand why it shouldn't
// (and see the StackTest class for a hint.  Or just ask me!)
public class Stack<T>
{
    public static class Node{
        private String data;
        private Node next;
        private Node(String data){
            this.data = data;
        }
    }
    
    public Stack() {
       
    }

    private Node top;
    public boolean isEmpty() {
        return (size() == 0);
    }

    public void push(String toPush) {
       Node newnode = new Node(toPush);
       newnode.next = top;
       top = newnode;
    }
  
    public T pop() {
        //return 1;
        return null;
    }
  
    public T peek() {
        //return top.data;
        return null;
    }
    
    public int size() {
    	return 1;    //erase this line
    }
     
    public String toString() {
        return "";    //erase this line
    }
    
} 
   

