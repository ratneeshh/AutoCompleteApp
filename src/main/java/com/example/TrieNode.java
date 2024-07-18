package com.example;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord;
    int frequency;

    public TrieNode() {
        isEndOfWord = false;
        frequency = 0;
    }
}
