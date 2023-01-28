package com.DSA.project;

public class No_6_ReverseALinkedList {
	
	static Node head;
	static class Node {

		int data;
		Node next;

		Node(int d)
		{
			data = d;
			next = null;
		}
	}
	
	Node reverse(Node node)
	{
		Node prev = null;
		Node current = node;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		node = prev;
		return node;
	}

	void printList(Node node)
	{
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
	}

	public static void main(String[] args)
	{
		No_6_ReverseALinkedList list = new No_6_ReverseALinkedList();
		list.head = new Node(20);
		list.head.next = new Node(40);
		list.head.next.next = new Node(60);
		list.head.next.next.next = new Node(70);
		list.head.next.next.next.next = new Node(50);
		list.head.next.next.next.next.next = new Node(10);


		System.out.println("Given linked list");
		list.printList(head);
		head = list.reverse(head);
		System.out.println("");
		System.out.println("Reversed linked list ");
		list.printList(head);
	}
}
