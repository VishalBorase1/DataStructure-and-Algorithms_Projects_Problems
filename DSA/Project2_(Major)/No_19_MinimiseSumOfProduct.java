package com.DSA.Project2;

import java.util.Arrays;

public class No_19_MinimiseSumOfProduct {

	static long minimiseSum(int[] arr1, int[] arr2, int n) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);

		long result = 0;
		for (int i = 0; i < n; i++)
			result += (arr1[i] * arr2[n - i - 1]);

		return result;
	}

	public static void main(String[] args) {
		int arr1[] = { 3, 1, 1 };
		int arr2[] = { 6, 5, 4 };
		int n1 = arr1.length;

		System.out.println(minimiseSum(arr1, arr2, n1));

		int arr3[] = { 6, 1, 9, 5, 4 };
		int arr4[] = { 3, 4, 8, 2, 4 };
		int n2 = arr3.length;

		System.out.println(minimiseSum(arr3, arr4, n2));
	}
}
