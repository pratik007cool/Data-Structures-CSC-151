package proj2;
/**
 * JUnit test class.
 */
import org.junit.*;
import org.junit.rules.Timeout;
import static org.junit.Assert.*;

import proj2.Sequence;

public class TestSequence {

    @Rule // a test will fail if it takes longer than 1/10 of a second to run
    public Timeout timeout = Timeout.millis(100);

    @Test
    public void testisEmpty(){
        Sequence sequence= new Sequence();
        assertTrue(sequence.isEmpty());
    }

    @Test
    public void testStart(){
        Sequence sequence = new Sequence();
        assertFalse(sequence.start());
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






}




