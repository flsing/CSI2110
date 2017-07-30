// ==========================================================================
// $Id: NodeList.java,v 1.1 2006/10/02 14:38:58 jlang Exp $
// CSI2110 Lab code Node List skeleton class
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
// $Log: NodeList.java,v $
// Revision 1.1  2006/10/02 14:38:58  jlang
// Bring lab1-5 into cvs
//
//
// ==========================================================================
import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.ListIterator;

public class NodeList<E> {
  protected LinkedList<E> linkedList = new LinkedList<E>();

  protected int findIndex( E element ) {
    int index = -1;
    for ( ListIterator<E> iter = linkedList.listIterator(); 
	  iter.hasNext(); ) {
      if ( iter.next() == element ) {
	index = iter.previousIndex();
      }
    }
    return index;
  }

  public int size() {
    return linkedList.size();
  }

  public boolean isEmpty() {
    return linkedList.isEmpty();
  }

  public boolean isFirst(E element) {
    if ( size() > 0 ) {
      return (linkedList.element() ==  element);
    } else {
      return false;
    }
  }

  public boolean isLast(E element) {
    if ( size() > 0 ) {
      return (linkedList.getLast() == element);
    } else {
      return false;
    }
  }

  public E first() 
    throws NoSuchElementException {
    return linkedList.element();
  }

  public E last() 
    throws NoSuchElementException {
    return linkedList.getLast();
  }

  E prev(E element)
    throws NoSuchElementException  {
    for ( ListIterator<E> iter = linkedList.listIterator(); 
	  iter.hasNext(); ) {
      if ( iter.next() == element ) return iter.previous();
    }
    throw new NoSuchElementException();
  }

  E next(E element)
    throws NoSuchElementException  {
    for ( ListIterator<E> iter = linkedList.listIterator(); 
	  iter.hasNext(); ) {
      if ( iter.next() == element ) return iter.next();
    }
    throw new NoSuchElementException();
  }

  public void swapElements(E element1, E element2)
    throws NoSuchElementException {
    int index1 = findIndex( element1 );
    if ( index1 == -1 ) throw new NoSuchElementException();
    int index2 = findIndex( element2 );
    if ( index2 == -1 ) throw new NoSuchElementException();
    linkedList.set( index1, element2 );
    linkedList.set( index2, element1 );
    return;
  }
  

  public void set(E currElement, E repElement)
    throws NoSuchElementException {
    int index = findIndex( currElement );
    if ( index == -1 ) throw new NoSuchElementException();
    linkedList.set( index, repElement );
    return;
  }

  public void addFirst(E element) {
    linkedList.addFirst(element);
    return;
  }

  public void addLast(E element) {
    linkedList.addLast(element);
    return;
  }

  public void addBefore(E currElement,E addElement)
    throws NoSuchElementException {
    int index = findIndex( currElement );
    if ( index == -1 ) throw new NoSuchElementException();
    linkedList.add( index, addElement );
    return;
  }

  public void addAfter(E currElement,E addElement) 
    throws NoSuchElementException {
    int index = findIndex( currElement );
    if ( index == -1 ) throw new NoSuchElementException();
    linkedList.add( index+1, addElement );
    return;
  }
  
  public E remove(E element) 
    throws NoSuchElementException {
    for ( ListIterator<E> iter = linkedList.listIterator(); 
	  iter.hasNext(); ) {
      if ( iter.next() == element ) {
	iter.remove();
	return element;
      }
    }
    throw new NoSuchElementException();
  }
}
