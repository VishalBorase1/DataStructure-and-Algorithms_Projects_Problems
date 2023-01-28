package com.DSA.Project2;


import java.util.Arrays;

public class No_9_RelativeSorting {

	static int first(int arr[], int low, int high, int x, int n) {
		if (high >= low) {
			/* (low + high)/2; */
			int mid = low + (high - low) / 2;

			if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
				return mid;
			if (x > arr[mid])
				return first(arr, (mid + 1), high, x, n);
			return first(arr, low, (mid - 1), x, n);
		}
		return -1;
	}
	static void sortAccording(int A1[], int A2[], int m, int n) {
		int temp[] = new int[m], visited[] = new int[m];
		for (int i = 0; i < m; i++) {
			temp[i] = A1[i];
			visited[i] = 0;
		}

		Arrays.sort(temp);
		int ind = 0;
		for (int i = 0; i < n; i++) {
			int f = first(temp, 0, m - 1, A2[i], m);
			// If not present, no need to proceed
			if (f == -1)
				continue;
			// Copy all occurrences of A2[i] to A1[]
			for (int j = f; (j < m && temp[j] == A2[i]); j++) {
				A1[ind++] = temp[j];
				visited[j] = 1;
			}
		}

		// Now copy all items of temp[] which are
		// not present in A2[]
		for (int i = 0; i < m; i++)
			if (visited[i] == 0)
				A1[ind++] = temp[i];
	}

	static void printArray(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	public static void main(String args[]) {
		int A1[] = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 };
		int A2[] = { 2, 1, 8, 3 };
		int m = A1.length;
		int n = A2.length;
		System.out.println("Sorted array is ");
		sortAccording(A1, A2, m, n);
		printArray(A1, m);
	}
}

