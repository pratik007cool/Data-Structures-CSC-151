/**
 * Driver for BST demo
 * 
 * @author Chris Fernandes 
 * @version 5/21/22
 */
public class Client
{
    public static void main(String[] args)
    {
        BinarySearchTree testTree = new BinarySearchTree();
        testTree.insert(42);
        testTree.insert(53);
        testTree.insert(31);
        testTree.insert(36);
        testTree.insert(7);
        testTree.insert(92);
        testTree.insert(50);
        System.out.println(testTree);
        
    }
}
