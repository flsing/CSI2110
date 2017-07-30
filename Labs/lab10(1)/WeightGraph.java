// $Id: WeightGraph.java,v 1.1 2006/11/18 01:20:12 jlang Exp $
// CSI2110 Fall 2006 Laboratory 9: Adjacency List and DFS
// ==========================================================================
// (C)opyright:
//
//   Jochen Lang
//   SITE, University of Ottawa
//   800 King Edward Ave.
//   Ottawa, On., K1N 6N5
//   Canada. 
//   http://www.site.uottawa.ca
// 
// Creator: jlang (Jochen Lang)
// Email:   jlang@site.uottawa.ca
// ==========================================================================
// $Log: WeightGraph.java,v $
// Revision 1.1  2006/11/18 01:20:12  jlang
// Added lab10
//
// Revision 1.1  2006/11/11 03:15:52  jlang
// Added Lab9
//
//
// ==========================================================================
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Iterator;


import net.datastructures.Graph;
import net.datastructures.Vertex;
import net.datastructures.Edge;
import net.datastructures.AdjacencyListGraph;
import net.datastructures.Map;
import net.datastructures.HashTableMap;
import net.datastructures.InvalidPositionException;
import net.datastructures.InvalidEntryException;
import net.datastructures.Dijkstra;


public class WeightGraph {
  Graph<String,String> sGraph;  

  Object WEIGHT = new Object();
  

  /** 
   * Create a WeightGraph from file
   */
  public WeightGraph( String fileName ) 
    throws InvalidPositionException, IOException {
    sGraph = new AdjacencyListGraph<String,String>();
    read( fileName );
  }


  /**
   * Read a list of edges from file
   */
  protected void read( String fileName ) 
    throws InvalidPositionException, IOException {
    BufferedReader graphFile = 
      new BufferedReader( new FileReader(fileName));
    
    // Create a hash map to store all the vertices read
    Map<String, Vertex> vertices = new HashTableMap<String, Vertex>();
    
    // Read the edges and insert
    String line;
    while( ( line = graphFile.readLine( ) ) != null ) {
      StringTokenizer st = new StringTokenizer( line );
      if( st.countTokens() != 3 ) 
	throw new IOException("Incorrect input file at line " 
				    + line );
      String source = st.nextToken( );
      Integer weight = new Integer(st.nextToken( ));
      String dest = st.nextToken( );
      Vertex<String> sv = vertices.get( source );
      if ( sv == null ) {
	// Source vertex not in graph -- insert
	sv = sGraph.insertVertex(source); 
	vertices.put( source, sv );
      } 
      Vertex<String> dv = vertices.get( dest );
      if ( dv == null ) {
	// Destination vertex not in graph -- insert
	dv = sGraph.insertVertex(dest); 
	vertices.put( dest, dv );
      }
      // check if edge is already in graph
      if ( !sGraph.areAdjacent( sv, dv )) {
	// edge not in graph -- add 
	Edge<String> e = sGraph.insertEdge(sv, dv, source + " to " + dest ); 
	// decorate with its weight

	// Your code here!

      }
    }
  }

  /**
   * Helper routine to get a Vertex (Position) from a string naming
   * the vertex
   */
  protected Vertex<String> getVertex( String vert )
    throws InvalidEntryException {
    // Go through vertex list to find vertex -- why is this not a map
    for( Vertex<String> vs : sGraph.vertices() ) {
      if ( vs.element().equals( vert )) {
	return vs;
      }
    }
    throw new InvalidEntryException( "Vertex not in graph: " + vert );
  }

  /**
   * Printing all the vertices in the list, followed by printing all
   * the edges
   */
  void print() {
    System.out.println( "Vertices: " + sGraph.numVertices() + 
			" Edges: " + sGraph.numEdges()); 
    
    for( Vertex<String> vs : sGraph.vertices() ) {
      System.out.println( vs.element() );
    }
    for( Edge<String> es : sGraph.edges() ) {
      System.out.println( es.element() );
    }
    return;
  }

  /**
   * Print the shortest distances
   */
  void printAllShortestDistances( String vert  ) {
    Vertex<String> vSource = getVertex( vert );

    // Your code here!

    // Find shortest path

    // Print shortest path to named cities

    return;
  }




  /** Helper method:
   * Read a String representing a vertex from the console
   */
  public static String readVertex() throws IOException {
    System.out.print( "[Input] Vertex: " );
    BufferedReader reader = 
      new BufferedReader(new InputStreamReader ( System.in ));
    return reader.readLine();
  }

  /**
   * Generate a Graph from File and prints the vertices visited
   * by a DepthFirstSearch
   */
  public static void main( String[] argv ) {
    if ( argv.length < 1 ) {
      System.err.println( "Usage: java WeightGraph fileName" );
      System.exit(-1);
    }
    try {
      WeightGraph sGraph = new WeightGraph( argv[0] );
      sGraph.print();
      // Ask for vertex to start
      System.out.println( "Source Vertex for Shortest Path:");
      sGraph.printAllShortestDistances(readVertex());
    }catch ( Exception except ) {
      System.err.println(except);
      except.printStackTrace();
    }
  }
}
