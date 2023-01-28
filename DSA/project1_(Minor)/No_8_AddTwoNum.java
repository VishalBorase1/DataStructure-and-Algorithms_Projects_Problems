package com.DSA.project;
import java.util.*;

//Node Class
class Node1{
	int data;
	Node1 next;
	Node1(int data, Node1 next){
		this.data = data;
		this.next = next;
	}
}

//Public class
public class No_8_AddTwoNum{

 // convertList method to
 // convert Integer to List
 public static Node1 convertList(int num){
     Node1 l = null;
     while(num != 0){
			l = new Node1(num%10, l);
			num = num/10;
		}
		return l;
 }

 // toInteger method to
 // convert List to Integer
	public static int toInteger(Node1 l){
		Node1 curr = l;
		int ans = 0;
		while(curr != null){
			ans = ans*10 + curr.data;
			curr = curr.next;
		}
		return ans;
	}

	// reverse method to reverse
	// the Linked List
	public static Node1 reverse(Node1 head){
		Node1 prev = head;
		Node1 curr = head.next;
		while(curr != null){
			Node1 next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head.next = null;
		head = prev;
		return head;
	}

	// addList to add the content
	// of the Linked List
	public static Node1 addList(Node1 l1, Node1 l2){
		l1 = reverse(l1);
		l2 = reverse(l2);
		int num1 = toInteger(l1);
		int num2 = toInteger(l2);
		int sum = num1 + num2;
		Node1 l3 = convertList(sum);
		l3 = reverse(l3);
		return l3;
	}

	// printList to print the content
	// of the Linked List
	public static void printList(Node1 ans){
	    Node1 curr = ans;
	    while(curr != null){
	        System.out.print(curr.data+" ");
	        curr = curr.next;
	    }
	}

	// main method
	public static void main(String[] args){
		int x = 45;
		int y = 345;
		Node1 l1 = convertList(x);
		Node1 l2 = convertList(y);
		Node1 ans = addList(l1, l2);
		printList(ans);
	}
}
