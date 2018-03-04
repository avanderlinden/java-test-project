package ADwk3;

import java.util.*;

public class Impl4 {
  public static void main(String[] args) {
	
  }

}

class Queue<T> {
  private Stack<T> s1 = new LibraryStack<>();
  private Stack<T> s2 = new LibraryStack<>();

  /**
   * @return true iff there are no elements left.
   */
  public boolean isEmpty() {
    if (s1.size() == 0){
      return true;
    }
    else {
      return false;
    }
  }

  /**
   * @return the number of elements in the queue.
   */
  public int size() {
    return s1.size();
  }

  /**
   * Adds an element to the queue.
   *
   * @param i
   *     element to enqueue.
   */
  public void enqueue(T i) {
    s1.push(i);
  }

  /**
   * Removes the first element from the queue.
   *
   * @return the first element from the queue.
   * @throws NoSuchElementException
   *     iff the queue is empty.
   */
  public T dequeue() throws NoSuchElementException {
    if (this.isEmpty()) {
      throw new NoSuchElementException();
    }
    
    int size = s1.size();
    for(int i=0; i<size; i++) {
      s2.push(s1.pop());
    }
    
    T element = s2.pop();
    
    for(int i=0; i<size-1; i++) {
      s1.push(s2.pop());
    }
    return element;
  }

  /**
   * Only returns (i.e. does not remove) the first element from the queue.
   *
   * @return the first element from the queue.
   * @throws NoSuchElementException
   *     iff the queue is empty.
   */
  public T first() throws NoSuchElementException {
    if (this.isEmpty()) {
      throw new NoSuchElementException();
    }
    int size = s1.size();
    for(int i=0; i<size; i++) {
      s2.push(s1.pop());
    }
    
    T element = s2.peek();
    
    for(int i=0; i<size; i++) {
      s1.push(s2.pop());
    }
    return element;
  }
}

/**
 * DO NOT MODIFY
 * Interface for a Stack.
 *
 * @param <T>
 *     Type of elements the Stack can hold
 */
interface Stack<T> {
  /**
   * @return true iff it contains no elements.
   */
  public boolean isEmpty();

  /**
   * @return the number of elements in the stack.
   */
  public int size();

  /**
   * Add an element to the top of the stack
   *
   * @param e
   *     element to push.
   */
  public void push(T e);

  /**
   * Removes the top element from the stack.
   *
   * @return the first element.
   * @throws NoSuchElementException
   *     iff the stack is empty
   */
  public T pop() throws NoSuchElementException;

  /**
   * @return the top element (does not pop it).
   * @throws NoSuchElementException
   *     iff the stack is empty
   */
  public T peek() throws NoSuchElementException;
}
//

