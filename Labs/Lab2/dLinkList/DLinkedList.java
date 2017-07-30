/*  CSI2114 Lab 2 - DLinkedList.java
 *  
 *  Class doubly linked list   
 *  
 *  by Jeff Souza
 *
 */

class DLinkedList {

    ListNode firstNode;
    ListNode lastNode;

    // Appends a node to the end of the list
    void AppendNode(ListNode nNode) {
        InsertNode(nNode,lastNode);
    }

    // Inserts a node into the list after pAfter
    void InsertNode(ListNode nNode, ListNode pAfter) {

  	 
  	  nNode.next = pAfter.next;
  	  pAfter.next = nNode;
  	  lastNode= nNode;
  	  //nNode.previous = pAfter.next;
  	  
  	  
    }

    // Removes the specified node from the list
    void RemoveNode(ListNode nNode) {
  

    	if(nNode.data == firstNode.data){
    		
    		firstNode.data = firstNode.next.data;
    		firstNode = firstNode.next;
    		
    	}
    	if(nNode.data == lastNode.data){
    		lastNode = null;
    	}
    		

  	  
  
    }

    // print the content of the list
    void print() {
        ListNode nNode = null;
        System.out.print("Current list: ");
        for (nNode = firstNode; nNode != null; nNode = nNode.next) {
            System.out.print(nNode.data +  " ");
        }
        System.out.println("");
    } 
  
}