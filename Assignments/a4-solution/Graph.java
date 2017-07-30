
/**
 * An interface for an undirected graph structure. 
 * We simplified the textbook's interface, so that it does not contain update methods
 * 
 * DO NOT CHANGE THIS INTERFACE!
 * 
 * @author Lucia Moura
 *
 */

public interface Graph<V,E> {

  /** Returns the number of vertices of the graph */
  int numVertices();

  /** Returns the number of edges of the graph */
  int numEdges();

  /** Returns the vertices of the graph as an iterable collection */
  Iterable<Vertex<V>> vertices();

  /** Returns the edges of the graph as an iterable collection */
  Iterable<Edge<E>> edges();

  /**
   * Returns the number of edges incident to vertex v.
   * @throws IllegalArgumentException if v is not a valid vertex
   */
  int degree(Vertex<V> v) throws IllegalArgumentException;

  /**
   * Returns an iterable collection of edges that are incident to v.
   * @throws IllegalArgumentException if v is not a valid vertex
   */
  Iterable<Edge<E>> incidentEdges(Vertex<V> v) throws IllegalArgumentException;

  /** Returns the edge from u to v, or null if they are not adjacent. */
  Edge<E> getEdge(Vertex<V> u, Vertex<V> v) throws IllegalArgumentException;

  /**
   * Returns the vertices of edge e as an array of length two.
   * The order of vertices is arbitrary.
   */
  Vertex<V>[] endVertices(Edge<E> e) throws IllegalArgumentException;

  /** Returns the vertex that is opposite vertex v on edge e. */
  Vertex<V> opposite(Vertex<V> v, Edge<E> e) throws IllegalArgumentException;

}
