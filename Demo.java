package dic;

public class Demo {

	public static void main(String[] args) {

		Graph graph = new Graph(8);

		graph.insertEdge(0, 1, 2);
		graph.insertEdge(0, 2, 4);
		graph.insertEdge(1, 2, 1);
		graph.insertEdge(1, 3, 7);
		graph.insertEdge(2, 4, 3);
		graph.insertEdge(3, 5, 1);
		graph.insertEdge(4, 3, 2);
		graph.insertEdge(4, 5, 5);
		graph.insertEdge(5, 6, 3);
		graph.insertEdge(5, 7, 6);
		graph.insertEdge(6, 7, 2);
		graph.insertEdge(1, 4, 6);
		graph.insertEdge(2, 5, 4);
		graph.insertEdge(3, 6, 3);
		graph.insertEdge(4, 7, 7);
		graph.insertEdge(6, 3, 2);

		System.out.println("Dijkstra's Algorithm:");
		graph.findShortestPathDijkstra(0, 7);

		System.out.println("BellmanFord Algorithm:");
		graph.findShortestPathBellmanFord(0, 7);
	}

}
