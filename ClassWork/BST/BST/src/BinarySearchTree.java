/**
 * Demo of the Binary Search Tree ADT.
 * This one only works with ints.
 * 
 * @author Chris Fernandes
 * @version 5/20/2022
 */
public class BinarySearchTree
{
	private BSTNode root;
	
	/**
	 * Default constructor
	 */
	public BinarySearchTree() {
		root = null;
	}
         
	/**
	 * inserts value into tree rooted at subroot
	 * 
	 * @param subroot  subroot of tree to insert into
	 * @param value  the Integer to insert
	 * @return   root of the subtree I've just finished inserting into
	 */
	private BSTNode insert(BSTNode subroot, Integer value) {
		if (subroot==null){
			return new BSTNode(value);
		}
		else if (value.compareTo(subroot.key) > 0){
			subroot.rlink = insert(subroot.rlink,value);
			return subroot;
		}
		else {
			subroot.llink = insert(subroot.llink, value);
			return subroot;
		}
	}

	/**
	 * inserts an int into BST    
	 * @param newValue int to insert
	 */
	public void insert(int newValue) {
		root = insert(root,newValue);
	}
	
	/**
	 * deletes value from tree.  If value not there, do nothing.
	 * @param value  int to delete
	 */
	public void delete(int value) {

	}
	
	/**
	 * deletes value from tree rooted at subroot
	 * @param subroot  root of tree to be deleted from
	 * @param value  element to delete
	 * @return pointer to tree rooted at subroot that has value removed from it
	 */
	private BSTNode delete(BSTNode subroot, Integer value) {
		return null;  // erase -- this is just to make it compile

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
