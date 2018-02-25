package ADwk2;

class DLList {
  class Node {
    // Each node object has these three fields
    private Object element;
    private Node previous;
    private Node next;

    // Constructor: Creates a Node object with element = e, previous = p and next = n
    Node(Object e, Node p, Node n) {
      element = e;
      previous = p;
      next = n;
    }
    
    // Copy Constructor:
    Node(Node n)
    {
      element = n.getElement();
      previous = n.getPrevious();
      next = n.getNext();
    }

    // This function gets Object e as input and sets e as the element of the Node
    public void setElement(Object e) {
      element = e;
    }

    // This function returns the element variable of the Node
    public Object getElement() {
      return element;
    }

    // This function gets Node n as input and sets the next variable of the current Node object as n.
    public void setNext(Node n) {
      next = n;
    }

    // This function returns the next Node
    public Node getNext() {
      return next;
    }

    // This function gets Node p as input and sets the previous variable of the current Node object as p.
    public void tmp(Node p) {
      previous = p;
    }

    // This function gets Node p as input and sets the previous variable of the current Node object as p.
    public void setPrevious(Node p) {
      previous = p;
    }
    
    // This function returns the previous Node
    public Node getPrevious() {
      return previous;
    }
  }

  // Each object in DLList has one field head, which points to the starting Node of DLList.
  private Node head;
  // Each object in DLList has one field tail, which points to the final Node of DLList.
  private Node tail;

  /**
   * Constructor: initialises the head and tail fields as null
   */
  public DLList() {
    this.head = null;
    this.tail = null;
  }
  
  /**
   * @return The element in the head Node of the DLL
   */
  public Object getHead() {
    return head.getElement();
  }

  /**
   * @return The element in the tail Node of the DLL
   */
  public Object getTail() {
    return tail.getElement();
  }

  /**
   * Adds element e in a new Node to the head of the list.
   *
   * @param e
   *     The element to add.
   */
  public void addFirst(Object e) {
    
    Node new_node = new Node(e, null, null);
    
    if(this.size() == 0)
    {
    	new_node.setNext(new_node);
    	new_node.setPrevious(new_node);
    	head = new_node;
    	tail = new_node;
    }
    else
    {
    	new_node.setNext(head);
    	new_node.setPrevious(tail);
    	head.setPrevious(new_node);
    	tail.setNext(new_node);
    	head = new_node;
    }
  }

  /**
   * Remove the first Node in the list and return its element.
   *
   * @return The element of the head Node. If the list is empty, this method returns null.
   */
  public Object removeFirst() {
    if(this.size() == 0) {
  		return null;
    }
    else if(head == tail) {
      Node old_node = new Node(head);
      head = null;
      tail = null;
      return old_node.getElement();
    }
    else
    {
      	Node old_node = new Node(head);
    	head.getNext().setPrevious(tail);
    	tail.setNext(head.getNext());
    	head = head.getNext();
    	return old_node.getElement();
    }
    
  }

  /**
   * Adds element e in a new Node to the tail of the list.
   *
   * @param e
   *     The element to add.S
   */
  public void addLast(Object e) {
    
    Node new_node = new Node(e, null, null);
    
    if(this.size() == 0)
    {
    	new_node.setNext(new_node);
    	new_node.setPrevious(new_node);
    	head = new_node;
    	tail = new_node;
    }
    else
    {
    	new_node.setNext(head);
    	new_node.setPrevious(tail);
    	tail.setNext(new_node);
    	head.setPrevious(new_node);
    	tail=new_node;
    }
  }

  /**
   * Remove the last Node in the list and return its element.
   *
   * @return The element of the tail Node. If the list is empty, this method returns null.
   */
  public Object removeLast() {
    if(this.size() == 0) {
    	return null;
    }
    else if(head == tail) {
      Node old_node = new Node(tail);
      head = null;
      tail = null;
      return old_node.getElement();
    }
    else {
    	Node old_node = new Node(tail);
    	tail.getPrevious().setNext(head);
    	head.setPrevious(tail.getPrevious());
    	tail = tail.getPrevious();
    	return old_node.getElement();
    }
  }

