package proj5;

import java.util.Objects;


public class Dictionary {


    /**
     * Node represents the each node that is present inside the dictionary
     */
    static class Node implements Comparable<Node>{

        String word; //word in the node
        
        
        public Node(String word) {
            this.word = word;
        }

        /**
         *  This will compare the two nodes of dictionary based on the string present inside that node
         * @param o node to compare with
         * @return +ve, zero, or -ve value
         */
        @Override
        public int compareTo(Node o) {
            return word.compareTo(o.word);
        }

        /**
         * This equals method will check the equality of two index node based 
         * on the words present in that dictionary node
         * @param o node to compare
         * @return true of equal, false otherwise
         */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return word.equals(node.word);
        }

        /**
         * @return int hash value calculated from the word
         */
        @Override
        public int hashCode() {
            return Objects.hash(word);
        }

        /**
         *  @return return node as a printable string
         */
        @Override
        public String toString() {
            return word;
        }
    }

    /**
     * ADT which holds the nodes inside dictionary
     */
    private BinarySearchTree<Node> dictionary;

    /**
     * Default constructor which initializes the dictionary 
     */
    public Dictionary() {
        dictionary = new BinarySearchTree<>();
    }

    /**
     * Inserts node to the dictionary
     * @param word
     */
    public void insert(Node word){
        dictionary.insert(word);
    }

    /**
     * Searches the given node in dictionary
     * @param node to search
     * @return true if present, otherwise false
     */
    public boolean search(Node node){
        return dictionary.search(node);
    }

    /**
     * @return string representation of the dictionary 
     */
    @Override
    public String toString() {
        return dictionary.toString();
    }

    /**
     * Prints the dictionary in in-order traversal
     */
    public void printDictionary(){
        dictionary.printBST();
    }

    /**
     * @return the size of dictionar
     */
    public int size(){
        return dictionary.size();
    }
}
