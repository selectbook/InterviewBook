package graph;

public class MtrixGraphTest {
	public static void main(String[] args) {
		int[] vertexes = { 0, 1, 2, 3 };
		// 初始化图
		MatrixGraph graph = new MatrixGraph(vertexes);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(1, 2);
		graph.addEdge(3, 2);
		graph.printMatrix();
		graph.depthFirstTravel();
	}
}
