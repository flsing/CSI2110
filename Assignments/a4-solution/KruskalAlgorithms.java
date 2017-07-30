import java.util.*;

/**
 * KruskalAlgorithms provides methods based on Kruskal's minimum spanning tree algorithm.
 * The algorithms operate on a graph that implements the interface Graph<V,E>
 * 
 * @author Lucia Moura
 *
 * @param <V> 
 * @param <E>
 */
public class KruskalAlgorithms<V,E extends Comparable<E>> {
	
	
	/**
	 * minimumSpaningTree uses the more general auxiliary method kruskalClusters
	 * this is already implemented, but its correctness relies on the correctness of kruskalClusters.
	 * @param g an undirected graph
	 * @return edges of a minimum spanning tree of g, if g is connected
	 * edges of a minimum spanning forest of g formed of trees of each connected component, if g is not connected.
	 * 
	 */
	public  LinkedList<Edge<E>> minimumSpanningTree(Graph<V,E> g) {  //no change to be done here
		return kruskalClusters(g,1, new Partition<Vertex<V>>());
	}
	
	// kruskalClusters has two inputs: a graph g and the desired number of clusters k
	// its outputs are Partition<Vertex<V>> clusters storing the k clusters
	// and a collection of edges that are part of the spanning forest used to create the clusters
	/**
	 * kruskalClusters runs steps of the Kruskal's algorithm until k clusters are found.
	 * It does not crash if the graph has more than k connected components; in this case
	 * it computes the connected components. 
	 * @param g is a graph where the edge compareTo is based on the distance/weight of the edge
	 * @param k is the number of desired clusters
	 * @param clusters is output that contains the partition storing the clusters
	 * @return the edges of minimum spanning trees of the clusters
	 */
	public LinkedList <Edge<E>>  kruskalClusters (Graph<V,E> g, int k, Partition<Vertex<V>> clusters) {
		
		// Initialization steps 
		
		PriorityQueue<Edge<E>> pq = new PriorityQueue<Edge<E>>(g.numEdges()); // priority queue
		HashMap<Vertex<V>,Partition<Vertex<V>>.Node> hash=new HashMap<Vertex<V>,Partition<Vertex<V>>.Node>(2*g.numVertices()); 
		// Hash Map to store the Node where each vertex is stored in the Partition
		LinkedList <Edge<E>> forest =new LinkedList <Edge<E>>(); // creates an empty list of edges
		
		// adding each edge to the priority queue
		for (Edge<E> e:g.edges()) {
			pq.add(e);
		}
		
		// adding each vertex to a cluster and saving the pair (vertex,Node) into the hash map
		for (Vertex<V> v: g.vertices()) {
			Partition<Vertex<V>>.Node node=clusters.makeCluster(v);
			hash.put(v,node);
		}
		
		// **** main kruskalKluster loop to be implemented by students ******
		while (clusters.numClusters() > k && !pq.isEmpty()) {
		    Edge<E> edge= pq.remove();
			Vertex<V>[] vertex=g.endVertices(edge);
			Partition<Vertex<V>>.Node n1=hash.get(vertex[0]);
			Partition<Vertex<V>>.Node n2=hash.get(vertex[1]);
			if (clusters.find(n1)!=clusters.find(n2)) {
				
				clusters.union(n1, n2);
				forest.add(edge);
			}
			
 		}
      
		return forest;
	}
	
}
