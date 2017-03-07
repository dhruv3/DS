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
	//left child idx is returned
	public int LeftChild(int parentIdx){
		int leftChildIdx = 2*parentIdx + 1;
		if(leftChildIdx >= this.count)
			return -1;
		return leftChildIdx;
	}
	
	//right child idx is returned
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
	
	//heapifying an element
	public void PercolateDown(int i){
		int max;
		int leftChildIdx = LeftChild(i);
		int rightChildIdx = RightChild(i);
		if(array[leftChildIdx] > array[rightChildIdx]){
			max = leftChildIdx;
		}
		else{
			max = rightChildIdx;
		}
		
		if(array[i] < array[max]){
			int temp = array[max];
			array[max] = array[i];
			array[i] = temp;
		}
		PercolateDown(max);
	}
	
	//get the heap element 
	public int DeleteMax(){
		int tempRoot = array[0];
		array[0] = array[this.count - 1];
		PercolateDown(0);
		this.count--;
		return tempRoot;
	}
	
	public void Insert(int data){
		if(this.count == this.capacity)
			ResizeHeap();
		
		this.count++;
		int i = this.count - 1;
		while(i >= 0 && data > this.array[(i-1)/2]){//(i-1)/2 should floor the ratio in order to work
			this.array[i] = this.array[(i-1)/2];
			i = (i-1)/2;
		}
		this.array[i] = data;
	}

	private void ResizeHeap() {
		int[] array_old = new int[this.capacity];
		System.arraycopy(this.array, 0, array_old, 0, this.capacity);
		this.array = new int[this.capacity*2];
		for(int i = 0; i < this.capacity; i++)
			this.array[i] = array_old[i];
		this.capacity = this.capacity*2;
		array_old = null;
	}
	
	public void DestroyHeap(){
		this.count = 0;
		this.array = null;
	}
	
	
}
