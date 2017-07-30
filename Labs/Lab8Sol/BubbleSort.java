// ==========================================================================
// $Id: BubbleSort.java,v 1.1 2006/11/05 03:27:51 jlang Exp $
// CSI2110 Lab code; basic bubble sort 
// ==========================================================================
// (C)opyright:
//
//   SITE, University of Ottawa
//   800 King Edward Ave.
//   Ottawa, On., K1N 6N5
//   Canada. 
//   http://www.site.uottawa.ca
// 
// Creator: unknown (Lab source without reference), adapted by J.Lang
// Email:   jlang@site.uottawa.ca
// ==========================================================================
// $Log: BubbleSort.java,v $
// Revision 1.1  2006/11/05 03:27:51  jlang
// Added lab8 on sorting.
//
// Revision 1.2 2006/11/10  (Shantanu Das)
// Sorting Method changed to Mergesort
// ==========================================================================
/**
 * (Implements bubble sort).....Now, implements Merge-sort !!!
 */
import java.util.ArrayList;

public class BubbleSort<T extends Comparable> {

  public BubbleSort(T[] _seq) {
 
     mergeSort(_seq,0,_seq.length);      // Changed bubblesort to mergesort.
  }
  
  protected void mergeSort(T[] myArray, int start, int size) {
    if(size < 2)
      return;
    mergeSort(myArray, start, size/2);        // merge-sort first half of the array.
    int second = start + (size/2);         // second half of the array starts here
    int secondsize = size - (size/2);      // size of the second-half 
    mergeSort(myArray, second, secondsize);          // merge-sort the second half
    merge(myArray, start, size/2, second, secondsize);   // merge the first and second half
  }
 
  // Method for merging two sub-arrays starting from position "first" and "second" resp.
  // This assumes that the two sub-arrays are contiguous.
  protected void merge(T[] myArray, int first, int firstsize, int second, int secondsize) {
    ArrayList<T> temp = new ArrayList<T>(firstsize + secondsize);
    int first_end = first + firstsize;           // index where first array ends
    int second_end = second + secondsize;        // index where second array ends 
    int i,j,k;
    for(i=first,j=second,k=0; (i < first_end) && (j < second_end); k++) {
      if(myArray[i].compareTo(myArray[j]) < 0)
        temp.add(k,myArray[i++]);
      else
        temp.add(k,myArray[j++]);
    }
    while(i < first_end)                    // copy the extra elements from first array (if any)
      temp.add(k++,myArray[i++]);
    while(j < second_end)                   // copy the extra elements from second array (if any)
      temp.add(k++,myArray[j++]);
    for (i = first, j = 0; j < temp.size(); i++, j++)    // copy back the merged elements into myArray.
      myArray[i] = temp.get(j); 
  }

};

/* Previous Bubble sort method ---- DISCARDED !!
 * 
 * public BubbleSort(T[] _seq ) {
    for (int i = 0; i < _seq.length; i++) {
        for (int j = 1; j < _seq.length - i; j++) {
          // if (_seq[j - 1] > _seq[j]) {
          if (_seq[j - 1].compareTo(_seq[j]) > 0 ) {
            T temp = _seq[j];
            _seq[j] = _seq[j - 1];
            _seq[j - 1] = temp;
          }
        }
    }
  }
*/