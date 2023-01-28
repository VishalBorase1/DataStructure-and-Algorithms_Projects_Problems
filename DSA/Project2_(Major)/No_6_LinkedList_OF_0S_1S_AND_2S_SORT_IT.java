package com.DSA.Project2;

//Java program to sort a linked list of 0, 1 and 2
public class No_6_LinkedList_OF_0S_1S_AND_2S_SORT_IT {

	Node head; // head of list

	/* Linked list Node */
	class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	void sortList() {
		// initialise count of 0 1 and 2 as 0
		int count[] = { 0, 0, 0 };

		Node ptr = head;

		while (ptr != null) {
			count[ptr.data]++;
			ptr = ptr.next;
		}

		int i = 0;
		ptr = head;

		while (ptr != null) {
			if (count[i] == 0)
				i++;
			else {
				ptr.data = i;
				--count[i];
				ptr = ptr.next;
			}
		}
	}

	/* Utility functions */

	/* Inserts a new Node at front of the list. */
	public void push(int new_data) {
		/*
		 * 1 & 2: Allocate the Node & Put in the data
		 */
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	/* Function to print linked list */
	void printList() {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		No_6_LinkedList_OF_0S_1S_AND_2S_SORT_IT llist = new No_6_LinkedList_OF_0S_1S_AND_2S_SORT_IT();

		llist.push(2);
		llist.push(2);
		llist.push(0);
		llist.push(2);
		llist.push(1);
		llist.push(2);
		llist.push(2);
		llist.push(1);

		System.out.println("Linked List before sorting");
		llist.printList();

		llist.sortList();

		System.out.println("Linked List after sorting");
		llist.printList();
	}
}
