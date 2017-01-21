package BinaryTree;

import java.util.Stack;

public class mainClassIterative {

	public static void main(String[] args) {
		BinaryTreeNode root = createTree();
		System.out.println("PreOrder Traversal:");
		PreOrder(root);
		System.out.println("InOrder Traversal:");
		InOrder(root);
		System.out.println("PostOrder Traversal:");
		PostOrder(root);
	}
	
	//Root L R
	//each node is processed BEFORE either of its subtree
	private static void PreOrder(BinaryTreeNode root) {
		Stack<BinaryTreeNode> st = new Stack<BinaryTreeNode>();
		st.add(root);
		while(!st.isEmpty()){
			BinaryTreeNode temp = st.pop();
			System.out.println(temp.getData());
			if(temp.getRight() != null)
				st.add(temp.getRight());
			if(temp.getLeft() != null)
				st.add(temp.getLeft());
		}
	}

	//L R Root
	//tutorial: https://www.youtube.com/watch?v=xLQKdq0Ffjg
	private static void PostOrder(BinaryTreeNode root) {
		BinaryTreeNode current = root;
		Stack<BinaryTreeNode> st = new Stack<BinaryTreeNode>();
		//loop 
		while(current != null || !st.isEmpty()){
			//if current is not empty; add it to stack and update current to left node
			if(current != null){
				st.push(current);
				current = current.getLeft();
			}
			else{
				//get right node of topmost node in the stack
				BinaryTreeNode temp = ((BinaryTreeNode) st.peek()).getRight();
				//if right node does NOT exist
				if(temp == null){
					//right node is NULL-->We are done with LEFT and RIGHT side of topmost stack node
					//pop and print topmost stack element
					temp = (BinaryTreeNode) st.pop();
					System.out.println(temp.getData());
					//check if popped node is same as the NEW topmost node right neighbor
					//if it is => we have completed with both left & right subtrees
					//pop topmost node
					while(!st.isEmpty() && temp == ((BinaryTreeNode) st.peek()).getRight()){
						temp = (BinaryTreeNode) st.pop();
						System.out.println(temp.getData());
					}
				}
				else{
					//set current to temp; This will insert the right element into the stack.
					current = temp;
				}
			}
		}
	}

	//L Root R
	private static void InOrder(BinaryTreeNode root) {
		Stack<BinaryTreeNode> st = new Stack<BinaryTreeNode>();
		BinaryTreeNode currentNode = root;
		do{
			if(currentNode != null){
				st.add(currentNode);
				currentNode = currentNode.getLeft();
			}
			else{
				currentNode = st.pop();
				System.out.println(currentNode.getData());
				currentNode = currentNode.getRight();
			}
		}while(!st.isEmpty() || (currentNode != null));
	}


	private static BinaryTreeNode createTree() {
		BinaryTreeNode n1 = new BinaryTreeNode(1);
		BinaryTreeNode n2 = new BinaryTreeNode(2);
		BinaryTreeNode n3 = new BinaryTreeNode(3);
		n1.setLeft(n2);
		n1.setRight(n3);
		BinaryTreeNode n4 = new BinaryTreeNode(4);
		BinaryTreeNode n5 = new BinaryTreeNode(5);
		n2.setLeft(n4);
		n2.setRight(n5);
		BinaryTreeNode n6 = new BinaryTreeNode(6);
		BinaryTreeNode n7 = new BinaryTreeNode(7);
		n3.setLeft(n6);
		n3.setRight(n7);
		
		BinaryTreeNode root = n1;
		
		return root;
	}

}
