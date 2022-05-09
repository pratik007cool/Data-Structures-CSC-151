package proj3;

import java.util.List;

/**
 *  Fill this in.  Really.  And the methods too.
 */
public class LinkedList
{
    private int length;
    private ListNode firstNode;

    public LinkedList()
    {
        length=0;
        firstNode=null;
    }

    public int getLength()
    {
        return length;
    }

    public void insertAtHead(String data)
    {
        ListNode newnode = new ListNode(data);
        if (getLength() == 0)
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

    public void insertAtIndex(String data, int index){

        ListNode runner = this.firstNode;
        ListNode newNode = new ListNode(data);

        if(index == 0){
            insertAtHead(data);
        }else{
            int count = 0;
            while(runner.next != null){

                if(count == index-1){
                    newNode.next = runner.next;
                    runner.next = newNode;
                    break;
                }
                runner = runner.next;
                count++;
            }
        }

        length++;
    }


    public void insertAtTail(String data){

        ListNode newnode = new ListNode(data);

        if(getLength() == 0){
            firstNode = newnode;
        }else{
            ListNode runner = firstNode;
            while(runner.next != null){
                runner = runner.next;
            }
            runner.next = newnode;
        }
        length++;

    }


    /**
     * returns the ith item in the list (where first item is index 0)
     * @return the data inside the node at given index. Return null if not there.
     */
    public String get_ith_item(int index){
        if (index >= getLength() || index < 0){
            return null;
        }
        else {
            ListNode runner = this.firstNode;
            int count = 0;

            while(runner.next != null){
                if(count == index){
                    break;
                }
                runner = runner.next;
                count++;
            }
            return runner.data;
        }
    }

    /**
     * delete the ith item of the proj3.LinkedList.
     * @return
     */
    public void remove(int i){
        ListNode runner = firstNode;
        int count = 0;

        if(i == 0){
            firstNode = firstNode.next;
        }else{
            while(runner.next != null){

                if(count == length-1){
                    runner = null;
                    break;
                }
                if(count == i-1){
                    runner.next = runner.next.next;
                    break;
                }
                count++;
                runner = runner.next;
            }
        }


        length--;
    }





    public String toString(){
        String toReturn = "(";
        ListNode runner = firstNode;
        while(runner != null){
            toReturn = toReturn + runner;
            runner = runner.next;
            if(runner != null){
                toReturn = toReturn + ", ";
            }
        }
        toReturn = toReturn + ")";
        return toReturn;
    }

}


