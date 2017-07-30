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
        nNode.previous = pAfter;
        if (pAfter.next != null)
           pAfter.next.previous = nNode;
        else
           lastNode = nNode;
        pAfter.next = nNode;
    }

    // Removes the specified node from the list
    void RemoveNode(ListNode nNode)
    {
        if (nNode.previous == null)
            firstNode = nNode.next;
        else
            nNode.previous.next = nNode.next;
        if (nNode.next == null)
            lastNode = nNode.previous;
        else
            nNode.next.previous = nNode.previous;
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