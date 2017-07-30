/** 
 * Builds a double linked list of size 5 and prints it to the console.
 */

class DLinkList {
    DNode head,tail;

    DLinkList( int sz ) {
 if ( sz <= 0 ) {
     head = null;
     tail = null;
 }
 else {
   
    head=new DNode(null,null,null);
    tail=new DNode(null,head,null);
    head.setNext(tail);
   
    for (int i=0;i<sz;i++){
      DNode node2Add = new DNode( Integer.toString(i),null,null);
      node2Add.setPrev(tail.getPrev());
      node2Add.setNext(tail);
      tail.getPrev().setNext(node2Add);
      tail.setPrev(node2Add);
    }
  }
    }
    
    /**
     * Print all the elements of the list assuming that they are Strings
     */
    public void print() {
 /* Print the list */
 DNode current = head.getNext(); // point to the first node
 while (current != tail) {
     System.out.print((String)current.getElement() + " "); 
     current = current.getNext(); // move to the next
 }
 System.out.println(); 
    }

    
    public void deleteFirst() {
      DNode toDel=head.getNext();
      
 if ( toDel != tail ) {
   
     head.setNext(toDel.getNext());
     toDel.getNext().setPrev(head);
 }
    }

  
    public void deleteLast() {
      
      DNode toDel=tail.getPrev();
      if ( toDel == head ) return; // no node
      
      tail.setPrev(toDel.getPrev());
      toDel.getPrev().setNext(tail);
    }

    // create and display a linked list
    public static void main(String [] args){
 /* Create the list */
 DLinkList llist = new DLinkList( 5 );
 /* Print the list */
 llist.print();
 /* delete first and print */
 llist.deleteFirst();
 llist.print();
 /* delete last and print 5 times */
 for ( int i=0; i< 5; ++i ) {
     llist.deleteLast();
     llist.print();
 }
    }
}
