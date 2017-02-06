package hashing;

public class HashTable {
	private int size;
	private int count;
	private HashTableNode[] table;
	
	public int getSize(){
		return size;
	}
	
	public void setSize(int size){
		this.size  = size;
		table = new HashTableNode[size];
	}
	
	public int getCount(){
		return count;
	}
	
	public void setCount(int count){
		this.count = count;
	}
	
	public HashTableNode[] getTable(){
		return table;
	}
	
	public void setTable(HashTableNode[] table){
		this.table = table;
	}
}
