package collection.binarytree;

import collection.binarytree.BinaryTree.Node;

public class Program {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BinaryTree tree = new BinaryTree();

		// insert first node
		Node root = new Node(5);

		// adding data
		tree.addItem(root, 2);
		tree.addItem(root, 4);
		tree.addItem(root, 8);
		tree.addItem(root, 6);
		tree.addItem(root, 7);
		tree.addItem(root, 3);
		tree.addItem(root, 9);

		System.out.println("In Order");
		tree.traverseInOrder(root);

		System.out.println();

		System.out.println("Pre Order");
		tree.traversePreOrder(root);

		System.out.println();

		System.out.println("Post Order");
		tree.traversePostOrder(root);
	}

}
