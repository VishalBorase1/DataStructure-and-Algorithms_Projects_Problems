package com.DSA.project;

public class No_1_EquilibriumPoint {

    int findEquilibrium(int [] A, int n){
        int sum = 0; 
        int leftsum = 0; 
 
   
        for (int i = 0; i < n; i++){
            sum = sum + A[i];
        }
 
        for (int i = 0; i < n; i++) {
            sum = sum - A[i];
            if (leftsum == sum){
                return i;
            }
            leftsum = leftsum + A[i];
        }
        return -1;
    }

    public static void main(String[] args) {
    	No_1_EquilibriumPoint ep = new No_1_EquilibriumPoint();
        int [] arr1 = {1};
        int n1 = arr1.length;
        int [] arr2 = { 1, 3, 5, 2, 2};
        int n2 = arr2.length;
        int result1 = ep.findEquilibrium(arr1, n1);
        int result2 = ep.findEquilibrium(arr2, n2);
        System.out.println(result1);
        System.out.println(result2);

    }
}