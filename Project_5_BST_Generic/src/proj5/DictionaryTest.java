package proj5;

/**
 * Test for the Dictionary class.
 */

import org.junit.Test;

import static org.junit.Assert.*;

public class DictionaryTest {

    @Test
    public void insertAndSize(){
        Dictionary dictionary = new Dictionary();
        assertEquals("",dictionary.toString());  //Testing on an empty tree.
        assertEquals(0, dictionary.size()); 
        
        dictionary.insert(new Dictionary.Node("A"));
        dictionary.insert(new Dictionary.Node("C"));
        dictionary.insert(new Dictionary.Node("B"));
        dictionary.insert(new Dictionary.Node("D"));
        
        assertEquals("(  A  ((  B  )  C  (  D  )))", dictionary.toString());//testing after four insertions
        
        assertEquals(4, dictionary.size()); 
        
    }

    @Test
    public void search(){
        Dictionary dictionary = new Dictionary();
        dictionary.insert(new Dictionary.Node("A"));
        dictionary.insert(new Dictionary.Node("F"));
        
        assertEquals(true, dictionary.search(new Dictionary.Node("A"))); 
        assertEquals(false, dictionary.search(new Dictionary.Node("M"))); 
        assertEquals(false, dictionary.search(new Dictionary.Node("B"))); 
        
        dictionary.insert(new Dictionary.Node("X"));
        dictionary.insert(new Dictionary.Node("M"));
        dictionary.insert(new Dictionary.Node("P"));
        
        assertEquals(true, dictionary.search(new Dictionary.Node("M"))); 
        assertEquals(false, dictionary.search(new Dictionary.Node("B"))); 

    }
    
}
