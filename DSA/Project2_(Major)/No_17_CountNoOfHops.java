package com.DSA.Project2;

public class No_17_CountNoOfHops {
	static int printCountDP(int steps) {
		// Create the array of size 3.
		int[] ways = new int[3];
		int n = steps;

		// Initialize the bases cases
		ways[0] = 1;
		ways[1] = 1;
		ways[2] = 2;

		// Run a loop from 3 to n
		// Bottom up approach to fill the array
		for (int i = 3; i <= n; i++) {
			ways[i % 3] = ways[(i - 1) % 3] + ways[(i - 2) % 3] + ways[(i - 3) % 3];
		}

		return ways[n % 3];
	}

	public static void main(String arg[]) {
		int steps1 = 1;
		System.out.println(printCountDP(steps1));
		int steps2 = 5;
		System.out.println(printCountDP(steps2));
	}
}
