package com.DSA.Project2;

class Node1 {
	int data;
	Node1 left, right;

	Node1(int item) {
		data = item;
		left = right = null;
	}
}
public class No_3_Determine2TreesIdentical {
	Node1 root1, root2;

	/*
	 * Given two trees, return true if they are structurally identical
	 */
	boolean identicalTrees(Node1 a, Node1 b) {
		/* 1. both empty */
		if (a == null && b == null)
			return true;

		/* 2. both non-empty -> compare them */
		if (a != null && b != null)
			return (a.data == b.data && identicalTrees(a.left, b.left) && identicalTrees(a.right, b.right));

		/* 3. one empty, one not -> false */
		return false;
	}

	public static void main(String[] args) {
		No_3_Determine2TreesIdentical tree = new No_3_Determine2TreesIdentical();

		tree.root1 = new Node1(1);
		tree.root1.left = new Node1(9);
		tree.root1.right = new Node1(8);
		tree.root1.left.left = new Node1(7);

		tree.root2 = new Node1(1);
		tree.root2.left = new Node1(9);
		tree.root2.right = new Node1(8);
		tree.root2.left.left = new Node1(7);
		tree.root2.left.right = new Node1(10);


		// Function call
		if (tree.identicalTrees(tree.root1, tree.root2))
			System.out.println("Both trees are identical");
		else
			System.out.println("Trees are not identical");
	}
}
