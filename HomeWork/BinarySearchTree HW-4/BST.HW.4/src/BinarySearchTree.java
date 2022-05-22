/** This is the BST ADT.  It should contain methods that allow it to
 *  insert new nodes, delete nodes, search, etc.  You'll be adding
 *  code to this class for this hwk.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BinarySearchTree
{
     private BSTNode root;
          
     public BinarySearchTree() {
    	 root=null; 
     }
     
     /**
      * inserts recursively.  I include this one so you can
      * make your own trees in your own testing class
      * 
      * @param startingNode inserts into subtree rooted at staringNode
      * @param newNode node to insert
      * @return startingNode with newNode already inserted
      */
     private BSTNode recursiveInsert(BSTNode startingNode, BSTNode newNode) {
    	 if (startingNode == null) {
    		 return newNode;
    	 }
    	 else if (startingNode.key.compareTo(newNode.key) < 0) {
    		 startingNode.rlink = recursiveInsert(startingNode.rlink,newNode);
    		 return startingNode;
    	 }
    	 else {  // startingNode.key bigger than newNode.key, so newNode goes on left
    		 startingNode.llink = recursiveInsert(startingNode.llink,newNode);
    		 return startingNode;
    	 }
     }

    /**
     * inserts recursively. Use this in your JUnit tests to
     * build a starting tree correctly
     *
     * @param newString String to insert
     */
    public void recursiveInsert(String newString){
        BSTNode newNode = new BSTNode(newString);
        root = recursiveInsert(root, newNode);
    }

    /**
     * Inserts value into the BST.
     * @param startingNode, value
     */
    private BSTNode insert(BSTNode startingNode, BSTNode value){
        if (startingNode == null){
            return value;
        }
        //BSTNode parent = null;
        BSTNode current = startingNode;
        while(current.isLeaf()){
            if (current.key.compareTo(value.key) < 0 ){

                if (current.hasRightChildOnly()){

                }
                else{
                    current = value;
                }
            }
        }

        return current;
    }

    public void insert(String value)
    {

    }

    public boolean search(String target)
    {
        // Returns true if the target string is in the BST.
        // Returns false otherwise.
        // Write the recursive version. You'll need a private helper.
        // Think: What's the base case and recursive case here?
        return false;
    }


    public int size()
    {
        // Returns the number of data items (nodes) in the tree.
        // Write this recursively, so you'll need a private helper.
        // You are NOT permitted to add any other instance variables
        // to the starter code.
        return 0;
    }


    /**
     * return tree as printable string
     * @return tree in string format with form (left subtree) value (right subtree)
     */
    public String toString(){
        return toString(root);
    }

    /**
     * recursive helper method for toString()
     *
     * @param N root of subtree to make into a string
     * @return string version of tree rooted at N
     */
    private String toString(BSTNode N){
        String ret = "";
        if (N != null){
            ret += "(";
            ret += toString(N.llink);
            ret += "  " + N + "  ";
            ret += toString(N.rlink);
            ret += ")";
        }
        return ret;
    }

}
