/**
 *  
 * Interface that receives a continuos stream of bits (0 or 1)
 * inserted by putNext()
 * 
 * This gives flexibility of communicating with HuffmanTree 
 * by using strings, byte arrays or files
 * 
 * (used in Huffman encoding)
 *
 * @author Lucia Moura
 */


public interface BitFeedOut {

		public void close(); 
		public void putNext(char bit);

}
