package com.DSA.project;

class Node {
    int key;
    Node left, right;
	public Object next;
	public int data;

    public Node(int key){
        this.key = key;
        left = right = null;
    }
}

public class No_9_BinaryTreeToDLL {
    Node root, head;
      
    static Node prev = null;
  
    void BinaryTree2DoubleLinkedList(Node root){
        
        if (root == null)
            return;

        BinaryTree2DoubleLinkedList(root.left);

        if (prev == null)
            head = root;
        else
        {
            root.left = prev;
            prev.right = root;
        }
        prev = root;

        BinaryTree2DoubleLinkedList(root.right);
    }
  
    void printList(Node node)
    {
        while (node != null)
        {
            System.out.print(node.key + "==");
            node = node.right;
        }
    }
  
    public static void main(String[] args)
    {
    	No_9_BinaryTreeToDLL tree = new No_9_BinaryTreeToDLL();
        tree.root = new Node(10);
        tree.root.left = new Node(12);
        tree.root.right = new Node(15);
        tree.root.left.left = new Node(25);
        tree.root.left.right = new Node(30);
        tree.root.right.left = new Node(36);
  
        tree.BinaryTree2DoubleLinkedList(tree.root);
          
        tree.printList(tree.head);
  
    }
}