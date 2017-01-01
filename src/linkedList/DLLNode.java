package linkedList;

public class DLLNode {
	private int data;
	private DLLNode next;
	private DLLNode prev;
	
	public DLLNode(int data){
		this.data = data;
		next = null;
		prev = null;
	}
	
	public DLLNode(int data, DLLNode prev, DLLNode next){
		this.data = data;
		this.next = next;
		this.prev = prev;
	}
	
	public void setData(int data){
		this.data = data;
	}
	
	public int getData(){
		return data;
	}
	
	public void setNext(DLLNode next){
		this.next = next;
	}
	
	public void setPrev(DLLNode prev){
		this.prev = prev;
	}
	
	public DLLNode getPrev(){
		return prev;
	}
	
	public DLLNode getNext(){
		return next;
	}
}
