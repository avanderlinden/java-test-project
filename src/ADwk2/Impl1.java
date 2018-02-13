package ADwk2;

import java.util.Arrays;

public class Impl1 {
  
  public static void main(String[] args) {
	int[] testarr = {1, 4, 7, 9, 4, 67, 8};
	//int[] testarr = new int[0];
	System.out.println(Arrays.toString(testarr));
	System.out.println(Arrays.toString(removeLastOccurrence(4, testarr)));
	System.out.println(Arrays.toString(removeLastOccurrence(4, testarr)));
	
	
	
  }
  
  /**
   * Takes the array and the last occurring element x,
   * shifting the rest of the elements left. I.e.
   * [1, 4, 7, 9], with x=7 would result in:
   * [1, 4, 9].
   *
   * @param x
   *     the entry to remove from the array
   * @param arr
   *     to remove an entry from
   * @return the updated array, without the last occurrence of x
   */
  public static int[] removeLastOccurrence(int x, int[] arr) {
	if ( arr.length == 0 ) {
	  return arr;
	}
	
	int new_length = arr.length-1;
	int[] result = new int[new_length];
	
	for( int i=new_length; i>=0; i-- ) {
      if ( arr[i] == x ) {
    	for( int j=0; j < new_length; j++ ) {
    	  if ( j<i ) {
    		result[j] = arr[j];
    	  } else { // offset is 1 after index of last occurrence of x
    		result[j] = arr[j+1];
    	  }
    	}
    	return result;
      }
    }
    return arr;
  }
}
//
  
