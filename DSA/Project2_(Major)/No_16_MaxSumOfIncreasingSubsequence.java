package com.DSA.Project2;

public class No_16_MaxSumOfIncreasingSubsequence {

	static int maxSumIS(int arr[], int n) {
		int i, j, max = 0;
		int msum_arr[] = new int[n];

		/* Initialize msum_arr values for all indexes */
		for (i = 0; i < n; i++) {
			msum_arr[i] = arr[i];
		}

		/* Compute maximum sum values in bottom up manner */
		for (i = 1; i < n; i++) {
			for (j = 0; j < i; j++) {
				if (arr[i] > arr[j] && msum_arr[i] < msum_arr[j] + arr[i]) {
					msum_arr[i] = msum_arr[j] + arr[i];
				}
			}
		}

		/* Pick maximum of all msum_arr values */
		for (i = 0; i < n; i++) {
			if (max < msum_arr[i]) {
				max = msum_arr[i];
			}
		}

		return max;
	}

	public static void main(String args[]) {
		int arr[] = { 1, 101, 2, 3, 100, 4, 5 };
		int n = arr.length;
		System.out.println(maxSumIS(arr, n));

		int arr2[] = { 10, 5, 4, 3 };
		int n2 = arr2.length;
		System.out.println(maxSumIS(arr2, n2));
	}
}

