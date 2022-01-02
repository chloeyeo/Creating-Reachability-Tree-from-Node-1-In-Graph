# Creating-Reachability-Tree-from-Node-1-In-Graph

[Aims and objectives]

• Reading and writing files using java.nio
• Using classes from the Collections API
• Dealing with classes in multiple packages
• Overriding toString(), equals(), and hashCode()

[Graphs]

This project relies on the mathematical concept of graphs.
In graph theory, a graph is a collection of nodes and edges.
The nodes can be thought of as objects, and every edge connects exactly two nodes.
If there is an edge between two nodes, they can be thought of as related – for example,
graphs are used to represent concepts such as transit connections or social media friendships.

![image](https://user-images.githubusercontent.com/73764849/147889777-ecb7d521-5f8c-4cec-8eb7-cbb53bdc57c1.png)

For this project, we will consider directed graphs, which are a specific
type of graphs where each edge has a direction. That is, for every
edge in a directed graph, one of the nodes is the starting point,
and the other is the end point. For example, the image above
represents a directed graph consisting of three nodes (labelled 1,
2, and 3) and four edges: (1,2), (2,3), (3,2), and (3,1) (the doubleheaded arrow represents an edge in both directions between
nodes 2 and 3).

A directed graph can be represented as an adjacency list: this representation stores, for each node,
the list of nodes that it is connected to. For example, the above directed graph can be represented
by the following adjacency list:
- 1 -> (2)
- 2 -> (3)
- 3 -> (1, 2)

[Reachability]

On a directed graph, reachability refers to the ability to get from one node to another by following
edges. In the example graph above, all pairs of nodes are reachable from each other; however, if the
edge between 3 and 1 is removed, then node 1 would no longer be reachable from either node 3 or
node 2.

A reachability tree is a subgraph of a directed graph that includes all nodes that are reachable from
a given node n, along with the edges needed to reach those nodes. In the above graph, for example,
the reachability tree for node 1 would consist of the edges (1,2) and (2,3) only.

The following algorithm can be used to compute the reachability tree from a given node n:

- Initialise a queue of nodes Q = (n)
- Initialise a set of nodes S = {n}
- Initialise a list of edges E = ()

- While Q is not empty:
    o Remove the first node m from Q
    
    o For every node v in the adjacency list of m:
        - If v is not in S:
            • Add (m, v) to E
            • Add v to S
            • Add v to Q
    
At the end of this process, the list E will contain the full list of edges representing the reachability
tree from the initial node n.

[GraphExplorer class]

This class provides a single static method, with the following signature:
- public static void writeTree (Node[] nodes, Path path) throws IOException

This method computes the reachability tree from node 1 (i.e., the node at nodes[0]) and write
it to a file at the indicated location. You can assume that the nodes array has at least one node in it.
The file format should be as follows (this is the output for the sample graph):

Reachability Tree from Node 1:
1 2
2 3

