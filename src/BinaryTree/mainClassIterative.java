package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class mainClassIterative {

	public static void main(String[] args) {
		Node root1 = createTree1();
		BinaryTreeNode root = createTree();
		System.out.println("PreOrder Traversal:");
		PreOrder(root);
		System.out.println("InOrder Traversal:");
		InOrder(root);
		System.out.println("PostOrder Traversal:");
		PostOrder(root);
		System.out.println("Level Order Traversal:");
		LevelOrder(root);
		bfs(root1);
	}
	
	private static LinkedList bfs(Node root){
	    LinkedList<String> res = new LinkedList<String>();
	    Queue<Node> myQ = new LinkedList<Node>();
	    myQ.add(root);
	    while(!myQ.isEmpty()){
	        //tackling the None case
	        Node tmp = myQ.poll();
	        if(tmp.getData() == Integer.MAX_VALUE){
	            res.add("None");
	            continue;
	        }
	        else{
	            //to do type conversion from int to string 
	            res.add(""+tmp.getData());
	        }
	        //Now add children to queue
	        //if left or right child is not present then create a fake node with data not set and add it to the queue
	        if(tmp.getLeftChild() == null && tmp.getRightChild() == null){
	            continue;
	        }
	        if(tmp.getLeftChild() == null){
	            Node fake = new Node(Integer.MAX_VALUE);
	            myQ.add(fake);
	        }
	        else{
	            myQ.add(tmp.getLeftChild());
	        }
	        if(tmp.getRightChild() == null){
	            Node fake = new Node(Integer.MAX_VALUE);
	            myQ.add(fake);
	        }
	        else{
	            myQ.add(tmp.getRightChild());
	        }
	    }
	    return res;
	}
	
	//BFS
	private static void LevelOrder(BinaryTreeNode root) {
		Queue<BinaryTreeNode> myLine = new LinkedList<BinaryTreeNode>();
		myLine.add(root);
		while(!myLine.isEmpty()){
			BinaryTreeNode temp = myLine.poll();
			System.out.println(temp.getData());
			if(temp.getLeft() != null){
				myLine.add(temp.getLeft());
			}
			if(temp.getRight() != null){
				myLine.add(temp.getRight());
			}
		}
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
	
	private static Node createTree1() {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		n1.setLeftChild(n2);
		n1.setRightChild(n3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		n2.setRightChild(n4);
		n3.setLeftChild(n5);
		Node root = n1;
		
		return root;
	}

}
