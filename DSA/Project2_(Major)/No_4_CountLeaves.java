package com.DSA.Project2;
//Java implementation to find leaf count of a given Binary tree

/* Class containing left and right child of current
node and key value*/
class Node2 {
	int data;
	Node2 left, right;

	public Node2(int item) {
		data = item;
		left = right = null;
	}
}

public class No_4_CountLeaves {
	// Root of the Binary Tree
	Node2 root;

	/* Function to get the count of leaf nodes in a binary tree */
	int getLeafCount() {
		return getLeafCount(root);
	}

	int getLeafCount(Node2 node) {
		if (node == null)
			return 0;
		if (node.left == null && node.right == null)
			return 1;
		else
			return getLeafCount(node.left) + getLeafCount(node.right);
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {
		/* create a tree */
		No_4_CountLeaves tree = new No_4_CountLeaves();
		tree.root = new Node2(3);
		tree.root.left = new Node2(4);
		tree.root.right = new Node2(2);

		/* get leaf count of the above tree */
		System.out.println("The leaf count of binary tree is : " + tree.getLeafCount());
	}
}
