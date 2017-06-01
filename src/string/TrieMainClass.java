package string;

//tutorial: https://www.youtube.com/watch?v=AXjmTQ8LEoI
public class TrieMainClass {

	public static void main(String[] args) {
		Trie myTrie = new Trie();
		testInsert(myTrie);
		System.out.println("Checking search implementation-----------------------------");
		testSearch(myTrie);
		System.out.println("Checking delete implementation-----------------------------");
		testDelete(myTrie);
	}

	private static void testDelete(Trie myTrie) {
		System.out.println("Is \'abc\' is present: " + myTrie.search("abc"));
		System.out.println("Deleting 'abc'------------");
		myTrie.delete("abc");
		System.out.println("Is \'abc\' is present: " + myTrie.search("abc"));
	}

	private static void testSearch(Trie myTrie) {
		System.out.println("Is \'abc\' is present: " + myTrie.search("abc"));
		System.out.println("Is \'abcd\' is present: " + myTrie.search("abcd"));
		System.out.println("Is \'abqc\' is present: " + myTrie.search("abqc"));
	}

	private static void testInsert(Trie myTrie) {
		myTrie.insert("abc");
		myTrie.insert("abgl");
		myTrie.insert("cdf");
		myTrie.insert("abcd");
		myTrie.insert("lmn");
	}

}
