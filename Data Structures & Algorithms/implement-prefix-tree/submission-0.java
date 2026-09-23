class PrefixTree {
    TrieNode root = new TrieNode();


    class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
}


    
    public PrefixTree() {}

    public void insert(String word) {

        TrieNode node = root;

        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        }

        node.isEnd = true;



    }

    public boolean search(String word) {

        TrieNode node = walk(word);

        return node != null && node.isEnd;

    }

    public boolean startsWith(String prefix) {
        return walk(prefix) != null;

    }

    private TrieNode walk(String s) {
        TrieNode node = root;

        for (char c : s.toCharArray()) {
            node = node.children.get(c);

            if (node == null) return null;

        }

        return node;

    }
}
