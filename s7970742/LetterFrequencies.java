
/**
 * LetterFrequencies class is handy to store letters and their frequencies, 
 * with flexibilty of getting them either from a String or a Text
 *
 * @author Lucia Moura
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class LetterFrequencies {
	
	static int NUM_CHARS='\uffff'+1; // there are 2^16 possible characters in UTF-16
	
	char[] letters;
	int [] freq;
	
	public LetterFrequencies (char[] letters, int[] freq) {
		this.letters=letters.clone();
		this.freq=freq.clone();
	}
	
	public LetterFrequencies(String inputText) {
		
		int [] counter = new int[NUM_CHARS];
		for (int i=0; i<NUM_CHARS; i++) counter[i]=0;
		ArrayList<Character> lettersThatShowUp=new ArrayList<Character>();
		for (int i=0; i< inputText.length(); i++) {
            if (counter[(int)inputText.charAt(i)]==0) lettersThatShowUp.add(inputText.charAt(i));
			counter[(int)inputText.charAt(i)]++;
		}
		freq=new int[lettersThatShowUp.size()];
		letters=new char[lettersThatShowUp.size()];
		for (int i=0; i<lettersThatShowUp.size();i++) {
			letters[i]=lettersThatShowUp.get(i);
			freq[i]=counter[(int)letters[i]];
		}
	}
	
    public LetterFrequencies(InputStreamReader isr) throws IOException {
		
		int [] counter = new int[NUM_CHARS];
		for (int i=0; i<NUM_CHARS; i++) counter[i]=0;
		
		ArrayList<Character> lettersThatShowUp=new ArrayList<Character>();
		int c;
		
		c = isr.read();
	
		while (c!=-1) {
            if (counter[c]==0) lettersThatShowUp.add((char)c);
			counter[c]++;
			c=isr.read();
		}
		freq=new int[lettersThatShowUp.size()];
		letters=new char[lettersThatShowUp.size()];
		for (int i=0; i<lettersThatShowUp.size();i++) {
			letters[i]=lettersThatShowUp.get(i);
			freq[i]=counter[(int)letters[i]];
		}
	}
	
    
	public int [] getFrequencies() {
		return freq;
	}

	public char [] getLetters() {
		return letters;
	}
}

