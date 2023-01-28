package com.DSA.project;

import java.util.Arrays;
import java.util.HashMap;

public class No_11_MinSwapsToSort {
	public static int minSwaps(int[] nums)
	{
		int len = nums.length;
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<len;i++)
			map.put(nums[i], i);
			
		Arrays.sort(nums);
		boolean[] visited = new boolean[len];
		Arrays.fill(visited, false);
		
		// Initialize result
		int ans = 0;
		for(int i=0;i<len;i++) {

			if(visited[i] || map.get(nums[i]) == i)
				continue;
				
			int j = i, cycle_size = 0;
			while(!visited[j]) {
				visited[j] = true;
				
				// move to next node
				j = map.get(nums[j]);
				cycle_size++;
			}
			
			// Update answer by adding current cycle.
			if(cycle_size > 0) {
				ans += (cycle_size - 1);
			}
		}
		return ans;
	}

	public static void main(String[] args)
	{
		int []a = {8, 9, 16, 15 };
		No_11_MinSwapsToSort g = new No_11_MinSwapsToSort();
		System.out.println(g.minSwaps(a));
	}
}
