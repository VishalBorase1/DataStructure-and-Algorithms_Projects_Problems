package com.DSA.project;

import java.util.Stack;

class newStack{ 
    Stack<Integer> s; 
    Integer min; 
  
    newStack(){ 
        s = new Stack<Integer>(); 
    } 
  
    void getMin(){ 
        if(s.isEmpty()) 
            System.out.println("Stack is empty"); 
  
        else{
            System.out.println("Minimum element : " + min);
        }    
    } 
  
    void pop(){ 
        if (s.isEmpty()){ 
            System.out.println("Stack is empty"); 
            return; 
        } 
  
        System.out.print("Popped element : "); 
        Integer t = s.pop(); 
  
        if(t<min){ 
            System.out.println(min); 
            min = 2*min - t; 
        } 
  
        else{
            System.out.println(t);
        }    
    } 
  
    void push(Integer x){ 
        if(s.isEmpty()){ 
            min = x; 
            s.push(x); 
            return; 
        } 
  
        if(x<min){ 
            s.push(2*x - min); 
            min = x; 
        } 
  
        else{
            s.push(x); 
        }    
    } 
}; 
  
public class No_12_GetMinElementFromStack {
    public static void main(String[] args){ 
        newStack s = new newStack(); 
        
        s.push(2);
        s.push(3);
        s.pop();
        s.getMin();
        s.push(1);
        s.getMin();
        
    } 
}
