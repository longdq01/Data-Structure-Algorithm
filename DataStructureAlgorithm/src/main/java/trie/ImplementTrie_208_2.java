package trie;

public class ImplementTrie_208_2 {
    private class TrieNode{
        public static final int SIZE = 26;
        public TrieNode[] children = new TrieNode[SIZE];
        public boolean isWord = false;
    }

    private TrieNode root = new TrieNode();

    public ImplementTrie_208_2() {

    }

    public void insert(String word) {
        TrieNode curNode = root;
        int curIndex = 0, n = word.length();

        while(curIndex < n){
            int childIndex = word.charAt(curIndex) - 'a';
            if(curNode.children[childIndex] == null)
                curNode.children[childIndex] = new TrieNode();

            if(curIndex == n - 1)
                curNode.children[childIndex].isWord = true;
            curNode = curNode.children[childIndex];
            curIndex++;
        }
    }

    public boolean search(String word) {
        TrieNode curNode = root;
        int curIndex = 0, n = word.length();

        while(curIndex < n){
            int childIndex = word.charAt(curIndex) - 'a';
            if(curNode.children[childIndex] == null)
                return false;

            if(curIndex == n - 1){
                return curNode.children[childIndex].isWord;
            }
            curNode = curNode.children[childIndex];
            curIndex++;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        TrieNode curNode = root;
        int curIndex = 0, n = prefix.length();

        while(curIndex < n){
            int childIndex = prefix.charAt(curIndex) - 'a';
            if(curNode.children[childIndex] == null)
                return false;

            if(curIndex == n - 1)
                return true;
            curNode = curNode.children[childIndex];
            curIndex++;
        }
        return false;
    }
}
