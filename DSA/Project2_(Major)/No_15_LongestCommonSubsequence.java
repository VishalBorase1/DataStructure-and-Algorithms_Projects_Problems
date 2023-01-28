package com.DSA.Project2;


//Dynamic programming
import java.util.HashMap;
import java.util.Map;

public class No_15_LongestCommonSubsequence {
	public static int findLCS(String X, String Y, int m, int n, Map<String, Integer> lookup) {
		// return if the end of either string is reached
		if (m == 0 || n == 0) {
			return 0;
		}

		// construct a unique map key from dynamic elements of the input
		String key = m + "|" + n;

		// if the subproblem is seen for the first time, solve it and store its result
		// in a map
		if (!lookup.containsKey(key)) {
			// if the last character of `X` and `Y` matches
			if (X.charAt(m - 1) == Y.charAt(n - 1)) {
				lookup.put(key, findLCS(X, Y, m - 1, n - 1, lookup) + 1);
			} else {
				// otherwise, if the last character of `X` and `Y` don't match
				lookup.put(key, Integer.max(findLCS(X, Y, m, n - 1, lookup), findLCS(X, Y, m - 1, n, lookup)));
			}
		}

		// return the subproblem solution from the map
		return lookup.get(key);
	}

	public static void main(String[] args) {
		String X = "ABCBDAB", Y = "BDCABA";

		// create a map to store solutions to subproblems
		Map<String, Integer> lookup = new HashMap<>();

		System.out.println("The length of the LCS is " + findLCS(X, Y, X.length(), Y.length(), lookup));
	}
}
