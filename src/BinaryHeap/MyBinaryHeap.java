package BinaryHeap;

public class MyBinaryHeap {
	
    private static int index=0;
    public int[] heap;
    
    public MyBinaryHeap(int size){
        heap = new int[size+1];
        heap[0] = -1;
    }
    
	public void insert(int element){
        heap[++index] = element;
        travelUp(index);
	}

	private void travelUp(int newPosition) {
	      int temp = heap[newPosition];
	      int parent = (int)Math.ceil(((double)(newPosition-1)/2));
	      while (newPosition > 1 && heap[parent] > temp){
	    	 heap[newPosition] = heap[parent];
	         newPosition = parent;
	         parent = (int)Math.ceil(((double)(newPosition-1)/2));
	      }
	      if((index == 2 || index == 3) && heap[1] > temp){
	    	  heap[newPosition] = heap[1];
	    	  heap[1] = temp;
	      }
	      else
	    	  heap[newPosition] = temp;
	}
	
	
	
	public void print() {
		for(int i = 1; i < heap.length; i++){
			System.out.println(heap[i] + ", ");
		}
		System.out.println("");
	}

	public int getIndex(int element) {
		for(int i = 1; i < heap.length; i++){
			if(heap[i] == element)
				return i;
		}
		return 0;
	}

	public void remove(int nodeIndex) {
		heap[nodeIndex] = heap[index];
		//heap[index] = Integer.MAX_VALUE;
		index--;		
		//travelUp(index);
		travelDown(nodeIndex);
	}

	private void travelDown(int currPos) {
		int leftNode= 2*currPos;
        int rightNode = (2*currPos)+1;
        int temp = heap[currPos];
        
        while(leftNode<=index){
        	
        	if(rightNode<=index){
        		if (temp > heap[leftNode] && temp > heap[rightNode]) {
        			if(heap[leftNode] > heap[rightNode]){
        				heap[currPos] = heap[rightNode];
        				currPos = rightNode;
        			}
        			else{
        				heap[currPos] = heap[leftNode];
        				currPos = leftNode;
        			}
        		}
        		else if ((temp > heap[leftNode] && temp < heap[rightNode])) {
        			heap[currPos] = heap[leftNode];
        			currPos = leftNode;
        		}
        	    else if (temp < heap[leftNode] && temp > heap[rightNode]) {
        			heap[currPos] = heap[rightNode];
        			currPos = rightNode;
        		}
        	    else{
        	    	break;
        	    }
        	}
        	else{
        		if (temp > heap[leftNode]) {
        			heap[currPos] = heap[leftNode];
        			currPos = leftNode;
        		}
        	    else{
        	    	break;
        	    }
        	}
        	leftNode = 2*currPos;
        	rightNode = (2*currPos)+1;
        
        }
       
        heap[currPos] = temp;
	}
	
	public void clear() {
		index=0;
	}

	public int getRoot() {
		return heap[1];
	} 
	
	public int contains(int nextNode) {
		int temp=0;
		
		if(isEmpty()){
			return 0;
		}
		
		else{
			for (int i=1;i<=index;i++){
				if(heap[i] == nextNode && heap[i] == nextNode){
					temp=i;
					break;
				}
			}
		}
		return temp;
	}

	private boolean isEmpty() {
		if(index == 0){
    		return true;
    	}
		return false;
	}
	
}
