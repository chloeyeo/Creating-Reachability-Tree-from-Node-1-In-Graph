package graphExploration;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;

import graphs.Node;

public class GraphExplorer {
	public static void writeTree(Node[] nodes, Path path) throws IOException {
		Queue<Node> queueOfNodes = new LinkedList<>(); // Queue of nodes Q=(n) initialised.
		queueOfNodes.add(nodes[0]);
		Set<Node> setOfNodes = new HashSet<>(); // set of nodes S={n} initialised.
		setOfNodes.add(nodes[0]);
		List<List<String>> listOfEdges = new ArrayList<>(); // list of edges E=() initialised.

		Files.createFile(path);
		PrintWriter pw = new PrintWriter(Files.newBufferedWriter(path));
		pw.println("Reachability Tree from Node 1:");

		/*
		 * ! means != true or == false.// ! means != true or == false. also when I put
		 * queueOfNodes != null as a while loop header it did not work because even if
		 * queueOfNodes is empty, it won't be equal to null because null means there is
		 * no queueOfNodes at all, whereas we do have an 'empty' queueOfNodes, so we
		 * have to check if queueOFNodes.isEmpty() == false
		 * so before the while loop was looping forever because the queueOfNodes was never 'null'
		 * i.e. never not existing, so it was removing element, firstNode, forever
		 * which was why it showed element does not exist error because after all the elements
		 * in queueOfNodes was removed, there was no element left in queueOfNodes to remove.
		 */
		while (queueOfNodes.isEmpty() == false) {
			Node firstNode = queueOfNodes.remove();
			List<Node> adjacency_list = firstNode.getNeighbours();
			for (Node node : adjacency_list) {
				if ((setOfNodes.contains(node)) == false) {
					List<String> edges = new ArrayList<>();
					edges.add(firstNode.toString());
					edges.add(node.toString());
					listOfEdges.add(edges);
					setOfNodes.add(node);
					queueOfNodes.add(node);
				}
			}
		}
		for (List<String> edge : listOfEdges) {
			pw.println(edge.get(0) + " " + edge.get(1));
		}
		pw.close();
	}
}
