package graph;

public class ListGraphTest {
	public static void main(String[] args) {
		int[] vertexes = { 0, 1, 2, 3 };
		ListGraph graph = new ListGraph(vertexes);

		graph.printListGraph();
	}
}
