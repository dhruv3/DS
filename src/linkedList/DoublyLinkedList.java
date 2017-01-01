package linkedList;

public class DoublyLinkedList {
	
	private int length = 0;
	private DLLNode head;
	private DLLNode tail;
	
	public DoublyLinkedList(){
		head = new DLLNode(Integer.MIN_VALUE, null, null);
		tail = new DLLNode(Integer.MIN_VALUE, null, null);
		head.setNext(tail);
		length = 0;
	}
	
	public synchronized DLLNode getHead(){
		return head;
	}
	
	//value is sent 
	public synchronized void insertAtStart(int newValue){
		DLLNode node = new DLLNode(newValue, null, head);
		head = node;
		node.getNext().setPrev(node);
		length++;
	}
	
	//value is sent
	public synchronized void insertAtTail(int newValue){
		DLLNode node = new DLLNode(newValue, null, null);
		if(head == null){
			head = node; 
		}
		else{
			DLLNode temp = head;
			while(temp.getNext() != null){
				temp = temp.getNext();
			}
			temp.setNext(node);
			node.setPrev(temp);
		}
		length++;
	}
	
	public void insert(int data, int position){
		if(position <= 0){
			insertAtStart(data);
		}
		else if(position >= length){
			insertAtTail(data);
		}
		else{
			DLLNode temp = new DLLNode(data);
			int counter = 0;
			DLLNode currentNode = head;
			while(counter != (position-1)){
				counter++;
				currentNode = currentNode.getNext();
			}
			temp.setNext(currentNode.getNext());
			temp.setPrev(currentNode);
			currentNode.setNext(temp);
			temp.getNext().setPrev(temp);
		}
		length++;
	}
	
	//remove head and then return the new head value
	public synchronized int removeFromStart(){
		DLLNode temp = head;
		head = temp.getNext();
		head.setPrev(null);
		temp.setNext(null);
		length--;
		return head.getData();
	}
	
	//remove last node and the return new tail value
	public synchronized int removeFromEnd(){
		DLLNode temp = tail.getPrev();
		tail.setPrev(null); 
		temp.setNext(null);
		length--;
		return temp.getData();
	}
	
	//remove a node matching the specified node from the list
	public synchronized void removeMatched(DLLNode node){
		DLLNode temp = head;
		if(temp.equals(node)){
			removeFromStart();
		}
		else{
			while(!temp.equals(node)){
				temp = temp.getNext();
			}
			temp.getNext().setPrev(temp.getPrev());
			temp.getPrev().setNext(temp.getNext());
			temp.setPrev(null);
			temp.setNext(null);
			length--;
		}
	}
	
	//remove the value from given position (position start at 0)
	public void remove(int position){
		int temp = 0;
		DLLNode tempNode = head;
		if(position <= 0){
			removeFromStart();
		}
		else if(position >= length){
			removeFromEnd();
		}
		else{
			while(temp != position){
				temp++;
				tempNode = tempNode.getNext();
			}
			tempNode.getNext().setPrev(tempNode.getPrev());
			tempNode.getPrev().setNext(tempNode.getNext());
			tempNode.setNext(null);
			tempNode.setPrev(null);
			length--;
		}
	}
	
	public String toString(){
		String result = "";
		DLLNode temp = head;
		while(temp.getNext() != null){
			result = result + temp.getData() + ">";
			temp = temp.getNext();
		}
		result = result + temp.getData();
		return result;
	}
	
	public int getPosition(int data){
		int position = 0;
		DLLNode temp = head;
		if(temp.getData() == data)
			return 0;
		else{
			while(temp.getNext() != null){
				if(temp.getData() == data){
					return position;
				}
				else{
					temp = temp.getNext();
					position++;
				}
			}
		}
		return position;
	}
	
	public int listLength(DLLNode head){
		int counter = 0;
		DLLNode temp = head;
		while(temp != null){
			counter++;
			temp = temp.getNext();
		}
		return counter;
//		Case below fails when head is a null node. To fix it we have used current node instead of next node to increment the pointer
//		int counter = 1;
//		listNode temp = head;
//		while(temp.getNode() != null){
//			counter++;
//			temp = temp.getNode();
//		}
//		return counter;
	}
}
