package ADwk3;

//import java.util.Arrays;
import java.util.EmptyStackException;

public class Impl1 {
  
  public static void main(String[] args) {
	
	ArrayStack arr = new ArrayStack();
	
	System.out.println(arr.toString());
	arr.push(1);
	System.out.println(arr.toString());
	System.out.println(arr.pop());
	System.out.println(arr.toString());
  }

}


class ArrayStack {
  private Object[] elements;
  private int size;
  private int capacity;

  /**
   * Creates an empty ArrayStack with capacity 1.
   */
  public ArrayStack() {
	elements = new Object[1];
	size = 0;
	capacity = 1;
  }

  /**
   * @return The size of this ArrayStack.
   */
  public int size() {
    return size;
  }

  /**
   * @return `true` iff this ArrayStack is empty, `false` otherwise.
   */
  public boolean isEmpty() {
    if(size == 0) {
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * @return `true` iff the size is equal to the capacity, `false` otherwise.
   */
  public boolean isFull() {
	if(size == capacity) {
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * @return the top element of the stack without removing it
   */
  public Object peek() throws EmptyStackException {
    if (size == 0) {
      throw new EmptyStackException();
    }
    else {
      return elements[0];
    }
  }

  /**
   * Adds `o` to the stack.
   * If capacity of stack was too small, capacity is doubled and `o` is added.
   *
   * @param o
   *     the element to add to the stack.
   */
  public void push(Object o) {
	if(size==0) {
	  elements[0] = o;
	  size++;
	}
	else {
	  if (this.isFull()) {
		doubleArrayCapacity();
	  }
	  shiftArrayRight();
	  elements[0] = o;
	  size++;
	}	
  }

  /**
   * Removes the top element from the stack.
   * If removing top would make the stack use less than 25% of its capacity,
   * then the capacity is halved.
   *
   * @return the element which was at the top of the stack.
   * @throws EmptyStackException
   *     iff the stack is empty
   */
  public Object pop() throws EmptyStackException {
    if (size == 0) {
      throw new EmptyStackException();
    }
    else {
      Object top = elements[0];
      shiftArrayLeft();
      size--;
      
      if (((float) size / (float) capacity) < 0.25) {
        halfArrayCapacity();
      }
      if(size == 0) {
    	capacity = 1;
      }
      
      return top;
    }
  }

  /**
   * @return a String representation of the ArrayStack
   * Example output for ArrayStack with 2 elements and capacity 5:
   * <ArrayStack[1,2]>(Size=2, Cap=5)
   */
  public String toString() {
	
	String sout = "<ArrayStack[";
    for(int i=size-1; i>=0; --i) {
      sout += ((Integer) elements[i]).toString();
      if (i != 0) {
    	sout += ",";
      }
    }
    sout += "]>(Size=";
    sout += ((Integer) size).toString();
    sout += ", Cap=";
    sout += ((Integer) capacity).toString();
    sout += ")";
    
    return sout;
  }

  // For testing, do not remove or change.
  public Object[] getElements() {
    return elements;
  }
  
  
  private void doubleArrayCapacity() {
	Object[] new_array = new Object[capacity*2];
	
	for(int i=0; i<size; i++) {
	  new_array[i] = elements[i];
	}
	elements = new_array;
	capacity = capacity*2;
	new_array = null;
  }
  
  private void halfArrayCapacity() {
	Object[] new_array = new Object[capacity/2];
	
	for(int i=0; i<size; i++) {
	  new_array[i] = elements[i];
	}
	elements = new_array;
	capacity = capacity/2;
	new_array = null;
  }
  
  private void shiftArrayRight() {
	for(int i=size-1; i>=0; --i) {
	  elements[i+1] = elements[i];
	}
  }
  
  private void shiftArrayLeft() {
	for(int i=0; i<size-1; i++) {
	  elements[i] = elements[i+1];
	}
	elements[size-1]=null;
  }
}
//