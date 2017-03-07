package BinaryHeap;

public class AdvancedBinaryHeap {

	public int[] array;    
	public int count;		//total elements in heap 
	public int capacity;	//size of heap
	public int heap_type;	//min or max heap
	
	//creating heap
	public AdvancedBinaryHeap(int capacity, int heap_type){
		this.capacity = capacity;
		this.heap_type = heap_type;
		this.count = 0;
		this.array = new int[capacity];
	}
	
	//parent node
	public int Parent(int childIdx){
		if(childIdx <= 0 || childIdx >= this.count)
			return -1;
		
		return (childIdx-1)/2;
	}
	
	//children of a node
	//left child
	public int LeftChild(int parentIdx){
		int leftChildIdx = 2*parentIdx + 1;
		if(leftChildIdx >= this.count)
			return -1;
		return leftChildIdx;
	}
	
	//right child
	public int RightChild(int parentIdx){
		int rightChildIdx = 2*parentIdx + 2;
		if(rightChildIdx >= this.count)
			return -1;
		return rightChildIdx;
	}
	
	//getting the max element
	//add for heap_type functionality
	public int GetMaxElement(){
		if(this.count == 0)
			return -1;
		return this.array[0];
	}
	
}
