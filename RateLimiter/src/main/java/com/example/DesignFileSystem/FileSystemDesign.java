package com.example.DesignFileSystem;

import java.util.HashMap;
import java.util.Map;

public class FileSystemDesign {

    class TrieNode {
        String name;
        int val = -1;
        Map<String, TrieNode> map = new HashMap<>();


        TrieNode(String name) {
            this.name = name;
        }
    }

    TrieNode root;

    public FileSystemDesign() {
        this.root = new TrieNode("");
    }

    // Time : O(T) to add a path to the trie if it contains T components.
    // Space : Let's look at the worst case space complexity. In the worst case, none of the paths will
    // have any common prefixes. We are not considering the ancestors of a larger path here.
    // In such a case, each unique path will end up taking a different branch in the trie.
    // Also, for a path containing T components, there will be T nodes in the trie.
    public boolean createPath(String path, int value) {

        String[] components = path.split("/");

        TrieNode curr = root;

        for (int i = 1; i < components.length; i++) {

            String currentComponent = components[i];

            if (!curr.map.containsKey(currentComponent)) {

                if (i == components.length - 1) {
                    curr.map.put(currentComponent, new TrieNode(currentComponent));
                } else {
                    return false;
                }
            }

            curr = curr.map.get(currentComponent);
        }

        if (curr.val != -1) {
            return false;
        }

        curr.val = value;
        return true;
    }

    // Time : O(T) to find a path in the trie if it contains T components.
    // Space : O(1)
    public int get(String path) {

        String[] components = path.split("/");

        TrieNode curr = root;

        for (int i = 1; i < components.length; i++) {
            String currentComponent = components[i];

            if (!curr.map.containsKey(currentComponent)) {
                return -1;
            }

            curr = curr.map.get(currentComponent);
        }

        return curr.val;
    }
}
