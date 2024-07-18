package com.example;

import java.util.*;

public class Trie {
    private final TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toLowerCase().toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.isEndOfWord = true;
        node.frequency++;
    }

    private TrieNode searchNode(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toLowerCase().toCharArray()) {
            if (!node.children.containsKey(c)) {
                return null;
            }
            node = node.children.get(c);
        }
        return node;
    }

    public List<String> autocomplete(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode node = searchNode(prefix);
        if (node != null) {
            findAllWords(node, new StringBuilder(prefix.toLowerCase()), results);
        }
        return results;
    }

    private void findAllWords(TrieNode node, StringBuilder prefix, List<String> results) {
        if (node.isEndOfWord) {
            results.add(prefix.toString());
        }
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            findAllWords(entry.getValue(), prefix.append(entry.getKey()), results);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    public List<String> autocompleteWithFrequency(String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode node = searchNode(prefix);
        if (node != null) {
            List<WordFrequency> wordFrequencies = new ArrayList<>();
            findAllWordsWithFrequency(node, new StringBuilder(prefix.toLowerCase()), wordFrequencies);
            Collections.sort(wordFrequencies, (a, b) -> b.frequency - a.frequency);
            for (WordFrequency wf : wordFrequencies) {
                results.add(wf.word);
            }
        }
        return results;
    }

    private void findAllWordsWithFrequency(TrieNode node, StringBuilder prefix, List<WordFrequency> wordFrequencies) {
        if (node.isEndOfWord) {
            wordFrequencies.add(new WordFrequency(prefix.toString(), node.frequency));
        }
        for (Map.Entry<Character, TrieNode> entry : node.children.entrySet()) {
            findAllWordsWithFrequency(entry.getValue(), prefix.append(entry.getKey()), wordFrequencies);
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }

    private static class WordFrequency {
        String word;
        int frequency;

        WordFrequency(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }
    }
}
