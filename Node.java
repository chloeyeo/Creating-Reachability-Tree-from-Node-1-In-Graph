package graphs;

import java.util.List;
import java.io.IOException;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Objects;
import graphExploration.GraphExplorer;

//import java.nio.file.Path;

//Paths.get("C:\\Users\\yeoch\\eclipse-workspace-lab6\\lab6\\src\\graphs\\GraphReader.java");

public class Node implements Comparable<Node> {
	/*
	 * This class can be used to store a node in a directed graph represented as an
	 * adjacency list. A node should have an ID(an integer), as well as a list of
	 * its neighbours. (ArrayList class implements the Comparable interface, so we
	 * can use sort method to sort a collection of ArrayList objects.)
	 */
	private int id;
	private Map<Integer, List<Node>> currentNode = new HashMap<>();
	private List<Node> adjacency_list = new ArrayList<>();

	public Node(int id) {
		this.id = id;
		currentNode.put(this.id, adjacency_list);
	}
	
	public int compareTo(Node otherNode) {
		return this.id - otherNode.id;
	}
	
	public static void main(String[] args) { // the main method.
		try {
			Path my_path = Paths.get("C:\\java\\graph2.txt");
			Node[] nodes = GraphReader.readGraph(my_path);
			GraphExplorer.writeTree(nodes, Paths.get("C:\\java\\out2.txt"));
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public void addNeighbour(Node node) {
		/* Adds the given node to this node's adjacency list. */
		adjacency_list.add(node);
		currentNode.put(this.id, adjacency_list);
	}

	public List<Node> getNeighbours() {
		return adjacency_list;
	}

	public int getID() {
		return this.id;
	}
	public String toString() {
		return "" + this.id;
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj instanceof Node) {
			Node node = (Node) obj;
			return Objects.equals(node.id, this.id);
		}
		return false;
	}

	public int hashCode() {
		return Objects.hash(this.id);
	}
}
