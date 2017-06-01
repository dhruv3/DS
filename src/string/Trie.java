package string;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	
	public class TrieNode{
		Map<Character, TrieNode> children;
		Boolean endOfStirng;
		public TrieNode(){
			children =  new HashMap<Character, TrieNode>();
			endOfStirng = false;
		}
	}
	
	private TrieNode root;
	public Trie(){
		root = new TrieNode();
	}
	
	public void insert(String input){
		TrieNode node = root;
		char[] inpArr = input.toCharArray();
		
		for(int i = 0; i < inpArr.length; i++){
			if(!node.children.containsKey(inpArr[i])){
				node.children.put(inpArr[i], new TrieNode());
			}
			node = node.children.get(inpArr[i]);
		}
		
		node.endOfStirng = true;
	}
	
	public boolean search(String input){
		TrieNode node = root;
		char[] inpArr = input.toCharArray();
		
		for(int i = 0; i < inpArr.length; i++){
			if(!node.children.containsKey(inpArr[i])){
				return false;
			}
			node = node.children.get(inpArr[i]);
		}
		
		if(node.endOfStirng == true){
			return true;
		}
		else{
			return false;
		}
	}
	
	 public void delete(String word) {
	        delete(root, word, 0);
	    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            //when end of word is reached only delete if currrent.endOfWord is true.
            if (!current.endOfStirng) {
                return false;
            }
            current.endOfStirng = false;
            //if current has no other mapping then return true
            return current.children.size() == 0;
        }
        char ch = word.charAt(index);
        TrieNode node = current.children.get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1);

        //if true is returned then delete the mapping of character and trienode reference from map.
        if (shouldDeleteCurrentNode) {
            current.children.remove(ch);
            //return true if no mappings are left in the map.
            return current.children.size() == 0;
        }
        return false;
    }
}
