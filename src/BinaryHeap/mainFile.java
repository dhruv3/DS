package BinaryHeap;


public class mainFile {
	

	public static void main(String[] args) {
		int[] myArray = {100, 12,22,3,40,5,6,7,8,9};
		MyBinaryHeap fringe = new MyBinaryHeap(11);
		
		for(int i = 0; i < myArray.length; i++){
			fringe.insert(myArray[i]);
		}
		fringe.print();
		fringe.insert(1);
		fringe.print();
		int nodeIndex = fringe.getIndex(1);
		//System.out.println("\n" + nodeIndex);
		fringe.remove(nodeIndex);
		System.out.println("\n");
		fringe.print();
		
		int nodeIndex3 = fringe.getIndex(3);
		//System.out.println("\n" + nodeIndex);
		fringe.remove(nodeIndex3);
		System.out.println("\n");
		fringe.print();
		
		int nodeIndex4 = fringe.getIndex(5);
		//System.out.println("\n" + nodeIndex);
		fringe.remove(nodeIndex4);
		System.out.println("\n");
		fringe.print();
		
		int nodeIndex5 = fringe.getIndex(7);
		//System.out.println("\n" + nodeIndex);
		fringe.remove(nodeIndex5);
		System.out.println("\n");
		fringe.print();
		
		int nodeIndex6 = fringe.getIndex(6);
		//System.out.println("\n" + nodeIndex);
		fringe.remove(nodeIndex6);
		System.out.println("\n");
		fringe.print();
	}
	
}
