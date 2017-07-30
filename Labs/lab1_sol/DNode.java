/**
 * A double node class for a double-linked list.  Each node has a
 * reference to a stored element and a next node and a previous node.
 * This class is based on the <code>DNode</code> class by Roberto Tamassia.
 */

public class DNode{

  private Object element;
  private DNode next,prev;
  
  public DNode(Object e, DNode p,DNode n)
  {
    element=e;
    next=n;
    prev=p;
  }
  public void setElement(Object newElem) { element = newElem; }
  public Object getElement() { return element; }
  public void setNext(DNode newNext) { next = newNext; }
  public DNode getNext() { return next; }
  public void setPrev(DNode newPrev) { prev = newPrev; }
  public DNode getPrev() { return prev; }
  
}

