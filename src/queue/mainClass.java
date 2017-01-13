package queue;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) throws Exception {
		Scanner scanner  =  new Scanner(System.in);
		System.out.println("Select which queue to test:");
		System.out.println("1. Fixed Size Array Queue");
		System.out.println("2. Linked List Queue");
		String input =  scanner.nextLine();
		switch(input){
		case "1":
			FixedSizeArrayQueue fixedArrQ = new FixedSizeArrayQueue(5);
			testArr(fixedArrQ);
			break;
		case "2":
			break;
		default:
			break;
		}
		
	}

	private static void testArr(FixedSizeArrayQueue fixedArrQ) throws Exception {
		System.out.println("Is queue empty? " + fixedArrQ.isEmpty());
		fixedArrQ.enqueue(1);
		fixedArrQ.enqueue(2);
		fixedArrQ.enqueue(3);
		fixedArrQ.enqueue(4);
		fixedArrQ.enqueue(5);
		System.out.println("Queue created is- " + fixedArrQ.toString());
		System.out.println("Queue size is- " + fixedArrQ.getSize());
		System.out.println("Is queue full? " + fixedArrQ.isFull());
		System.out.println("On dequeuing 3 times we get- " + fixedArrQ.dequeue() + ", " + fixedArrQ.dequeue() + ", " + fixedArrQ.dequeue());
		System.out.println("New queue created is- " + fixedArrQ.toString());
		System.out.println("Queue size is- " + fixedArrQ.getSize());
	}

}

