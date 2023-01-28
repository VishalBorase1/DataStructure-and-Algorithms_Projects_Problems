package com.DSA.project;

public class No_7_PairwiseSwap {

	Node head; 
	class Node {
		int data;
		Node next;
		Node(int d)
		{
			data = d;
			next = null;
		}
	}

	void pairWiseSwap()
	{
		Node temp = head;

		/* Traverse only till there are atleast 2 nodes left */
		while (temp != null && temp.next != null) {

			/* Swap the data */
			int k = temp.data;
			temp.data = temp.next.data;
			temp.next.data = k;
			temp = temp.next.next;
		}
	}

	/* Utility functions */

	/* Inserts a new Node at front of the list. */
	public void push(int new_data)
	{
		/* 1 & 2: Allocate the Node &
				Put in the data*/
		Node new_node = new Node(new_data);

		/* 3. Make next of new Node as head */
		new_node.next = head;

		/* 4. Move the head to point to new Node */
		head = new_node;
	}

	/* Function to print linked list */
	void printList()
	{
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Driver program to test above functions */
	public static void main(String args[])
	{
		No_7_PairwiseSwap list = new No_7_PairwiseSwap();

		list.push(8);
		list.push(7);
		list.push(6);
		list.push(5);
		list.push(4);
		list.push(2);
		list.push(2);
		list.push(1);


		System.out.println("Linked List before calling pairWiseSwap() ");
		list.printList();

		list.pairWiseSwap();

		System.out.println("Linked List after calling pairWiseSwap() ");
		list.printList();
	}
}
