package com.DSA.Project2;

public class No_2_PerMutationOfString {
	static void permute(String s, int l, int r) {
		if (l == r) {
			System.out.print(s + " ");
		} else {
			for (int i = l; i <= r; i++) {
				s = swap(s, l, i);
				permute(s, l + 1, r);
				s = swap(s, l, i);
			}
		}
	}

	static String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	public static void main(String[] args) {
		String str1 = "ABC";
		int n1 = str1.length();
		permute(str1, 0, n1 - 1);

		System.out.println();

		String str2 = "ABSG";
		int n2 = str2.length();
		permute(str2, 0, n2 - 1);
	}
}
