import java.util.LinkedList;

/**
 * Clusters2DTest123  (tests Part 1, Part 2, and Part 3)
 * 
 * A simple test for clustering method, using points in two dimensional space as vertices
 * and Euclidean distance as the distance between vertices.
 * This is the example in the assignment handout.
 * 
 * @author Lucia Moura
 *
 */

public class Clusters2DTest123 {
	

	public static void main(String[] args) {
		// need to parse files here
		
		int [][] points = {{41,45},{39,44},{42, 43}, {44, 43}, {10, 42},{38, 42},
				{8, 41},{41, 41},{13, 40},{45, 40},{ 7, 39},{38, 39},{42, 39},{ 9, 38},
				{12, 38},{19, 38},{25, 38},{ 6, 37},{13, 35},{ 9, 34},{12, 34},{32, 27},
				{26, 25},{39, 24},{34, 23},{37, 23},{22, 22},{38, 21},{35, 20},{31, 18},
				{26, 16},{38, 13},{29, 11},{34, 11},{37, 10},{40,  9},{42,  9}};
		
		int N=points.length; // number of vertices that will be created
		String[] names=new String[N]; 
		int ne=N*(N-1)/2; // number of edges since this is a complete graph
		int [] v1 = new int[ne]; // stores pairs of vertices that will form edge v1[i],v2[i]
		int [] v2 = new int[ne];
		double [] dist= new double[ne];
		
		int M=0;
		for (int i=0; i<N;i++) { // for each point
			names[i]="("+points[i][0]+","+points[i][1]+")"; // name is in format (x,y)
			for (int j=i+1; j<N;j++) { // for each other point
				// add edge info connecting two points and calculate Euclidean distance
				v1[M]=i; 
				v2[M]=j;
				double x1=(double)points[i][0]; double y1=(double)points[i][1]; 
				double x2=(double)points[j][0]; double y2=(double)points[j][1];
				dist[M]=Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
				M++;
			}
		}
		
		System.out.println("** CLusters2DTest123: testing MyGraph, KruskalAlgorithms, Partition");
		System.out.println("** the graph is complete with vertices representing points in the first figure in handout.");
		System.out.println("** the 3 clusters (size 9,12,16) to be constructed must correspond to the clusters in the second figure in the handout.");
		System.out.println("\nCreating graph");
		
		MyGraph spG=new MyGraph(names, v1, v2, dist);
		
		System.out.println("Initializing Kruskal Algorithms");
		
		KruskalAlgorithms<Integer,Double> clusterAlg = new KruskalAlgorithms<Integer, Double>();
		
		System.out.println("Next it will group vertices in 3 clusters.");
		
		LinkedList<Edge<Double>> tree;
		Partition<Vertex<Integer>> clusters = new Partition<Vertex<Integer>>();
		System.out.println("before Kruskal Algorithm");
		tree=clusterAlg.kruskalClusters(spG, 3, clusters);
		System.out.println("after Kruskal Algorithm");
		System.out.println("\nClusters created by the algorithm:");
		System.out.println(clusters); // toString() is already implemented for class Partition.
	}

}
