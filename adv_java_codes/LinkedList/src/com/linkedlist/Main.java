package com.linkedlist;

import com.linkedlist.collections.LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList linkedList = new LinkedList();

		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(30);
		linkedList.add(40);
		linkedList.add(50);

		linkedList.show();

		linkedList.get(3);

		linkedList.size();
		
		linkedList.remove(3);

		linkedList.show();
	}

}
