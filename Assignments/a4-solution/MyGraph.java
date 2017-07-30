import java.util.*;

/**
 * 
 * Class MyGraph implements a graph using an (extended) adjacency matrix data structure
 * It implements the interface Graph<Integer,Double>: an Integer value is stored at each vertex and
 * corresponds to its index in the adjacency matrix; a Double value is stored at each edge and
 * corresponds to edge weight/distance.
 * 
 * For a description of the desired behavior of these methods consult the Graph interface.
 * 
 * @author Lucia Moura
 *
 */

public class MyGraph implements Graph<Integer,Double>{
	
	private int numVertices, numEdges; // number of edges and number of edges
	private ArrayList<MyVertex> vertices; // list of vertices idexed by the vertex index
	private LinkedList<MyEdge> edges; // list of edges
    private MyEdge [][] adjacencyMatrix; // This will be an numVertices by numVertices adjacency matrix. 
    									 // if vertex index i and index j are connected by edge e
    									 // then adjacencyMatrix[i,j]=e
	
    /**
     *  MyVertex: nested class implementing the Vertex interface 
     *  
     */
	public class MyVertex implements Vertex<Integer>{
		private int index;   // index of vertex in adjacency matrix valie in (0..numVertices-1)
		private String name; // label/name of vertex
		private int degree; // degree of vertex
		
		public MyVertex(int index, String name) {
			this.index=index; 
			this.name=name;
			this.degree=0;
		}

		public String getName() {
			return name;
		}
		@Override
		public Integer getElement() {
			return index;
		}
		@Override
		public String toString() {
			return "v"+index+":"+name;
		}
		
	}
	
	 /**
     *  MyEdge: nested class implementing the Edge interface 
     *  
     */
	public class MyEdge implements Comparable<MyEdge>, Edge<Double>  {
        private Double dist;
        private MyVertex v1, v2; 
        public MyEdge(double dist, MyVertex v1, MyVertex v2) {
        	this.dist=dist;
        	this.v1=v1;
        	this.v2=v2;
        }
		@Override
		public Double getElement() {
			return dist;
		}
		
		@Override
		public String toString() {
			return "e={"+v1+","+v2+"}"+" dist="+dist;
		}
		
		@Override
		public int compareTo(MyEdge o) {
			return (this.dist).compareTo(o.dist);
		}
		
	}
	
	/** 
	 * MyGraph() the constructor for the class
	 * the array names has length equals to the number n of vertices and specify the labels for vertices 0..n-1
	 * the arrays end1, end2, dist have length equals to the number m of edges
	 * Values end1[i] and end2[i] represent the indices (between 0..n-1) of the vertices that are endpoints of edge i
	 * dist[i] is the distance/weight of edge i
	*/
	
	public MyGraph(String [] names, int [] end1, int[] end2, double [] dist) {
		// part 1 create vertices 
		numVertices=names.length; // sets number of vertices which is the length of array names
		
		// *** start student to-do 1
		// part to be completed below: create numVertices vertices with names above and indices 0..numVertices
		// and store in the ArrayList vertices
		vertices=new ArrayList<MyVertex>(numVertices);

		for (int i=0; i< numVertices; i++) {
			vertices.add(i, new MyVertex(i,names[i]));
		}
		// *** end student to-do 1
		
		// part 2: create edges
		numEdges=end1.length; // sets the number of edges which is the length of arrays end1,end2,dist
		if ((end2.length!=numEdges) || (dist.length!=numEdges)) {
			throw new IllegalArgumentException("Uneven array sizes for 2nd 3rd 4th arguments.");
		
		}
		// initialize adjacency matrix with null
		adjacencyMatrix=new MyEdge[numVertices][numVertices];
		edges=new LinkedList<MyEdge>();
		for (int i= 0; i< numVertices; i++)
			for (int j=0; j< numVertices; j++) {
				adjacencyMatrix[i][j]=null;
			}
		// *** start student to-do 2
		// part to be completed below: create edges placing in LinkedList edges as well as
		// adding the edge reference to the correct position in adjacency matrix
		for (int i=0; i< numEdges; i++) {
			int v1=end1[i]; int v2=end2[i];
			if ((v1<0)||(v1>=numVertices)||(v2<0)||(v2>=numVertices)) {
				System.out.println("Incorrect vertex labels");
				throw new IllegalArgumentException("Vertex index at position "+i+" has values out of range [0.."+(numVertices-1)+"].");
			}	
			MyEdge newEdge=new MyEdge(dist[i],vertices.get(v1),vertices.get(v2));
			edges.add(newEdge);
			newEdge.v1.degree++;
			newEdge.v2.degree++;
			adjacencyMatrix[v1][v2]=adjacencyMatrix[v2][v1]=newEdge;
		}
		// *** end student to-do 2
		
	}

