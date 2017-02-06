package hashing;

public class HashTableOperations {
	public final static int LOADFACTOR = 20;
	
	public static HashTable createHashTable(int size){
		HashTable hTable = new HashTable();
		hTable.setSize(size/LOADFACTOR);
		for(int i = 0; i < hTable.getSize(); i++){
			hTable.getTable()[i].setStartNode(null);
		}
		return hTable;
	}
	
	
}
