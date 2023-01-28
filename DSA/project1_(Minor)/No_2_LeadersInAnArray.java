package com.DSA.project;

public class No_2_LeadersInAnArray {
	
	 void printLeaders(int arr[]){
	        for(int i = 0; i < arr.length; i++){
	            int j;
	            for(j = i + 1; j < arr.length; j++){
	                if (arr[i] <=arr[j]){
	                    break;
	                }
	            }
	            if (j == arr.length){ 
	            	
	                System.out.print(arr[i] + " ");
	            } 
	        }
	    }
	    public static void main(String[] args){
	    	No_2_LeadersInAnArray lead = new No_2_LeadersInAnArray();
	        int arr1[] = new int[]{16,17,4,3,5,2};
	        int arr2[] = new int[]{1,2,3,4,0};
	        lead.printLeaders(arr1);
	        System.out.println("  ");
	        lead.printLeaders(arr2);
	    }
 }

