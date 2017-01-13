package queue;

public class FixedSizeArrayQueue {
	
	private int[] queue;
	private int size, front, rear;
	private int capacity;
	
	public FixedSizeArrayQueue(int capacity){
		queue = new int[capacity];
		this.capacity = capacity;
		size = 0;
		front = 0;
		rear = 0;
	}
	
	//add the element at the end
	//update rear pointer and increment size
	//modulus used so as to create a circular queue
	public void enqueue(int data) throws Exception{
		if(getSize() == capacity){
			throw new Exception("Size of queue is full. Please dequeue before enqueuing.");
		}
		queue[rear] = data;
		rear = (rear + 1) % capacity;
		size++;
	}
	
	//remove the element at the front
	//update front pointer and decrement size
	//modulus used so as to create a circular queue
	public int dequeue() throws Exception{
		if(getSize() == 0){
			throw new Exception("Queue is empty. What are you doing?");
		}
		size--;
		int data = queue[front];
		queue[front] = Integer.MIN_VALUE; //assigning min value at index where there should be no element
		front = (front + 1) % capacity;
		return data;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return (size == 0);
	}
	
	public boolean isFull() {
		return (size == capacity);
	}
	
	public String toString(){
		if(isEmpty()){
			return "Queue is Empty. Nothing to print.";
		}
		String result = "[ ";
		
		//number elements to print are equal to size
		//front+i gives required offset
		//modulus op ensures that we handle circular condition
		for(int i = 0; i < size; i++){
			result = result + queue[(i + front) % capacity] + " ";
		}
		result = result + "]";
		return result;
	}
	
}
