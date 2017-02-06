package hashing;

public class HashTableOperations {
	public final static int LOADFACTOR = 20;
	
	public static HashTable createHashTable(int size){
		HashTable hTable = new HashTable();
		//LoadFactor = (# elements in hash table) / (hash table size)
		//So, hash table size = (# elements in hash table) / (LoadFactor)
		hTable.setSize(size/LOADFACTOR);

		//for each entry in hash table set start node to null
		for(int i = 0; i < hTable.getSize(); i++){
			hTable.getTable()[i].setStartNode(null);
		}
		
		return hTable;
	}
	
	public static int Hash(int key, int size){
		return (key % size);
	}
	
	public static int hashSearch(HashTable h, int data){
		ListNode temp;
		
		temp = h.getTable()[Hash(data, h.getSize())].getStartNode();
		
		while(temp != null){
			if(temp.getData() == data)
				return 1;
			temp = temp.getNext();
		}
		
		return 0;
	}
	
	public static void hashInsert(HashTable h, int data){
		int index;
		ListNode temp, newNode;
		
		if(hashSearch(h, data) == 1)
			return;
		
		index = Hash(data, h.getSize());
		temp = h.getTable()[index].getStartNode();
		
		newNode = new ListNode();
		newNode.setKey(index);
		newNode.setData(data);
		//newNode.setNext(h.getTable()[index].get);
	}
	
}

