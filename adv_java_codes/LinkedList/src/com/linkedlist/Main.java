package com.linkedlist;

import com.linkedlist.collections.LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<Integer> linkedList = new LinkedList<Integer>();
		// LinkedList<String> linkedList = new LinkedList<String>();

		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(30);
		linkedList.add(40);
		linkedList.add(50);

		linkedList.show();

		linkedList.get(10);

		linkedList.size();

		linkedList.remove(3);

		linkedList.show();
	}

}
