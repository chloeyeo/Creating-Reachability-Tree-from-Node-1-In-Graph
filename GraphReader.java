package graphs;

import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class GraphReader {
	public static Node[] readGraph(Path path) throws IOException {
		
		List<String> lines = Files.readAllLines(path); // if error in accessing path, throw IOException.
		
		int numOfNodes = Integer.parseInt(lines.get(0)); // No. of nodes in graph in first line of file.
		
		Node[] nodes = new Node[numOfNodes]; // nodes is an array of nodes which has fixed size.
		
		
		int numOfEdges = Integer.parseInt(lines.get(1)); // No. of edges in graph in 2nd line of file.
		
		int count = 0;
		
		for (int j = 0; j < numOfEdges; j++) {
			List<Node> listOfNodes = Arrays.asList(nodes);
			String edge = lines.get(2 + j);
			String[] edge_array = edge.split(" ");
			Node node1 = new Node(Integer.parseInt(edge_array[0]));
			Node node2 = new Node(Integer.parseInt(edge_array[1]));
		    if ((listOfNodes.contains(node1))==false) {
		    	node1.addNeighbour(node2);
		    	nodes[count] = node1;
		    	count += 1;
			} else if (listOfNodes.contains(node1)) {
				int index = listOfNodes.indexOf(node1);
				nodes[index].addNeighbour(node2);
			}
		    if ((listOfNodes.contains(node2))==false) {
		    	nodes[count] = node2;
		    	count += 1;
		    }
		}
		Arrays.sort(nodes);
		return nodes;
	}
}
