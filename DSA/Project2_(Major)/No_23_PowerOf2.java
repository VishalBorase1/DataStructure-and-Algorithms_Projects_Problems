package com.DSA.Project2;

public class No_23_PowerOf2 {
	static boolean isPowerOfTwo(int x) {

		/* First x in the below expression is for the case when x is 0 */
		return x != 0 && ((x & (x - 1)) == 0);

	}

	public static void main(String[] args) {
		System.out.println(isPowerOfTwo(1) ? "Yes" : "No");
		System.out.println(isPowerOfTwo(98) ? "Yes" : "No");
	}
}
