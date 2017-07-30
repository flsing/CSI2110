/**
 *  
 * This implementation of BitFeedOut uses a StringBuilder to store bits
 * 
 *
 * @author Lucia Moura
 */

public class BitFeedOutForString implements BitFeedOut {

	StringBuilder bitSeq;
	boolean closed;
	
	public BitFeedOutForString() {
		bitSeq = new StringBuilder("");
		closed=false;
	}
	
	String output() {
		return bitSeq.toString();
	}
	
	public void close() {
		closed=true;
		
	}
	
	public void putNext(char bit) {
		if (closed) {
			closed=false;
			bitSeq = new StringBuilder("");
		}
		bitSeq.append(bit);
	}
	
	
	
}
