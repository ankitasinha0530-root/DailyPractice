package com.dsal.leetcode.blind75.trie;

public class CreateWordDictionary {

    //https://www.youtube.com/watch?v=6O73KA53ayY&t=1064s

//    https://leetcode.com/problems/design-add-and-search-words-data-structure/description/ - return True/False

    TrieNode root;

    public CreateWordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        insert(word);
    }

    public static void main(String[] args) {
        CreateWordDictionary wordTrieDictionary = new CreateWordDictionary();

        wordTrieDictionary.addWord("bad");
        wordTrieDictionary.addWord("dad");
        wordTrieDictionary.addWord("mad");
        System.out.println(wordTrieDictionary.search("pad")); // return False
        System.out.println(wordTrieDictionary.search("bad")); // return True
        System.out.println(wordTrieDictionary.search(".ad")); // return True
        System.out.println(wordTrieDictionary.search("b..")); // return True

    }

    private void insert(String word) {
        TrieNode curr = root;

        for (char ch : word.toCharArray()) {
            int idx = (int) (ch - 'a');

            if (curr.children[idx] == null) {
                curr.children[idx] = new TrieNode();
            }
            curr = curr.children[idx];
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        return searchWord(curr, 0, word);
    }

    private boolean searchWord(TrieNode root, int index, String word){

        if(root == null) {
            return false;
        }
        if(index == word.length()) {
            return root.isWord;
        }
        char ch = word.charAt(index);
        if(ch == '.'){
            for(TrieNode child: root.children){
                if(searchWord(child, index + 1, word)) {
                    return true;
                }
            }
            return false;
        }else{
            int childIndex = ch - 'a';
            if(root.children[childIndex] == null){
                return false;
            }
            return searchWord(root.children[childIndex], index + 1, word);
        }
    }

    private boolean searchWord2(String word, int idxWord, TrieNode root) {

        for (int i = idxWord; i < word.length(); i++) {

            char ch = word.charAt(i);

            if(ch == '.') {
                for (TrieNode child : root.children) {
                    if(child == null) {
                        continue;
                    }
                    if(searchWord2 (word, i + 1, child)){
                        return true;
                    }
                }
                return false;
            }
            if(root.children[ch - 'a'] == null) {
                return false;
            }
            root = root.children[ch - 'a'];
        }
        return root.isWord;
    }
}
