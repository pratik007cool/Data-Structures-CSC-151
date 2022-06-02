package proj5;

/** This is the BST ADT.  It should contain methods that allow it to
 *  insert new nodes, delete nodes, search, etc.  You'll be adding
 *  code to this class for this hwk.
 *
 * @author Pratik Raj
 * @version Jun 1, 2022.
 *  I affirm that I have carried out the attached academic endeavors with full academic honesty,
 *  in accordance with the Union College Honor Code and the course syllabus.
 */

public class BinarySearchTree<T extends Comparable<T>> {
     private BSTNode<T> root;
          
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
    public void recursiveInsert(T newString){
        BSTNode<T> newNode = new BSTNode(newString);
        root = recursiveInsert(root, newNode);
    }



    /**
     * Inserts value into the BST.
     * @param value, startingNode
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

    /**
     * Inserts value into the BST.
     * @param value
     */
    public void insert(T value)
    {
        BSTNode newNode = new BSTNode(value);
        boolean isInserted = false;
        if (root == null) {
            root = newNode;
            isInserted = true;
        }
        BSTNode current = root;
        while (!isInserted) {
            if (current.key.compareTo(newNode.key) > 0) {
                if (current.llink == null) {
                    current.llink = newNode;
                    isInserted = true;
                }else{
                    current = current.llink;
                }

            } else if (current.rlink == null) {
                current.rlink = newNode;
                isInserted = true;
            } else {
                current = current.rlink;
            }

        }
    }

    /**
     *  Returns true if the target string is in the BST.
     *  Returns false otherwise.
     *  Write the recursive version. You'll need a private helper.
     *  Think: What's the base case and recursive case here?
     * @param target, root
     * @return true/false
     */
    private boolean search(BSTNode root, T target)
    {
        if(root == null){
            return false;
        }
        if (root.key.equals(target)){
            return true;
        }
        else if (root.key.compareTo(target) > 0) {
            return search(root.llink, target);
        } else {
            return search(root.rlink, target);
        }
    }

    /**
     *
     * @param target
     * @return true/false
     */
    public boolean search(T target){
        return search(root, target);
    }

    /**
     *  Returns the number of data items (nodes) in the tree.
     *  Write this recursively, so you'll need a private helper.
     *  You are NOT permitted to add any other instance variables
     *  to the starter code.
     * @return no. of data items.
     */
    private int size(BSTNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftSize = size(root.llink);
            int rightSize = size(root.rlink);
            return leftSize + rightSize + 1;
        }

    }

    /**
     * Figure out the size of BST.
     * @return size
     */
    public int size(){
        return size(root);
    }

    private BSTNode<T> maxValue(BSTNode root){
        BSTNode current = root;
        while(current.rlink != null){
            current = current.rlink;
        }
        return current;
    }

    /**
     * This method will delete a node from the BST.
     * @param subroot
     * @param value
     * @return
     */
    private BSTNode<T> delete(BSTNode<T> subroot, T value){
        if (subroot == null){
            return null;
        }
        else if (subroot.key.compareTo(value) < 0){
            subroot.rlink = delete(subroot.rlink, value);
            return subroot;
        }
        else if (subroot.key.compareTo(value) > 0){
            subroot.llink = delete(subroot.llink, value);
            return subroot;
        }
        else{
            if (subroot.isLeaf()) {
                return null;
            }
            else if (subroot.hasRightChildOnly()){
                return subroot.rlink;
            }
            else if (subroot.hasLeftChildOnly()){
                return subroot.llink;
            }
            else {
                subroot.key = maxValue(subroot.llink).key;
                subroot.llink = delete(subroot.llink, subroot.key);
                return subroot;
            }

        }
    }

    /**
     * This method will delete a node from the BST.
     * @param value
     */
    public void delete(T value){
        root = delete(root, value);
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

    /**
     * This method searches the target node recursively in the tree
     * 
     * @param root root of the tree
     * @param target target node value to search in tree
     * @return target node if found else null
     */
    private BSTNode traverseNode(BSTNode root, T target)
    {
        if(root == null){
            return null;
        }
        if (root.key.equals(target)){
            return root;
        }
        else if (root.key.compareTo(target) > 0) {
            return traverseNode(root.llink, target);
        } else {
            return traverseNode(root.rlink, target);
        }
    }

    /**
     * method to traverse to target node in the tree
     *  
     * @param target target value to search in tree
     * @return target node if found else null
     */
    public BSTNode traverseNode(T target){
        return traverseNode(root, target);
    }

    /**
     * This method will print the BST
     */
    public void printBST(){
        print(root);
    }

    /**
     * helper method which does recursive traversal in in-order 
     * and prints the value from each node
     * 
     * @param bstNode node to traverse and print 
     */
    public void print(BSTNode<T> bstNode){
        if(bstNode == null) return;
        print(bstNode.llink);
        System.out.println(bstNode.key.toString());
        print(bstNode.rlink);
    }

}
