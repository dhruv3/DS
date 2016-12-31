package linkedList;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList sList = new LinkedList();
		sList.insert(1, 0);
		sList.insert(2, 1);
		sList.insert(3, 2);
		sList.insert(4, 3);
		sList.insert(5, 4);
		sList.insert(6, 5);
		String result = sList.toString();
		System.out.println(result);
		
		sList.insertAtStart(new listNode(0));
		result = sList.toString();
		System.out.println(result);
		
		sList.insertAtEnd(new listNode(7));
		result = sList.toString();
		System.out.println(result);
		
		sList.removeFromStart();
		result = sList.toString();
		System.out.println(result);
		
		sList.removeFromEnd();
		result = sList.toString();
		System.out.println(result);
		
		sList.remove(3);
		result = sList.toString();
		System.out.println(result);
	}

}
