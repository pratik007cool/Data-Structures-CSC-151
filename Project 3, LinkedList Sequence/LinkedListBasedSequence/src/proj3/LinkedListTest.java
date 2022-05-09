package proj3;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedListTest {


    //GitHub Cloud Push
    @Test
    public void getLength() {
    }


    @Test
    public void insertAtIndex() {
        LinkedList l1 = new LinkedList();
        l1.insertAtHead("1");
        l1.insertAtHead("2");
        l1.insertAtHead("3");

        l1.insertAtIndex("C", 2);

        assertEquals("2", l1.get_ith_item(1));
        assertEquals("C", l1.get_ith_item(2));
        assertEquals("1", l1.get_ith_item(3));

    }

    @Test
    public void get_ith_item() {

        LinkedList l1 = new LinkedList();
        l1.insertAtHead("1");
        l1.insertAtHead("2");
        l1.insertAtHead("3");
        l1.insertAtHead("4");
        l1.insertAtHead("5");
        l1.insertAtHead("6");
        l1.insertAtHead("7");

        assertEquals("1", l1.get_ith_item(6));
    }

    @Test
    public void removeTest() {

        LinkedList l1 = new LinkedList();
        l1.insertAtHead("1");
        l1.insertAtHead("2");
        l1.insertAtHead("3");
        l1.insertAtHead("4");
        l1.insertAtHead("5");
        l1.insertAtHead("6");
        l1.insertAtHead("7");

        System.out.println(l1.toString());
        l1.remove(6);
        System.out.println(l1.toString());
    }

}