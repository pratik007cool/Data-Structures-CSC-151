package proj4;

// Don't forget the Javadocs!
// Notice that the generic type parameter does NOT implement
// the Token interface.  Make sure you understand why it shouldn't
// (and see the StackTest class for a hint.  Or just ask me!)
public class Stack<T>
{

        public Stack() {
       
    }

    LinkedList list = new LinkedList();
    public boolean isEmpty() {
        return (size() == 0);
    }

    public void push(T toPush) {
        list.insertAtHead(toPush);
    }
  
    public T pop() {
        return (T) list.removeHead();
    }
  
    public T peek() {
        return null;
    }
    
    public int size() {
    	return 1;    //erase this line
    }
     
    public String toString() {
        return "";    //erase this line
    }
    
} 
   

