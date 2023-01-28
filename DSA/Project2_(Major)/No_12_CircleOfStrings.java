package com.DSA.Project2;

import java.util.ArrayList;
import java.util.List;

public class No_12_CircleOfStrings {

	static final int CHARS = 26;
	int V;
	List<List<Integer>> adj;
	int[] in;

	// Constructor
	No_12_CircleOfStrings(int V) {
		this.V = V;
		in = new int[V];
		adj = new ArrayList<>(CHARS);

		for (int i = 0; i < CHARS; i++) {
			adj.add(i, new ArrayList<>());
		}
	}

	void addEdge(int v, int w) {
		adj.get(v).add(w);
		in[w]++;
	}

	boolean isEulerianCycle() {
		if (!isSC())
			return false;
		for (int i = 0; i < V; i++)
			if (adj.get(i).size() != in[i])
				return false;

		return true;
	}

	boolean isSC() {

		boolean[] visited = new boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;
		int n;
		for (n = 0; n < V; n++)
			if (adj.get(n).size() > 0)
				break;

		// Do DFS traversal starting from
		// first non zero degree vertex.
		DFSUtil(n, visited);

		for (int i = 0; i < V; i++)
			if (adj.get(i).size() > 0 && !visited[i])
				return false;

		No_12_CircleOfStrings gr = getTranspose();

		for (int i = 0; i < V; i++)
			visited[i] = false;

		gr.DFSUtil(n, visited);

		for (int i = 0; i < V; i++)
			if (adj.get(i).size() > 0 && !visited[i])
				return false;

		return true;
	}

	void DFSUtil(int v, boolean[] visited) {
		visited[v] = true;
		for (Integer i : adj.get(v))
			if (!visited[i]) {
				DFSUtil(i, visited);
			}
	}

	No_12_CircleOfStrings getTranspose() {
		No_12_CircleOfStrings g = new No_12_CircleOfStrings(V);
		for (int v = 0; v < V; v++) {
			for (Integer i : adj.get(v)) {
				g.adj.get(i).add(v);
				g.in[v]++;
			}
		}
		return g;
	}

	static boolean canBeChained(String[] arr, int n) {

		No_12_CircleOfStrings g = new No_12_CircleOfStrings(CHARS);

		for (int i = 0; i < n; i++) {
			String s = arr[i];
			g.addEdge(s.charAt(0) - 'a', s.charAt(s.length() - 1) - 'a');
		}

		return g.isEulerianCycle();
	}

	public static void main(String[] args) throws Exception {
		String[] arr1 = { "great", "skill", "trains", "lync" };
		int n1 = arr1.length;

		System.out.println((canBeChained(arr1, n1) ? "Can be chained " : "Can't be chained "));

		String[] arr2 = { "ab", "bc" ,"cd", "da"};
		int n2 = arr2.length;

		System.out.println((canBeChained(arr2, n2) ? "Can be chained " : "Can't be chained "));
	}
}
