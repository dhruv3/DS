package stack;

import java.util.EmptyStackException;

import linkedList.listNode;

//push = insert elem at beginning of list
//pop  = deleting the node from beginning of the list

public class LinkedStack {
	//indicate size of stack
	private int length = 0;
	
	//top points to the header of the list
	private listNode top;
	
	public LinkedStack(){
		length = 0;
		top = null;
	}
	
	//insert elem at beginning of list
	public void push(int data){
		listNode newNode = new listNode(data);
		newNode.setNext(top);
		top = newNode;
		length++;
	}
	
	
	//remove the topmost element double array when array is full
	public int pop() throws Exception{
		if(isEmpty()){
			throw new Exception("Stack is empty. Pop wont work.");
		}
		int topElement =  top.getData();
		listNode temp = top.getNode();
		top.setNext(null);
		top = temp;
		length--;
		return topElement;
	}
	
	//get size of the stack
	public int getSize(){
		return length;
	}
	
	//top is equal null this implies stack is EMPTY
	public boolean isEmpty(){
		return (top == null);
	}
	
	//does not remove topmost element
	public int peek() throws EmptyStackException{
		if(isEmpty()){
			throw new EmptyStackException();
		}
		return top.getData();
	}
	
	public String toString(){
		String result = "";
		listNode temp = top;
		while(temp.getNode() != null){
			result = result + temp.getData() + ">";
			temp = temp.getNode();
		}
		result = result + temp.getData();
		return result;
	}
}