	@Override
	public int numVertices() { // to be implemented by student
		return numVertices;
	}

	@Override
	public int numEdges() { // to be implemented by student
		return numEdges;
	}

	@Override
	public Iterable<Vertex<Integer>> vertices() { // to be implemented by student
		return (Iterable<Vertex<Integer>>) vertices.clone();
	}

	@Override
	public Iterable<Edge<Double>> edges() { // to be implemented by student
		return (Iterable<Edge<Double>>) edges.clone();
	}

	@Override
	public int degree(Vertex<Integer> v) throws IllegalArgumentException { // to be implemented by student
		int count=0;
		if (!(v instanceof MyVertex))
		   throw new IllegalArgumentException("Argument should be instance of MyVertex.");
		MyVertex mv=(MyVertex) v;
		return mv.degree;
	}

	@Override
	public Iterable<Edge<Double>> incidentEdges(Vertex<Integer> v)
			throws IllegalArgumentException {  // to be implemented by student
		if (!(v instanceof MyVertex))
			   throw new IllegalArgumentException("Argument should be instance of MyVertex.");
		MyVertex mv=(MyVertex) v;
		LinkedList<Edge<Double>> adjEdges=new LinkedList<Edge<Double>>();
		for (int i=0; i< numVertices; i++) 
			if (adjacencyMatrix[mv.index][i]!=null) adjEdges.add(adjacencyMatrix[mv.index][i]);
		return adjEdges;
	}

	@Override
	public Edge<Double> getEdge(Vertex<Integer> u, Vertex<Integer> v)
			throws IllegalArgumentException { // to be implemented by student
		if (!((u instanceof MyVertex) && (v instanceof MyVertex)))
			   throw new IllegalArgumentException("Argument should be instance of MyVertex.");
		MyVertex mu=(MyVertex) u;
		MyVertex mv=(MyVertex) v;
		Edge<Double> edge=adjacencyMatrix[mu.index][mv.index];
		return edge;
	}

	@Override
	public Vertex<Integer>[] endVertices(Edge<Double> e)
			throws IllegalArgumentException { // to be implemented by student
		if (!(e instanceof MyEdge))
			   throw new IllegalArgumentException("Argument should be instance of MyEdge.");
		MyEdge edge=(MyEdge) e;
		Vertex<Integer>[] v=new MyVertex[2];
		v[0]=edge.v1; v[1]=edge.v2;
		return v;
	}

	@Override
	public Vertex<Integer> opposite(Vertex<Integer> v, Edge<Double> e)
			throws IllegalArgumentException { // to be implemented by student
		if (!(v instanceof MyVertex))
			   throw new IllegalArgumentException("Argument should be instance of MyVertex.");
		if (!(e instanceof MyEdge))
			   throw new IllegalArgumentException("Argument should be instance of MyEdge.");
		MyEdge edge=(MyEdge) e;
		MyVertex vertex=(MyVertex) v;
		if (vertex==edge.v1) return edge.v2;
		else 
		if (vertex==edge.v2) return edge.v1;
		else  throw new IllegalArgumentException("The given vertex is not an endpoint of the given edge.");
	}
	
	

}
