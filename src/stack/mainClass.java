package stack;

import java.util.Scanner;

public class mainClass {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Scanner scanner  =  new Scanner(System.in);
		System.out.println("Select which linked list to test:");
		System.out.println("1. Dynamic Array Stack");
		System.out.println("2. Linked List Array Stack");
		String input =  scanner.nextLine();
		switch(input){
		case "1":
			DynamicArrayStack daStack = new DynamicArrayStack(5);
			testSLL(daStack);
			break;
		case "2":
			LinkedStack llStack = new LinkedStack();
			testLLStack(llStack);
			break;
		default:
			break;
		}
		
	}

	private static void testLLStack(LinkedStack llStack) throws Exception {
		llStack.push(1);
		llStack.push(2);
		llStack.push(3);
		llStack.push(4);
		llStack.push(5);
		System.out.println("Initial stack " + llStack.toString());
		
		System.out.println("Topmost element is " + llStack.peek());
		
		llStack.pop();
		llStack.pop();
		System.out.println("Stack after removing 4,5: " + llStack.toString());
		System.out.println("New topmost element is " + llStack.peek());
		
		llStack.push(4);
		llStack.push(5);
		llStack.push(6);
		System.out.println("Check if expanding array is working");
		
		llStack.pop();
		llStack.pop();		
	}

	private static void testSLL(DynamicArrayStack daStack) throws Exception {
	
		daStack.push(1);
		daStack.push(2);
		daStack.push(3);
		daStack.push(4);
		daStack.push(5);
		System.out.println("Initial stack " + daStack.toString());
		
		System.out.println("Topmost element is " + daStack.top());
		
		daStack.pop();
		daStack.pop();
		System.out.println("Stack after removing 4,5: " + daStack.toString());
		System.out.println("New topmost element is " + daStack.top());
		
		daStack.push(4);
		daStack.push(5);
		daStack.push(6);
		System.out.println("Check if expanding array is working");
		
		daStack.pop();
		daStack.pop();
	}
	
		
}

