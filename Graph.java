package dic;

import java.util.ArrayList;
import java.util.List;

public class Graph {
	private int[][] arr;
	private int size;

	Graph(int s) {
		size = s;
		arr = new int[size][size];
	}

	public void insertEdge(int s, int d, int w) {
		arr[s][d] = w;
	}

	private boolean isAllVisited(boolean[] v) {
		for (boolean visited : v) {
			if (!visited) {
				return false;
			}
		}
		return true;
	}

	private int findNextMin(boolean[] v, int[] d) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < d.length; i++) {
			if (!v[i] && d[i] < min) {
				min = d[i];
				index = i;
			}
		}
		return index;
	}

	public void findShortestPathDijkstra(int source, int destination) {
		int[] dist = new int[size];
		int[] prevVert = new int[size];
		boolean[] visited = new boolean[size];

		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE; // infinity
		} // Set all distances to infinity
		for (int i = 0; i < prevVert.length; i++) {
			prevVert[i] = -1;
		} // Set all previous vertices to -1

		dist[source] = 0; // Distance from source to itself is 0

		while (!visited[destination]) { // Continue until destination is visited
			int vertex = findNextMin(visited, dist); // Find the next unvisited vertex with minimum distance
			if (vertex == -1) {
				break; // No more reachable vertices
			}
			visited[vertex] = true; // Mark current vertex as visited

			// Update distances of neighbors
			for (int i = 0; i < size; i++) {
				if (arr[vertex][i] != 0 && !visited[i]) {
					int newDist = dist[vertex] + arr[vertex][i];
					if (newDist < dist[i]) {
						dist[i] = newDist;
						prevVert[i] = vertex;
					}
				}
			}
		}

		// Print the shortest path from source to destination
		printSolution(dist, prevVert, source, destination);
	}

	public void findShortestPathBellmanFord(int source, int destination) {
		int[] dist = new int[size];
		int[] prevVert = new int[size];

		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE; // infinity
		} // Set all distances to infinity
		for (int i = 0; i < prevVert.length; i++) {
			prevVert[i] = -1;
		} // Set all previous vertices to -1
		dist[source] = 0; // Distance from source to itself is 0

		for (int i = 1; i < size; i++) { // Relax edges repeatedly
			for (int u = 0; u < size; u++) {
				for (int v = 0; v < size; v++) {
					if (arr[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + arr[u][v] < dist[v]) {
						dist[v] = dist[u] + arr[u][v];
						prevVert[v] = u;
					}
				}
			}
		}

		// Check for negative-weight cycles
		for (int u = 0; u < size; u++) {
			for (int v = 0; v < size; v++) {
				if (arr[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + arr[u][v] < dist[v]) {
					System.out.println("Graph contains a negative weight cycle");
					return;
				}
			}
		}

		// Print the shortest path from source to destination
		printSolution(dist, prevVert, source, destination);
	}

	private void printSolution(int[] dist, int[] prevVert, int source, int destination) {
		System.out.println("Shortest path from " + source + " to " + destination + ":");
		if (dist[destination] != Integer.MAX_VALUE) {
			System.out.println("Distance: " + dist[destination]);
			System.out.print("Path: ");
			printPath(destination, prevVert);
		} else {
			System.out.println("Destination is unreachable.");
		}
	}

	private void printPath(int currentVertex, int[] prevVert) {
		List<Integer> path = new ArrayList<>();
		for (int at = currentVertex; at != -1; at = prevVert[at]) {
			path.add(0, at);
		}
		for (int vertex : path) {
			System.out.print(vertex + " ");
		}
		System.out.println();
	}
}
