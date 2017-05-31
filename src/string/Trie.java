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
		
		node.endOfStirng = false;
	}
	

}
