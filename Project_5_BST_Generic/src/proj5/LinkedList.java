package proj5;

/**
 * Linked List is a collection of data nodes.  All methods here relate to
 * how one can manipulate those nodes.
 * @author Pratik Raj
 * @version April 24, 2022.
 * I affirm that I have carried out the attached academic endeavors with full academic honesty,
 * in accordance with the Union College Honor Code and the course syllabus.
 */
public class LinkedList<T>
{
    private int length;          // number of nodes
    private ListNode<T> firstNode;  // pointer to first node

    public LinkedList()
    {
        length=0;
        firstNode=null;
    }

    /** insert new String at linked list's head
     * 
     * @param newData the String to be inserted
     */
    public void insertAtHead(T newData)
    {
    	ListNode<T> newnode = new ListNode<T>(newData);
        if (isEmpty())
        {
            firstNode=newnode;
        }
        else
        {
            newnode.next=firstNode;
            firstNode=newnode;
        }
        length++;
    }
    
    /** remove and return data at the head of the list 
     * 
     *  @return the String the deleted node contains.  Returns null if list empty.
     */
    public T removeHead()
    {
    	if (isEmpty()){
            return null;
        }
        else{
            Object container = (T) firstNode.data;
            firstNode = firstNode.next;
            length--;
            return (T) container;
        }

        // implement me (AFTER writing some tests)!
//    	return "";  // erase this line; it's just here to make it compile
    }
    
    /** insert data at end of list
     * 
     * @param newData new String to be inserted
     */
    public void insertAtTail(String newData)
    {
        // implement me (AFTER writing some tests)!
        ListNode<T> newnode = new ListNode<T>( (T) newData);
        if (isEmpty()){
            firstNode = newnode;
        }
        else{
            ListNode<T> runner = firstNode;
            while(runner.next != null){
                runner = runner.next;
            }
            runner.next = newnode;
        }
        length ++;
    }

    /**
     * search for first occurrence of value and return index where found
     * 
     * @param value string to search for
     * @return index where string occurs (first node is index 0).  Return -1 if value not found.
     */
    public int indexOf(String value)
    {
    	if (isEmpty()){
            return -1;
        }
        else{
            ListNode<T> runner = firstNode;
            int count = 0;
            while(!runner.data.equals(value) && runner.next != null){
                count++;
                runner = runner.next;
            }
            if (!runner.data.equals(value)){
                return -1;
            }
            return count;
        }

    }

    /**
     * Navigate to the index position and return the value at that index
     * @param index
     * @return the value at that index position
     */
    public T valueAtIndex(int index){
        if (isEmpty()){
            return null;
        }
        else{
            ListNode<T> runner = firstNode;
            int count = 0;
            while(count != index && index <= getLength()){
                count ++;
                runner = runner.next;
            }
            return (T) runner.data;
        }
    }
    
    /**
     *  @return return linked list as printable string
     */
    public String toString() 
    {
    	String toReturn="{>";
    	ListNode<T> runner = firstNode;
    	while (runner!=null)
    	{
    		toReturn += runner;  //call node's toString automatically
    		runner = runner.next;
    		if (runner != null)
    		{
    			toReturn += ",";
    		}
    	}
    	toReturn += "}";
    	return toReturn;
    }
    
    /**
     * 
     * @return length of LL
     */
    public int getLength() {return length;}
    
    /**
     * 
     * @return true if LL empty or false if not
     */
    public boolean isEmpty() {return getLength()==0;}

    public Object get_ith_item(int i) {
        ListNode itr  = firstNode;
        while(i-- > 0){
            itr = itr.next;
        }
        return itr.data;
    }
}