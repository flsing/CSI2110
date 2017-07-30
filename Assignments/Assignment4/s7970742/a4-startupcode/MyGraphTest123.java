import java.util.LinkedList;

/**
 * MyGraphTest123: testing classes MyGraph, Partition and KruskalAlgorithms.
 * 
 * This is a toy test case for a preliminary test of Part 1, Part 2 and Part 3.
 * The same graph as MyGraphTest123 is tested, and a minimum spanning tree is found.
 * 
 * @author Lucia Moura
 *
 */

public class MyGraphTest123 {
	
	public static void testGraph() {
		String[] v = {"zero","one","two","three"};
		int [] v1= {0,0,0,2,1};
		int [] v2= {1,2,3,3,3};
		double [] dist={1,2,3,4,5};
		
		System.out.println("** MyGraphTest1: testing class MyGraph only.");
		System.out.println("** VertexNames={zero,one,two,three} for Vertices {0,1,2,3}");
		System.out.println("** EdgeSet={ {0,1},{0,2}, {0,3}, {2,3}, {1,3} } with weights 1,2,3,4,5");
		System.out.println("\nNow testing each method:\n");
		
		System.out.println("Testing Constructor...");
		MyGraph g=new MyGraph(v,v1,v2,dist);
		System.out.println("Completed Constructor.\n");
	    
		System.out.println("numVertices()="+g.numVertices());
		System.out.println("numEdges()="+g.numEdges());
		System.out.print("vertices() and show indices:");
		for (Vertex<Integer> vert: g.vertices()) {
			System.out.print(vert.getElement()+",");
		}
		System.out.print("\nedges() and show weights:");
		for (Edge<Double> edge: g.edges()) {
			System.out.print(edge.getElement()+",");
		}
		System.out.println("\n");
	
		for (Vertex<Integer> vert: g.vertices()) {
			System.out.println("degree of vertex "+vert.getElement()+" ="+ g.degree(vert));
			System.out.print("incidentEdges("+vert.getElement()+"):  ");
			for (Edge<Double> edges: g.incidentEdges(vert))
				System.out.print(edges+"; ");
			System.out.println();
		}

		System.out.println("\nTesting getEdge(v,w) for each pair of vertices (v,w) and showing distances:");
		for (Vertex<Integer> vert1: g.vertices()) {
			for (Vertex<Integer> vert2: g.vertices()) {
				Edge<Double> edge=g.getEdge(vert1, vert2);
				if (edge!=null) {
				 System.out.print("dist("+vert1.getElement()+","+vert2.getElement()+")="+ edge.getElement()+ "; ");
				} 
			}
			System.out.println();
		}

		System.out.println("\nTesting: endVertices, opposite");
		for (Edge<Double> edge: g.edges()) {
			System.out.print(edge+": ends are "+g.endVertices(edge)[0].getElement()+ 
					"," + g.endVertices(edge)[1].getElement());
			System.out.print(" ,opposite of "+g.endVertices(edge)[0].getElement()+
					" is "+g.opposite(g.endVertices(edge)[0], edge).getElement());
			System.out.println(", opposite of "+g.endVertices(edge)[1].getElement()+
					" is "+g.opposite(g.endVertices(edge)[1], edge).getElement());
		}
		
		System.out.println("\n** Starting testing KruskalAlgorithms\n");
		System.out.println("Testing constructor KruskalAlgorithms()");
		KruskalAlgorithms algs = new KruskalAlgorithms();
		System.out.println("Testing minimumSpanningTree(g)");
		LinkedList<MyGraph.MyEdge> trees=algs.minimumSpanningTree(g);
		System.out.println("MST:");
		for (MyGraph.MyEdge edge: trees) {
			System.out.print(edge+",");
		}
		
		
		
		System.out.println("\n\n**End Test !!!");
	    
	}

	public static void main(String[] args) {
	   testGraph();

	}

}
