package com.DSA.Project2;

import java.io.*;
import java.util.*;

public class No_11_Minimum_Cost_Path {
// Below arrays detail all four possible movements from a cell (left, top, right, bottom)
	static int[] row = { -1, 0, 1, 0 };
	static int[] col = { 0, 1, 0, -1 };

	static class Node {
		int x;
		int y;
		int distance;

		Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}

// Custom comparator for inserting cells into Priority Queue
	static class distanceComparator implements Comparator {
		public int compare(Node a, Node b) {
			if (a.distance < b.distance) {
				return -1;
			} else if (a.distance > b.distance) {
				return 1;
			} else {
				return 0;
			}
		}

		@Override
		public int compare(Object o1, Object o2) {
			// TODO Auto-generated method stub
			return 0;
		}

	}

// Utility method to check whether current cell isValid or not
	static boolean isValid(int i, int j, int M, int N) {
		return (i >= 0 && i < M && j >= 0 && j < N);
	}

// Method to return shortest path from top-corner to bottom-corner in 2D grid
	static int shortestPath(int[][] grid, int M, int N) {
		int[][] dist = new int[M][N];

		// Initializing distance array by INT_MAX
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}

		// Initialized source distance as initial grid position value
		dist[0][0] = grid[0][0];

		PriorityQueue pq = new PriorityQueue(M * N, new distanceComparator());

		// Insert source cell to priority queue
		pq.add(new Node(0, 0, dist[0][0]));
		while (!pq.isEmpty()) {

			Node curr = (Node) pq.poll();
			for (int i = 0; i < 4; i++) {

				int R = curr.x + row[i];
				int C = curr.y + col[i];

				if (isValid(R, C, M, N)) {

					if (dist[R][C] > dist[curr.x][curr.y] + grid[R][C]) {

						// If Node is already been reached once, remove it from priority queue
						if (dist[R][C] != Integer.MAX_VALUE) {
							Node adj = new Node(R, C, dist[R][C]);
							pq.remove(adj);
						}

						// Insert cell with updated distance
						dist[R][C] = dist[curr.x][curr.y] + grid[R][C];

						pq.add(new Node(R, C, dist[R][C]));
					}
				}
			}
		}
		return dist[M - 1][N - 1];
	}

	public static void main(String[] args) throws IOException {
		int[][] grid = { { 31, 100, 65, 12, 18 }, { 10, 13, 47, 157, 6 }, { 100, 113, 174, 11, 33 },
				{ 88, 124, 41, 20, 140 }, { 99, 32, 111, 41, 20 } };

		System.out.println(shortestPath(grid, 5, 5));

		int[][] grid2 = { { 42, 93 }, { 7, 14 } };

		System.out.println(shortestPath(grid2, 2, 2));
	}
}