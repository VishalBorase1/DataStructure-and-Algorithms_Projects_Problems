package com.DSA.Project2;


public class No_20_LargestNumberPossible {

	static void largestNum(int N, int S) {
		// if sum is 0
		if (S == 0) {
			System.out.print(N == 1 ? 0 : -1);
			return;
		}

		// Sum greater than the maximum possible sum
		if (S > 9 * N) {
			System.out.println(-1);
			return;
		}

		// create result array
		int[] res = new int[N];
		for (int i = 0; i < N; i++) {
			if (S >= 9) {
				res[i] = 9;
				S -= 9;
			} else {
				res[i] = S;
				S = 0;
			}
		}
		for (int i = 0; i < N; i++)
			System.out.print(res[i] + "");
		System.out.println();
	}

	public static void main(String[] args) {
		largestNum(2, 9);
		largestNum(3, 20);
	}
}

