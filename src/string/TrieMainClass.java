package string;

public class TrieMainClass {

	public static void main(String[] args) {
		Trie myTrie = new Trie();
		testInsert(myTrie);
	}

	private static void testInsert(Trie myTrie) {
		myTrie.insert("abc");
		myTrie.insert("abgl");
		myTrie.insert("cdf");
		myTrie.insert("abcd");
		myTrie.insert("lmn");
	}

}
