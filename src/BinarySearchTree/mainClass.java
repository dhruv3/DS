package BinarySearchTree;

public class mainClass {

	public static void main(String[] args) {
		BSTNode root = createTree();
		System.out.println("InOrder traversal of BST gives us a sorted list:");
		InOrder(root);
		//finding a node
		BSTNode node = findNode(root, 12);
		if (node == null)
			System.out.println("Integer not found");
		else
			System.out.println("Integer is present");
		//finding min node
		BSTNode minNode = findMin(root);
		System.out.println("Minimum Integer present is " + minNode.getData());
		//finding max node
		BSTNode maxNode = findMax(root);
		System.out.println("Maximum Integer present is " + maxNode.getData());
		//insert a node
		insert(root, 200);
		System.out.println("New tree after insertion:");
		InOrder(root);
		//delete a node
		Delete(root, 10);
		System.out.println("New tree after deletion:");
		InOrder(root);
	}
	
	private static BSTNode Delete(BSTNode root, int data){
		if(root == null)
			System.out.println("Element not present");
		
		if(data > root.getData()){
			root.right = Delete(root.getRight(), data);
		}
		else if(data < root.getData()){
			root.left = Delete(root.getLeft(), data);
		}
		//node to be deleted found
		else{
			//node to be deleted has two children
			//get max node in left subtree and recursively delete that max node
			if(root.getLeft() != null && root.getRight() != null){
				BSTNode temp = findMax(root.getLeft());
				root.setData(temp.getData());
				root.left = Delete(root.getLeft(), temp.getData());
			}
			//node has only one child
			else{
				//if both child are null then this case is also handled below
				if(root.getLeft() == null){
					root = root.getRight();
				}
				else if(root.getRight() == null){
					root = root.getLeft();
				}
			}
		}
		return root;
	}
	
	private static void insert(BSTNode root, int data) {
		BSTNode newNode = new BSTNode(data);
		BSTNode temp = root;
		if(root == null)
			root = newNode;
		
		while(temp != null){
			if(temp.getData() > data){
				//check if you have encountered the desired leaf node
				//insert at appropriate place
				if(temp.getLeft() == null){
					temp.setLeft(newNode);
					break;
				}
				temp = temp.getLeft();
			}
			else{
				if(temp.getRight() == null){
					temp.setRight(newNode);
					break;
				}
				temp = temp.getRight();
			}
		}
	}

	private static BSTNode findMax(BSTNode root) {
		if(root == null)
			return root;
		
		if(root.getRight() == null)
			return root;
		else
			return findMax(root.getRight());
	}
	
	private static BSTNode findMin(BSTNode root) {
		if(root == null)
			return root;
		
		if(root.getLeft() == null)
			return root;
		else
			return findMin(root.getLeft());
	}

	private static BSTNode findNode(BSTNode root, int data) {
		if(root == null)
			return root;
		
		if(root.getData() == data)
			return root;
		else if(root.getData() > data)
			return findNode(root.getLeft(), data);
		else
			return findNode(root.getRight(), data);
	}

	//L Root R
	private static void InOrder(BSTNode root) {
		if(root != null){
			InOrder(root.getLeft());
			System.out.println(root.getData());
			InOrder(root.getRight());
		}
	}

	private static BSTNode createTree() {
		BSTNode n1 = new BSTNode(10);
		BSTNode n2 = new BSTNode(8);
		BSTNode n3 = new BSTNode(12);
		n1.setLeft(n2);
		n1.setRight(n3);
		BSTNode n4 = new BSTNode(4);
		BSTNode n5 = new BSTNode(9);
		n2.setLeft(n4);
		n2.setRight(n5);
		BSTNode n6 = new BSTNode(11);
		BSTNode n7 = new BSTNode(13);
		n3.setLeft(n6);
		n3.setRight(n7);
		
		BSTNode root = n1;
		
		return root;
	}

}
