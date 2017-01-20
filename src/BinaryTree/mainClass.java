package BinaryTree;

public class mainClass {

	public static void main(String[] args) {
		BinaryTreeNode root = createTree();
		System.out.println("PreOrder Traversal:");
		PreOrder(root);
		System.out.println("InOrder Traversal:");
		InOrder(root);
		System.out.println("PostOrder Traversal:");
		PostOrder(root);
	}

	private static void PostOrder(BinaryTreeNode root) {
		if(root != null){
			PostOrder(root.getLeft());
			PostOrder(root.getRight());
			System.out.println(root.getData());
		}
	}

	//L Root R
	private static void InOrder(BinaryTreeNode root) {
		if(root != null){
			InOrder(root.getLeft());
			System.out.println(root.getData());
			InOrder(root.getRight());
		}
	}

	//Root L R
	//each node is processed BEFORE either of its subtree
	private static void PreOrder(BinaryTreeNode root) {
		if(root != null){
			System.out.println(root.getData());
			PreOrder(root.getLeft());
			PreOrder(root.getRight());
			//following check was required because I used while instead of if
			//corrected code by using if
			//root = null;
		}
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
