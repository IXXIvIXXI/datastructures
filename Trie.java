class Trie {
    class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
    } 
    
    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode curr = root;
        char[] wordArr = word.toCharArray();
        for (Character c : wordArr) {
            curr.children.putIfAbsent(c, new TrieNode());
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }
    
    public boolean search(String word) {
        TrieNode curr = root;
        char[] wordArr = word.toCharArray();
        for (Character c : wordArr) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.isWord;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        char[] prefixArr = prefix.toCharArray();
        for (Character c : prefixArr) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }
    
    
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
