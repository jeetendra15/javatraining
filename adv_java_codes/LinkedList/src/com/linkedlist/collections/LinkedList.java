package com.linkedlist.collections;

public class LinkedList {

	private Node first;

	public void add(int data) {
		Node newNode = new Node();
		newNode.setData(data);
		newNode.setNext(null);

		if (first == null) {
			first = newNode;
			first.setPrevious(null);

		} else {

			Node node = first;
			while (node.getNext() != null) {
				node = node.getNext();
			}

			newNode.setPrevious(node);
			node.setNext(newNode);
		}

	}

	public void get(int position) {

		int count = 0;
		Node node = first;

		while (node != null) {

			if (count == position) {
				System.out.println("value : " + node.getData());
				break;
			}
			count++;
			node = node.getNext();
		}
	}

	public void size() {

		int size = 0;
		Node node = first;
		while (node != null) {
			size++;
			node = node.getNext();
		}
		System.out.println("size : " + size);
	}

	public void remove(int position) {

		int count = 0;
		Node node = first;

		if (position == 0) {
			first = node.getNext();
		}

		while (node != null && count < position - 1) {

			node = node.getNext();
			count++;
		}

		if (node == null || node.getNext() == null) {
			return;
		}

		Node next = node.getNext().getNext();
		node.setNext(next);
	}

	public void show() {

		Node node = first;

		while (node != null) {

			System.out.print(node.getData() + " ");
			node = node.getNext();
		}

		System.out.print("\n");
	}
}
