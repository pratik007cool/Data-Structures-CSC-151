package proj5;

public class ListNode<T>
{
    public T data;
    public ListNode next;  
    
    /** Non-default constructor
     * 
     * @param value data for this node
     */
    public ListNode(T value)
    {
        data = value;
        next = null;
    }
    
    /**
     * returns data as a printable string
     */
    public String toString()
    {
        return data.toString();
    }
}
    