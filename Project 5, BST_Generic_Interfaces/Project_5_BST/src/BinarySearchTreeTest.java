import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This is a BST test class. It is mainly testing
 * the insert, search and size function.
 */
public class BinarySearchTreeTest {

    /**
     * Testing the insert function.
     * Checking the size after each insertion.
     * Also checking the insert function using toString.
     */
    @Test
    public void recursiveInsert() {
        BinarySearchTree BST = new BinarySearchTree();
        assertEquals("",BST.toString());  //Testing on an empty tree.
        BST.recursiveInsert("5");
        BST.recursiveInsert("6");
        assertEquals("(  5  (  6  ))", BST.toString()); // Testing after two insertion.
        BST.recursiveInsert("6");
        assertEquals(3, BST.size()); // Testing the size after insertion.
    }

    /**
     * Testing if the search function.
     * If target is present it should,
     * return True otherwise false.
     */
    @Test
    public void search() {
        BinarySearchTree BST = new BinarySearchTree();
        assertEquals(false,BST.search("0"));  //Testing on an empty tree.
        BST.insert("5");
        BST.insert("6");
        assertEquals(true,BST.search("5")); // Testing after two insertion.
        BST.insert("6");
        assertEquals(true,BST.search("6")); // Testing after three insertion.
    }

    /**
     * Testing the size of the
     * BST after each insertion.
     */
    @Test
    public void size() {
        BinarySearchTree BST = new BinarySearchTree();
        assertEquals(0,BST.size());  //Testing on an empty tree.
        BST.insert("5");
        BST.insert("6");
        assertEquals(2,BST.size()); // Testing after two insertion.
        BST.insert("6");
        assertEquals(3,BST.size()); // Testing after three insertion.
    }
    @Test
    public void delete() {
        BinarySearchTree BST = new BinarySearchTree();

        BST.recursiveInsert("5");
        BST.recursiveInsert("6");
        BST.insert("7");
        BST.insert("8");
        BST.insert("9");
        BST.insert("10");
        System.out.println(BST.toString());
        BST.delete(6);
        System.out.println(BST.toString());
        //BST.insert("7");
        assertEquals(5, BST.size());

    }
}