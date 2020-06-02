package collection.binarytree;

public class BinaryTree {

	static class Node {
		int value;
		Node left, right;

		Node(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}

	public void addItem(Node node, int value) {

		if (value < node.value) {
			if (node.left != null) {
				addItem(node.left, value);
			} else {
				node.left = new Node(value);
			}
		} else if (value > node.value) {
			if (node.right != null) {
				addItem(node.right, value);
			} else {
				node.right = new Node(value);
			}
		}
	}

	public void traverseInOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			System.out.print(" " + node.value);
			traverseInOrder(node.right);
		}
	}

	public void traversePreOrder(Node node) {
		if (node != null) {
			System.out.print(" " + node.value);
			traverseInOrder(node.left);
			traverseInOrder(node.right);
		}
	}

	public void traversePostOrder(Node node) {
		if (node != null) {
			traverseInOrder(node.left);
			traverseInOrder(node.right);
			System.out.print(" " + node.value);
		}
	}
}
