package com.DSA.project;

public class No_5_FindingMidElement {
	
	Node head;
    class Node { 
        int key;
        Node next;
        
        Node(int data)
        {
            key = data;
            next = null;
        }
    }    
    public void push(int data)
    {
        Node new_node = new Node(data);
        new_node.next = head;
        head = new_node;
    }   
    public void insertAtLast(int data)
    {
        Node new_node = new Node(data);
        if(head == null){
            head = new_node;
            return;
        }
        
        
        Node temp = head;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        
        temp.next = new_node;
        return;
    }
    public int getCount()
    {
        int count = 0;
        Node temp = head;
        while(temp!= null)
        {
            count++;
            temp = temp.next;
        }
        return count;
    }
    
    public void findMiddleNode()
    {
        int count = getCount();
        Node temp = head;      

        if(count%2 == 0)
        {
            int i = (count/2) - 1;
            while(i != 0)
            {
                temp = temp.next;
                i--;
            }
            
            System.out.println(temp.key);
        }

        else{
            int i = (count/2);
            while(i != 0)
            {
                temp = temp.next;
                i--;
            }
            System.out.println(temp.key);
        }
    }
 
    public void printList()
    {
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.key + " ");
            temp = temp.next;

        }
    }
    public static void main(String []args)
    {
    	No_5_FindingMidElement Ele = new No_5_FindingMidElement();
        
        Ele.push(1);
        Ele.insertAtLast(2);
        Ele.insertAtLast(3);
        Ele.insertAtLast(4);
        Ele.insertAtLast(5);
        System.out.println("Printing the original Linked List");
        Ele.printList();
        System.out.println("\nThe middle Element in a Linked list is");
        Ele.findMiddleNode();

     }
}
