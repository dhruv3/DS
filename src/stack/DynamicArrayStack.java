package stack;

public class DynamicArrayStack {
	//length of array
	protected int capacity;
	
	//array to implement stack
	protected int[] stack;
	
	//index of the top element
	//so the new element is entered at position top+1
	protected int top = -1;
	
	//initialize stack
	public DynamicArrayStack(int capacity){
		this.capacity = capacity;
		stack = new int[capacity];
	}
	
	//get size of the stack
	public int getSize(){
		return (top + 1);
	}
	
	//top is less than 0 implies stack is EMPTY
	public boolean isEmpty(){
		return (top < 0);
	}
	
	//double array when array is full
	public void push(int data) throws Exception{
		//double the size
		if(getSize() >= capacity){
			expandArray();
		}
		stack[++top] = data;
	}

	private void expandArray() {
		//create a new array of double size
		
		//Mistake I did:
		//int[] newArr =  new int[capacity*2];
		//Issue: Capacity is some initial value used to set stack size. You can exceed twice the capacity
		//Fix: Get current size and then double it
		int[] newArr =  new int[getSize()*2];
		
		//copy content to new array
		for(int i = 0; i <= top; i++){
			newArr[i] = stack[i];
		}
		//assign new array to global array
		stack = newArr;
	}
	
	//remove the topmost element double array when array is full
	public int pop() throws Exception{
		if(isEmpty()){
			throw new Exception("Stack is empty. Pop wont work.");
		}
		int topElement =  stack[top];
		top--;
		if(getSize() < (stack.length)*(3/4)){
			shrink();
		}
		return topElement;
	}

	//halve the array
	private void shrink() {
		int[] newArr =  new int[stack.length/2];
		
		//copy content to new array
		for(int i = 0; i <= top; i++){
			newArr[i] = stack[i];
		}
		//assign new array to global array
		stack = newArr;
	}
	
	//does not remove topmost element
	public int top() throws Exception{
		if(isEmpty()){
			throw new Exception("Stack is empty. Pop wont work.");
		}
		return stack[top];
	}
	
	//print contents of stack
	public String toString(){
		String result = ""; 
		for(int i = 0; i < top; i++){
			result = result + stack[i] + ">";
		}
		result =  result + stack[top];
		return result;
	}

}
