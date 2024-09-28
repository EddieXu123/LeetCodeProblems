class Trie {
    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }
    
    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.edges.get(c) == null) {
                node.edges.put(c, new TrieNode());
            }
            node = node.edges.get(c);
        }

        node.isWordEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (node.edges.get(c) == null) return false;
            node = node.edges.get(c);
        }

        return node.isWordEnd;
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            if (node.edges.get(c) == null) return false;
            node = node.edges.get(c);
        }

        return true;
    }

    class TrieNode {
        boolean isWordEnd;
        Map<Character, TrieNode> edges;

        TrieNode() {
            this.edges = new HashMap<>();
            this.isWordEnd = false;
        }
    }
}
