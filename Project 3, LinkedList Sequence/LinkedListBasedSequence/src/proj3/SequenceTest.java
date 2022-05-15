package proj3;

import org.junit.Test;

import static org.junit.Assert.*;

public class SequenceTest {
    @Test
    public void addBeforeTest() {

        Sequence s1 = new Sequence();
        s1.addBefore("A");
        String expected = "{>A} (capacity = 10)";
        assertEquals(expected, s1.toString());

        s1.addBefore("B");
        expected = "{>B, A} (capacity = 10)";
        assertEquals(expected, s1.toString());
    }

    @Test
    public void addAfterTest() {

        Sequence s1 = new Sequence();
        s1.addBefore("B");
        s1.addBefore("A");

        s1.addAfter("C");


        System.out.println(s1.toString());

    }

    @Test
    public void isCurrentTest() {
        Sequence s1 = new Sequence();
        assertEquals(false,s1.isCurrent()); //Before adding elements.
        s1.addBefore("B");
        s1.addBefore("A");
        s1.addAfter("C");
        assertEquals(true,s1.isCurrent()); //after adding elements.

    }

    @Test
    public void getCapacityTest() {
        Sequence s1 = new Sequence();
        assertEquals(10,s1.getCapacity()); // Before adding any elements.
        s1.addBefore("B");
        s1.addBefore("A");
        s1.addAfter("C");
        s1.addBefore("B");
        s1.addBefore("A");
        s1.addAfter("C");
        s1.addBefore("B");
        s1.addBefore("A");
        s1.addAfter("C");
        s1.addBefore("B");
        s1.addBefore("A");
        s1.addAfter("C");
        assertEquals(21,s1.getCapacity()); // after adding more than 10 elements.
    }

    @Test
    public void getCurrentTest() {
        Sequence s1 = new Sequence();
        s1.addBefore("B");
        s1.addBefore("A");
        assertEquals("A",s1.getCurrent()); //added element becomes the current element.

    }

    @Test
    public void addAllTest() {

        Sequence s1 = new Sequence();
        s1.addBefore("B");
        s1.addBefore("A");

        Sequence s2 = new Sequence();
        s2.addBefore("C");


        System.out.println(s1.toString());
        System.out.println(s2.toString());


        s1.addAll(s2);
        System.out.println(s1.toString());



    }

    @Test
    public void testisEmpty(){
        Sequence sequence= new Sequence();
        assertTrue(sequence.isEmpty());
    }



    @Test
    public void testSize(){
        Sequence sequence = new Sequence();
        assertEquals(0, sequence.size());
    }

    @Test
    public void testCapacity(){
        Sequence sequence = new Sequence();
        assertEquals(10, sequence.getCapacity());
    }

    @Test
    public void testGetCurrent(){
        Sequence sequence = new Sequence();
        assertEquals(null, sequence.getCurrent());
    }

    @Test
    public void removeCurrentTest() {

        Sequence s1 = new Sequence();

        s1.addBefore("D");
        s1.addBefore("C");
        s1.addBefore("B");
        s1.addBefore("A");
        s1.advance();
        s1.advance();
        s1.advance();

        System.out.println(s1);
        s1.removeCurrent();
        System.out.println(s1);
        System.out.println(s1.getCurrent());


    }
}