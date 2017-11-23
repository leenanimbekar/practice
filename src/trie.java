/**
 * Created by nimbekl on 11/2/17.
 */
public class trie {
    static final int ALPHABET_SIZE = 26;
    static class TrieNode{
        boolean isEndOfWord ;
        TrieNode children[]= new TrieNode[ALPHABET_SIZE];
        TrieNode(){
            isEndOfWord = false;
            for(int i = 0;i <ALPHABET_SIZE;i++){
                children[i] = null;
            }
        }
    }
    static TrieNode root;
    static void insert(String str){
        int level;
        int len = str.length();
        int index;
        TrieNode node = root;
        for(level = 0;level<len;level++){
          index = str.charAt(level) - 'a';
            if(node.children[index] == null){
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEndOfWord = true;
    }
    static boolean search(String str){
        int level;
        int len = str.length();
        int index;
        TrieNode node = root;
        for(level = 0;level<len;level++){
            index = str.charAt(level) - 'a';
          if(node.children[index]== null){
            return false;
          }
          node = node.children[index];
        }
        return node!=null && node.isEndOfWord;
    }
    public static void main(String args[]){
        root = new TrieNode();
        String keys[] = {"the", "a", "there", "answer", "any",
                "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};
        for (int i = 0; i < keys.length ; i++)
            insert(keys[i]);
        if(search("the") == true)
            System.out.println("the --- " + output[1]);
        else System.out.println("the --- " + output[0]);

        if(search("these") == true)
            System.out.println("these --- " + output[1]);
        else System.out.println("these --- " + output[0]);

        if(search("their") == true)
            System.out.println("their --- " + output[1]);
        else System.out.println("their --- " + output[0]);

        if(search("thaw") == true)
            System.out.println("thaw --- " + output[1]);
        else System.out.println("thaw --- " + output[0]);
    }
}
