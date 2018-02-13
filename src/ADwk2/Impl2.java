package ADwk2;

import java.util.*;
import java.util.ArrayList;
import static java.util.Arrays.*;

public class Impl2 {

  public static void main(String[] args) {
	ArrayList<Integer> testarr = new ArrayList<>(asList(1,1,1,1));
	//int[] testarr = new int[0];
	
//	System.out.println(testarr.toString());
//	removeLastOccurrence(5, testarr);
//	System.out.println(testarr.toString());
//	removeLastOccurrence(5, testarr);
//	System.out.println(testarr.toString());
	
	removeAll(testarr);
	System.out.println(testarr.toString());
	
  }
  
  /**
   * Removes all elements from the ArrayList, using the removeLastOccurrence method.
   *
   * @param list
   *     to remove the elements from.
   */
  public static void removeAll(ArrayList<Integer> list) {
//	ArrayList<Integer> result = new ArrayList<>(list); // if using iter we cannot modify "list" itself
	
	for( int i=list.size()-1; i>=0; i-- ) {
	  removeLastOccurrence(list.get(i), list);
	  System.out.println(list.toString());
    }
	
//	ListIterator iter = list.listIterator(list.size()); // using iterator to increase performance for large ArrayLists
//	while( list.size() > 0 ) {
//	  int element = (Integer) iter.previous();
//	  removeLastOccurrence(element, list);
//	  System.out.println(list.toString()); 
//	}
//	
//	list = result;
	return;
  }

  /**
   * Takes an ArrayList and removes last occurrence of x,
   * shifting the rest of the elements left.
   * I.e. [5, 1, 5, 9, 8], with x = 5
   * would result in: [5, 1, 9, 8].
   * Note that this method does not return a new list.
   * Instead, the list that is passed as a parameter is changed.
   *
   * @param list
   *     to remove an element from.
   * @param x
   *     element value to look for
   */
  public static void removeLastOccurrence(int x, ArrayList<Integer> list) {
	if ( list.size() == 0 ) {
	  return;
	}
	
	int new_length = list.size()-1;
	
	for( int i=new_length; i>=0; i-- ) {
      if ( list.get(i) == x ) {
    	list.remove(i);
    	return;
      }
    }
    return;
  }
}
