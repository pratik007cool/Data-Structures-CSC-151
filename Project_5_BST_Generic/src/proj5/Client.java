package proj5;

public class Client {


    public static void main(String[] args) {
        makeIndex("src/proj5/uscons.txt");
       
    }

    /**
     * Makes an index out of fileName. Gradescope needs this function.
     *
     * @param fileName path to text file that you want to index
     */
    public static void makeIndex(String fileName) {

        final Index index = new Index(); //create index
        final Dictionary dictionary = new Dictionary();// create dictionary
        
        FileReader fileReader = new FileReader(fileName);
        String word;
        int page = 1;
        while ((word = fileReader.nextToken()) != null) {

            if (word.equals("#")) {
                page++;
                continue;
            }

            if (isValid(word) && !searchInDictionary(word, dictionary)) {
                Index.Node node = new Index.Node(word);
                boolean search = index.search(node);
                Index.Node altNode = null; //alternate node to check for capitalized and non capitalized words
                String altWord = changeCase(word);
                if (!search) { //if the same case word is present then do not search for alternate word node
                    altNode = new Index.Node(altWord);
                    search = index.search(altNode);
                }

                if (search) {
                    Index.Node key ;
                    
                    if(altNode == null){
                        key = index.traverse(node).key;
                    }else{
                        key = index.traverse(altNode).key;
                        word = altWord;
                    }
                    
                    if (key.getLastPage() != page) {

                        if (!key.isFull()) {
                            key.addPage(page);
                        } else {
                            System.out.println("Deleting '" + key.word + " " + key.pageStringUpdated() + "' from index.");
                            index.delete(new Index.Node(word));
                            dictionary.insert(new Dictionary.Node(word));
                        }
                    }
                } else {
                    node.addPage(page);
                    index.insert(node);
                }
            }
        }

        index.printIndex();
        dictionary.printDictionary();

    }

    /**
     * Checks the words if it's valid or not
     *
     * @param word to check
     * @return true or false
     */
    public static boolean isValid(String word) {
        return word.length() > 2;
    }

    /**
     * This will search if the word is present in dictionary 
     * @param word word to search
     * @param dictionary dictionary in which word will be searched
     * @return true if present otherwise false
     */
    public static boolean searchInDictionary(String word, Dictionary dictionary) {
        return dictionary.search(new Dictionary.Node(changeCase(word))) || dictionary.search(new Dictionary.Node(word));
    }

    /**
     * will change the case of first letter of the word
     * @param word word to change case
     * @return capitalized word if it was small case word, otherwise small case word
     */
    public static String changeCase(String word) {
        if(Character.isUpperCase(word.charAt(0))){
            return word.toLowerCase();
        }
        return word.substring(0, 1).toUpperCase() + word.substring(1);
    }

}
