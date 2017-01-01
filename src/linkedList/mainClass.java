package linkedList;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner  =  new Scanner(System.in);
		System.out.println("Select which linked list to test:");
		System.out.println("1. Single Linked List");
		System.out.println("2. Doubly Linked List");
		String input =  scanner.nextLine();
		switch(input){
		case "1":
			LinkedList sList = new LinkedList();
			testSLL(sList);
			break;
		case "2":
			DoublyLinkedList DLList = new DoublyLinkedList();
			testDLL(DLList);
			break;
		default:
			break;
		}
		
	}

	private static void testSLL(LinkedList sList) {
	
		sList.insert(1, 0);
		sList.insert(2, 1);
		sList.insert(3, 2);
		sList.insert(4, 3);
		sList.insert(5, 4);
		sList.insert(6, 5);
		
		String result = sList.toString();
		System.out.println("Test of toString: " + "\n" + result);
		
		sList.insertAtStart(new listNode(0));
		result = sList.toString();
		System.out.println("Test of insertAtStart: " + "\n" + result);
		
		sList.insertAtEnd(new listNode(7));
		result = sList.toString();
		System.out.println("Test of insertAtEnd: " + "\n" + result);
		
		sList.removeFromStart();
		result = sList.toString();
		System.out.println("Test of removeFromStart: " + "\n" + result);
		
		sList.removeFromEnd();
		result = sList.toString();
		System.out.println("Test of removeFromEnd: " + "\n" + result);
		
		sList.remove(3);
		result = sList.toString();
		System.out.println("Test of remove: " + "\n" + result);		
	}
	
	private static void testDLL(DoublyLinkedList dLList) {
		dLList.insert(1, 0);
		dLList.insert(2, 1);
		dLList.insert(3, 2);
		dLList.insert(4, 3);
		dLList.insert(5, 4);
		dLList.insert(6, 5);
		
		String result = dLList.toString();
		System.out.println(result);
		
		dLList.insertAtStart(-1);
		result = dLList.toString();
		System.out.println(result);
		
		dLList.insertAtTail(7);
		result = dLList.toString();
		System.out.println(result);
		
		dLList.removeFromStart();
		result = dLList.toString();
		System.out.println(result);
		
		dLList.removeFromEnd();
		result = dLList.toString();
		System.out.println(result);
		
		dLList.remove(3);
		result = dLList.toString();
		System.out.println(result);	
	}
		
}

