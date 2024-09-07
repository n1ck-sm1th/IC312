//This is for testing the linked list methods and how to set it up.a
//
//
//
//

  


public class test<T>{
  /**
   *
   * Private Node class that consists of generics.
   */
  private class Node<T> {
    T data;
    Node<T> next;

    Node(T data, Node<T> next) {
      this.data = data;
      this.next = next;
    }
  }

  private Node<T> head;

  /**
   *
   * Wrapper method for traversal, Traverse gets us
     to the indexed part of the LL that we want. 
    */
  public void traverse(int index) throws IndexOutOfBoundsException{
    //Check that we are not traversing to an illegal index. 
    if(index > size())
      throw new IndexOutOfBoundsException("Index in Traverse!");
    traverse(head, index); 
  } 

  public Node<T> traverse(Node<T> cur, int index){
    //This will go to the specific spot I want.
    if (index == 0 || cur.next == null) 
      return cur; 
    return traverse(cur.next, index - 1);
  }

  public void add(int index, T data) throws IndexOutOfBoundsException {
    //Ensure we are in proper bounds.
    if(index < 0 || index > size())
      throw new IndexOutOfBoundsException("Index!");
    
    //If our list is empty we are going to add a new node and we are done. 
    if(head == null)
      head = new Node<>(data, null);
    
    //Create a new node for adding if we need to.
    //Traverse to the indexed node, then add to the rear of it. 
    else
    {
      Node<T> newNode = new Node<>(data, null);
      add(traverse(head, index), newNode);
    }
  }
  
  /**
   *
   * Once at indexed node we add the newNode to the back of it,
   * If we add to middle we create a temp back node that will,
   * add to the back of our newNode. 
   */ 
  public void add(Node<T> cur, Node<T> newNode) {
    //Initialize back.
    Node<T> back = null; 
    //If we are at the end of the list add to back.
    if(cur.next == null) 
    {
      cur.next = newNode;
      return;
    }
    //Else add to middle. 
    back = cur.next;
    cur.next = newNode; 
    newNode.next = back;
    return; 
  }

  /**
   *
   * Interface method, wrapper for size.
   */
   public int size() {
    return size(head);   //If we are at the end of the list add to back.
   }

  /**
   *
   * Recursive size method.
   */
  private int size(Node<T> cur){
    if(cur == null)
      return 0;
    return 1 + size(cur.next);
  } 

  /**
   *
   * Wrapper method to get.
   */
  public T get(int index){
   if(index < 0 || index > size())  //Out of bounds testing.
      throw new IndexOutOfBoundsException("Index!");
   return get(traverse(head, index));
  }

  /**
   *
   * Since we already traversed to our index,
   * We just call get on the particular node. 
   */
  public T get(Node<T> cur){
    return cur.data;
  } 

  /**
   *
   * Wrapper method to set.
   */
  public void set(int index, T data){
   if(index < 0 || index > size())  //Out of bounds testing.
      throw new IndexOutOfBoundsException("Index!");
   set(traverse(head, index), data);
  }

  /**
   *
   * Method to set the data at a particular node.
   */
  public void set(Node<T> cur, T data){
    cur.data = data;
  }  

  /**
   *
   * Wrapper method for removing nodes from the list.
   */
  public void remove(int index) throws IndexOutOfBoundsException {
    //Ensure we are in proper bounds.
    if(index < 0 || index > size())
      throw new IndexOutOfBoundsException("Index!");
    
    //If our list is empty we are going to throw empty list exception
    if(head == null)
      throw new IndexOutOfBoundsException("Empty list!");
    
    //Traverse to the node before the node to be removed.
    if(index == 0)
    {
      head = head.next;
      return;
    }
    remove(traverse(head, index -1 ));
  }
  
  /**
   *
   * Once at the node before our indexed node we traverse to the node after
   * next, set it equal to next.
   */ 
  public void remove(Node<T> cur) {
    // The next node is set to skip over the other node. 
    cur.next = cur.next.next;
  }

 
  //Testing main. 
  public static void main(String[] args){
    test<Integer> list = new test<>();
    list.add(0, 1000);
    list.add(1, 2000);
    list.add(2, 3000);
    System.out.println(list.get(2));
    list.set(2, 3005);
    System.out.println(list.get(2));
    list.remove(1);
    System.out.println(list.get(0));
    System.out.println(list.get(1));
    return;
  }
}

