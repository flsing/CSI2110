/**
 * 
 * Disjoint Partition of a set providing an union-find data structure
 * where clusters are implemented as linked lists of elements of type T 
 * Each cluster is represented by a Dnode of a doubly linked list of clusters
 * Each cluster/Dnode, points to a singly linked list of Node each containing an element in the cluster.
 * For efficient implementation of method find, each Node points to the Dnode of the cluster it belongs to.
 * 
 * @author Lucia Moura
 *
 * @param <T>
 */
public class Partition <T> {
	
	// inner class specifying a node in the singly linked lists
	public class Node {
		private Node next;
		private T element;
		private Dnode cluster=null;
		public Node (T element, Node next, Dnode cluster) {
			this.element=element;
			this.next=next;
			this.cluster=cluster;
		}
	}
	
	// inner class specifying a node in the doubly linked list of clusters
	public class Dnode {
		private Node first;
		private Dnode next, prev;
		private int size;
		
		Dnode(Node first, Dnode prev, Dnode next) {
			this.first=first;
			this.prev=prev;
			this.next=next;
			this.size=0;
		}
		
	}
		
	private Dnode headCluster, tailCluster; // references to the dummy head and tail of the doubly linked list
	private int countClusters; // size of doubly linked list (not counting the dummies)
	
	public Partition() {	
		// creates an empty doubly linked list of clusters with dummy head and tail
		headCluster=new Dnode(null,null,null);
		tailCluster=new Dnode(null,headCluster,null);
		headCluster.next=tailCluster;
		countClusters=0;
	}
	
	public int numClusters() {
		return countClusters;
	}
	/**
	 * makeCluster creates a new cluster formed by the given element and inserts at the end of the list of clusters
	 * @param element
	 */
	public Node makeCluster(T element) {  // nothing needs to be changed here
		Node newNode=new Node(element,null,null);
		Dnode newCluster=new Dnode(newNode,tailCluster.prev,tailCluster);
		tailCluster.prev.next=newCluster;
		tailCluster.prev=newCluster;
		newCluster.first.cluster=newCluster;
		newCluster.size++;
		countClusters++;
		return newNode;
	}

	/****** for students to implement ***
	 * find returns the Dnode corresponding to the cluster where the node belongs to
	 * 
	 */
	public Dnode find(Node node) { // this is very short
		return node.cluster;
	}
	
	/******** for students to implement ****
	 *  union returns merges the cluster where node p belongs to with the one node q belongs to.
	 *  This method must run in O(min(n_q,n_p)) time, where n_p is the size of the cluster of node p
	 *  and n_q is the size of the cluster of node q.
	 *  Note: You must do appropriate updates on the linked list and double linked list and its corresponding
	 *  nodes and sizes to correctly reflect the fact that the clusters have been merged.
	 *  */
	public void union (Node p, Node q) {
		
		// determines the minimum cluster and maximum cluster between p and q
		Dnode minList, maxList;
		if (p.cluster.size<= q.cluster.size) {
			minList=p.cluster; 
			maxList=q.cluster;
		}
		else {
			minList=q.cluster; 
			maxList=p.cluster;		
		}
		
		// transfer elements of minimum cluster to larger cluster
		Node temp;
		for (Node node=minList.first; node!=null; node=temp) {
			node.cluster=maxList;// update cluster for this node
			temp=node.next;
			// insert node at the head of the list maxList
			node.next=maxList.first; 
			maxList.first=node;
			maxList.size++; // increments size
		}	
		
		// delete Dnode of minList from the doubly linked list
		minList.prev.next=minList.next;
		minList.next.prev=minList.prev;
		
		countClusters--; // decrement number of clusters
		
	}
	
	@Override
	public String toString() {
		// prints all clusters information and elements (nothing to be changed here)
		StringBuilder s = new StringBuilder(); int num=0;
		for (Dnode d=headCluster.next; d!=tailCluster; d=d.next) {
			s.append("Cluster ");
		    s.append(++num); s.append(" (size="); s.append(d.size); s.append("): ");
			for (Node n=d.first; n!=null; n=n.next) {
				s.append(n.element.toString());
				s.append(',');
			}
			s.append("\n");
		}
		return s.toString();
	}
	
}
