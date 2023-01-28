package com.DSA.Project2;
import java.util.HashMap;

public class No_7_FindFirstReapeatedChar {

	void findFirstRepeatedChar(String s) {
		if (s.length() <= 0) {
			System.out.println("No string found");
		}
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
		for (int i = 0; i < s.length(); i++) {
			int counter = 0;
			if (hM.containsKey(s.indexOf(s.charAt(i)))) {
				counter = hM.get(s.indexOf(s.charAt(i)));
			}
			hM.put(s.indexOf(s.charAt(i)), counter + 1);
		}
		for (int i = 0; i < s.length();) {
			if (hM.get(s.indexOf(s.charAt(i))) > 1) {
				System.out.println(s.charAt(i));
				break;
			} else if (hM.get(s.indexOf(s.charAt(i))) == 1) {
				i++;
				if (i == s.length()) {
					System.out.println(-1);
				}
			}
		}
	}

	public static void main(String[] args) {
		No_7_FindFirstReapeatedChar str = new No_7_FindFirstReapeatedChar();
		String s1 = "skilllync";
		str.findFirstRepeatedChar(s1);
		String s2 = "helloworld";
		str.findFirstRepeatedChar(s2);
	}
}