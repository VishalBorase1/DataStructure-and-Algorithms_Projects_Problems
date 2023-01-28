package com.DSA.Project2;

import java.util.ArrayDeque;
import java.util.Queue;

class Node {
	// (x, y) represents matrix cell coordinates, and dist represents their minimum
	// distance from the source
	int x, y, dist;

	Node(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}

public class No_10_Sortest_Source_to_DestinationPath {
	// M × N matrix
	private static final int M = 3;
	private static final int N = 4;

	// Below arrays detail all four possible movements from a cell(left, up, right,
	// down)
	private static final int[] row = { -1, 0, 0, 1 };
	private static final int[] col = { 0, -1, 1, 0 };

	
	private static boolean isValid(int mat[][], boolean visited[][], int row, int col) {
		return (row >= 0) && (row < M) && (col >= 0) && (col < N) && mat[row][col] == 1 && !visited[row][col];
	}

	// Find the shortest possible route in a matrix mat from source cell (i, j) to
	// destination cell (x, y)
	private static void BFS(int mat[][], int i, int j, int x, int y) {
		// construct a matrix to keep track of visited cells
		boolean[][] visited = new boolean[M][N];

		// create an empty queue
		Queue<Object> q = new ArrayDeque<>();

		// mark the source cell as visited and enqueue the source node
		visited[i][j] = true;
		q.add(new Node(i, j, 0));

		// stores length of the longest path from source to destination
		int min_dist = Integer.MAX_VALUE;

		// loop till queue is empty
		while (!q.isEmpty()) {
			// dequeue front node and process it
			Node node = (Node) q.poll();

			// (i, j) represents a current cell, and dist stores its minimum distance from
			// the source
			i = node.x;
			j = node.y;
			int dist = node.dist;

			// if the destination is found, update min_dist and stop
			if (i == x && j == y) {
				min_dist = dist;
				break;
			}

			// check for all four possible movements from the current cell and enqueue each
			// valid movement
			for (int k = 0; k < 4; k++) {
				// check if it is possible to go to position (i + row[k], j + col[k]) from
				// current position
				if (isValid(mat, visited, i + row[k], j + col[k])) {
					// mark next cell as visited and enqueue it
					visited[i + row[k]][j + col[k]] = true;
					q.add(new Node(i + row[k], j + col[k], dist + 1));
				}
			}
		}

		if (min_dist != Integer.MAX_VALUE) {
			System.out.println(min_dist);
		} else {
			System.out.print(-1);
		}
	}

	public static void main(String[] args) {
		// input maze
		int[][] mat = { { 1, 1, 1, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 } };

		// Find the shortest path from source (0, 0) to destination (7, 5)
		BFS(mat, 0, 0, 0, 3);
	}
}