package proj5;

import java.util.Objects;

public class Index {
    
    static class Node implements Comparable<Node>{

        /**
         * word will holds the value of index
         */
        String word;

        /**
         * pageList will hold the value of pages in which words are present
         */
        int[] pageList;

        /**
         * Constructor which initializes the index node with provided word 
         * and pagelist as an integer array of size 4
         * @param word token to initialize the index node
         */
        public Node(String word) {
            this.word = word;
            pageList = new int[4];
        }


        /**
         * method which overrides the compareTo method from comparable interface
         * 
         * @param o node to compare with
         * @return positive, zero, negative value based on the index word
         */
        @Override
        public int compareTo(Node o) {
            return word.compareTo(o.word);
        }

        /**
         * This equals method will check the equality of two index node based 
         * on the words present in that index node
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
         * @return hash value of index node
         */
        @Override
        public int hashCode() {
            return Objects.hash(word);
        }

        /**
         * this will add the page number to the pageList
         * 
         * @param page number to add to pageList
         */
        public void addPage(int page){
            for(int i = 0;i<pageList.length;i++){
                if(pageList[i] == 0){
                    pageList[i] = page;
                    return;                    
                }
            }
        }

        /**
         * method to check if the pageList is full or not
         * @return true if all the four elements of page is occupied otherwise false
         */
        public boolean isFull(){
            return pageList[3] != 0;
        }

        /**
         * This method will return the maximum value of page number present in the pageList
         * Page number will be inserted to pageList in increasing order, so we don't need to 
         * iterate over the full array
         * 
         * @return maximum value of page present in pageList
         */
        public int getLastPage() {
            for (int i = pageList.length - 1; i >= 0; i--) {
                if (pageList[i] != 0) return pageList[i];
            }
            return 0;
        }

        /**
         * @return  the string representation of index node in required format
         */
        public String pageStringUpdated(){
            String[] src = new String[4];
            int lastPage = pageList[0];
            int seqCount = 1, j = 0, i = 1;
            for(;i<pageList.length && (pageList[i] != 0);i++){
                if((pageList[i] - pageList[i-1] ) == 1 ){
                    seqCount++;
                }else {
                    if(seqCount > 2){
                        src[j++] = lastPage + "-" + pageList[i - 1];
                    }else{
                        src[j++] = Integer.toString(lastPage);
                        if(lastPage != pageList[i-1]){
                            src[j++] = Integer.toString(pageList[i-1]);
                        }
                    }
                    lastPage = pageList[i];
                    seqCount = 1;
                }
            }
            if(seqCount > 2){
                src[j++] = lastPage + "-" + pageList[i - 1];
            }else{
                src[j++] = Integer.toString(lastPage);
                if(lastPage != pageList[i-1]){
                    src[j++] = Integer.toString(pageList[i-1]);
                }
            }
            return pageString(src);
        }

        /**
         * @param src array of string which should be combined with comma 
         * @return String representation of the pageList
         */
        public  String pageString(String[] src){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{");
            String prefix = "";
            for(int i = 0;i<src.length && (src[i] != null);i++){ //use only not null string from array
                stringBuilder.append(prefix);
                prefix = ", ";
                stringBuilder.append(src[i]);
            }
            stringBuilder.append("}");
            return stringBuilder.toString();

        }


        /**
         * 
         * @return string representation of the Index 
         */
        @Override
        public String toString() {
            return word + " " + pageStringUpdated();
        }
    }

    /**
     * ADT which holds the value of index nodes
     */
    private BinarySearchTree<Node> index;

    /**
     * Default constructor
     */
    public Index() {
        this.index = new BinarySearchTree();
    }

    /**
     * Inserts the index node into index
     * @param word node to insert
     */
    public void insert(Node word){
        index.insert(word);
    }

    /**
     * @param node to search
     * @return true if node is present, otherwise false
     */
    public boolean search(Node node){
        return index.search(node);
    }

    /**
     * @param node node to traverse in index
     * @return BSTNode if present, otherwise null
     */
    public BSTNode<Node> traverse(Node node){
        return index.traverseNode(node);
    }

    /**
     * Delets the node from index
     * @param node
     */
    public void delete(Node node){
        index.delete(node);
    }

    /**
     * Prints the index in in-order traversal
     */
    public void printIndex(){
        index.printBST();
    }

    /**
     * @return string representation of the index
     */
    @Override
    public String toString() {
        return index.toString();
    }
    
}
