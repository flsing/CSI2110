
/**
 *
 * @author Lachlan
 */
public class Entry<K extends Comparable,V> {
    K key;
    V value;
    
    /**
    * Returns the key stored in this entry.
    * @return the entry's key
    */
    K getKey(){
        return key;
    }

    /**
    * Returns the value stored in this entry.
    * @return the entry's value
    */
    V getValue(){
        return value;
    }
    
    public Entry(K k, V v){
        key = k;
        value = v;
    }
    
}
