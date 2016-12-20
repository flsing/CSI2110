import java.util.Iterator;

/**
 *  
 * Interface that provides a continuos stream of bits (0 or 1)
 * returned by getNext()
 * 
 * This implementation uses a String to store bits
 *
 * @author Lucia Moura
 */


public class BitFeedInForString implements Iterator<Byte>{
		String bitSeq;
		int nextPos=0;
		
		public BitFeedInForString(String s) {
			bitSeq = s;
			nextPos=0;
		}
		
		public boolean hasNext() {
			if (bitSeq.length() > nextPos) return true;
			else return false;
		}
		public Byte next() {
			if (hasNext()) {
				if (bitSeq.charAt(nextPos++)=='0') return 0;
				else return 1;
			}
			else return -1;
		}
	
}
