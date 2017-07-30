/**
 * Array Heap implementation of a priority queue
 * @author Lachlan Plant
 */
public class HeapPriorityQueue<K extends Comparable<K>,V> implements PriorityQueue<K ,V> {
    
    private Entry<K,V>[] storage; //The Heap itself in array form
    private int tail;        //Index of last element in the heap
    
    /**
    * Default constructor
    */
    public HeapPriorityQueue(){
        this(100);
    }
    
    /**
    * HeapPriorityQueue constructor with max storage of size elements
    */
    public HeapPriorityQueue(int size){
        storage = new Entry[size];
        tail = -1;
    }
    
    /****************************************************
     * 
     *             Priority Queue Methods
     * 
     ****************************************************/
    
    /**
    * Returns the number of items in the priority queue.
    * O(1)
    * @return number of items
    */
    public int size(){
        return tail +1;
    }

    /**
    * Tests whether the priority queue is empty.
    * O(1)
    * @return true if the priority queue is empty, false otherwise
    */
    public boolean isEmpty(){
        return tail < 0;
    }
    
    /**
    * Inserts a key-value pair and returns the entry created.
    * O(log(n))
    * @param key     the key of the new entry
    * @param value   the associated value of the new entry
    * @return the entry storing the new key-value pair
    * @throws IllegalArgumentException if the heap is full
    */
    public Entry<K,V> insert(K key, V value) throws IllegalArgumentException{
        if(tail == storage.length -1) throw new IllegalArgumentException("Heap Overflow");
        Entry<K,V> e = new Entry<>(key,value);        
        storage[++tail] = e;
        upHeap(tail);
        return e;
    }
    
    /**
    * Returns (but does not remove) an entry with minimal key.
    * O(1)
    * @return entry having a minimal key (or null if empty)
    */
    public Entry<K,V> min(){
        if(isEmpty()) return null;
        return storage[0];
    } 
    
    /**
    * Removes and returns an entry with minimal key.
    * O(log(n))
    * @return the removed entry (or null if empty)
    */ 
    public Entry<K,V> removeMin(){
        if(isEmpty()) return null;
        Entry<K,V> ret = storage[0];
        if(tail == 0){
            tail = -1;
            storage[0] = null;
            return ret;
        }
        storage[0] = storage[tail];
        storage[tail--] = null;
        downHeap(0);
        return ret;
        
    }  
    
    
    /****************************************************
     * 
     *           Methods for Heap Operations
     * 
     ****************************************************/
    
    /**
    * Algorithm to place element after insertion at the tail.
    * O(log(n))
    */
    private void upHeap(int location){
         if(location == 0) return;
         int parent = parent(location);
         if(storage[parent].key.compareTo(storage[location].key) > 0){
             swap(location,parent);
             upHeap(parent);
         }             
    }
    
    /**
    * Algorithm to place element after removal of root and tail element placed at root.
    * O(log(n))
    */
    private void downHeap(int location){
         int left = (location*2) +1;
         int right = (location*2) +2;
         
         //Both children null or out of bound
         if(left > tail) return;
         //left in right out;
         if(left == tail){
              if(storage[location].key.compareTo(storage[left].key) > 0){
                  swap(location,left);                  
              }
              return;
         }
         int toSwap= (storage[left].key.compareTo(storage[right].key) < 0)? left:right;         
         if(storage[location].key.compareTo(storage[toSwap].key) > 0){
             swap(location,toSwap);
             downHeap(toSwap);
         }             
    }
    
    /**
    * Find parent of a given location,
    * Parent of the root is the root
    * O(1)
    */
    private int parent(int location){
        return (location-1)/2;
    }
    
   
    /**
    * Inplace swap of 2 elements, assumes locations are in array
    * O(1)
    */
    private void swap(int location1, int location2){
        Entry<K,V> temp = storage[location1];
        storage[location1] = storage[location2];
        storage[location2] = temp;
    }
    
}