  /**
   * @return the number of Nodes in the list
   */
  public int size() {
	if(head == null) {
	  return 0;
	}
	if(head == tail) {
	  return 1;
	}
	
	Node node = head.getNext();
	int i=2;
	
	while (node != tail) {
	  node = node.getNext();
	  i++;
	}
	return i;
  }

  /**
   * Adds element e in a new Node which is inserted at position pos.
   * The list is zero indexed, so the first element in the list corresponds to position 0.
   * This also means that `addAtPosition(0, e)` has the same effect as `addFirst(e)`.
   * If there is no Node in position pos, this method adds it to the last position.
   *current.getNext()
   * @param pos
   *     The position to insert the element at.
   * @param e
   *     The element to add.
   */
  public void addAtPosition(int pos, Object e) {
    Node new_node = new Node(e, null, null);
    
    if(this.size() == 0) {
    	new_node.setNext(new_node);
    	new_node.setPrevious(new_node);
    	head = new_node;
    	tail = new_node;
    }
    else if(pos >= this.size()) {
      this.addLast(e);
    }
    else {
      Node node = head;
      for(int i=0; i<pos; i++) {
    	node = node.getNext();
    	if(node == tail) {
    	  break;
    	}
      }
      if(node == head) {
    	this.addFirst(e);
      }
      else {
    	new_node.setNext(node);
    	new_node.setPrevious(node.getPrevious());
    	node.getPrevious().setNext(new_node);
    	node.setPrevious(new_node);
      }
    }
  }

  /**
   * Remove Node at position pos and return its element.
   * The list is zero indexed, so the first element in the list corresponds to position 0.
   * This also means that `removeFromPosition(0)` has the same effect as `removeFirst()`.
   *
   * @param pos
   *     The position to remove the Node from.
   * @return The element of the Node in position pos. If there is no Node in position pos, this method returns null.
   */
  public Object removeFromPosition(int pos) {
	if(this.size() == 0)
    {
	  return null;
    }
    else
    {
      Node node = head;
      for(int i=0; i<pos; i++)
      {
    	node = node.getNext();
    	if(node == tail)
    	{
    	  if(i+1==pos) break;
    	  else return null;
    	}
      }
      if(head == tail) {
    	head = null;
    	tail = null;
    	return node.getElement();
      }
      else if(node == head) {
    	return this.removeFirst();
      }
      else if(node == tail) {
    	return this.removeLast();
      }
      else {
    	node.getPrevious().setNext(node.getNext());
    	node.getNext().setPrevious(node.getPrevious());
    	return node.getElement();
      }
    }
  }

  /**
   * @return A new DLL that contains the elements of the current one in reversed order.
   */
  public DLList reverse() {
	DLList new_list = new DLList();
	Node current = head;
	
	do {
	  new_list.addFirst(current.getElement());
	  current = current.getNext();
	} while (current != tail);
	new_list.addFirst(current.getElement());
	
    return new_list;
  }
}

public class impl5 {

  public static void main(String[] args) {
	System.out.println("Begin");
	
	DLList list = new DLList();
	
	list.addLast("a");
	list.addLast("b");
	list.addLast("c");
	list.addLast("d");
	list.addLast("e");
	list.addLast("f");
	
	list.addAtPosition(6,"koe");
	//System.out.println(list.removeFromPosition(4));
	System.out.println("----");
	

	//DLList nlist = new DLList(list);
	DLList rlist = list.reverse();
	
	while(list.size() != 0)
	{
	  System.out.println(list.removeFirst());
	}
	
	
	System.out.println("----");


	while(rlist.size() != 0)
	{
	  System.out.println(rlist.removeFirst());
	}
	
	System.out.println("----");
	
	
	System.out.println("End");
  }
}
