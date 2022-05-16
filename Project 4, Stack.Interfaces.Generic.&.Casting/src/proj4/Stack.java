package proj4;

// Don't forget the Javadocs!
// Notice that the generic type parameter does NOT implement
// the Token interface.  Make sure you understand why it shouldn't
// (and see the StackTest class for a hint.  Or just ask me!)
public class Stack<T>
{

        public Stack() {
       
    }

    LinkedList<T> list = new LinkedList<T>();
    public boolean isEmpty() {
        return (size() == 0);
    }

    /** insert new element at linked list's head
     *
     * @param toPush the String to be inserted
     */
    public void push(T toPush) {
        list.insertAtHead(toPush);
    }

    /** remove and return data at the head of the list
     *
     *  @return the String the deleted node contains.  Returns null if list empty.
     */
    public T pop() {
        return list.removeHead();
    }

    /**
     * @return the value at the 0 index position
     */
    public T peek() {
        return list.valueAtIndex(0);
    }

    /**
     * @return the size of the list.
     */
    public int size() {
    	return list.getLength();
    }
     
    public String toString() {
        return list.toString();    //erase this line
    }
    
} 
   

