// Nicholas Smith
// ANY SOURCES OR COLLABORATION YOU USED HERE

import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
  
  //Private fields within the linked list
  private Node<T> head;
  private int size = 0; 
  
  /**
   *
   * Private Node class that consists of generics.
   */
  private class Node<T> {
    T data;
    Node<T> next;

    //Node constructor.
    private Node(T data, Node<T> next) {
      this.data = data;
      this.next = next;
    }
  }

  /**
   * Main method
   */
  public static void main(String[] args){
    LinkedList<Integer> list = new LinkedList<>();
    list.add(0, 0);
    list.remove(0);
    //list.printAll();  
    System.out.println("BREAK");
    System.out.println(list.size());
    System.out.println(list.penultimate());
  }  

  /**
   *
   * Tester print all method
   */
  public void printAll(){
    printAll(head);
  } 

  //Recursive printall method. 
  public void printAll(Node<T> cur){
    if(cur == null)
      return;
    System.out.println(cur.data);
    printAll(cur.next);
    return;
  }

  @Override
  /**
   *
   * Get method
   */
  public T get(int index) throws IndexOutOfBoundsException {
    if(index < 0 || index > size() - 1)
      throw new IndexOutOfBoundsException("Index at GET");
    return get(index, head);
  }

  //Recursive get method.
  public T get(int index, Node<T> cur){
    if(index == 0)
      return cur.data;
    return get(index - 1, cur.next);
  }

  @Override
  /**
   *
   * Set method
   */
  public void set(int index, T data) throws IndexOutOfBoundsException {
    if(index < 0 || index > size() - 1)
      throw new IndexOutOfBoundsException("Index at SET");
    set(index, data, head);
  }

  //Recursive set method.
  public void set(int index, T data, Node<T> cur){
    if(index == 0)
    {
      cur.data = data;
      return;
    }
    set(index - 1, data, cur.next);  
  } 

  @Override
  /**
   *
   * Add method
   */
  public void add(int index, T data) throws IndexOutOfBoundsException {
    //Go to the indexed value prior to what we want. 
    if(index < 0 || index > size() + 1)
     throw new IndexOutOfBoundsException("Index at ADD");
    if(head == null)
    {
      head = new Node<>(data, null); 
      return;
    }
    add(index -1, data, head);
  }

  //Recurisve add method.
  public void add(int index, T data, Node<T> cur){
    //Insert to front. 
    if(index == -1)
    {
      Node<T> newNode = new Node<>(data, cur); 
      newNode.next = cur;
      head = newNode;
      return;
    }
    //Insert to middle. 
    else if(index == 0)
    {
      Node<T> newNode = new Node<>(data, cur); 
      newNode.next = cur.next;
      cur.next = newNode;
      return;
    }
    add(index - 1, data, cur.next);
  }

  @Override
  /**
   *
   * Remove method
   */
  public void remove(int index) throws IndexOutOfBoundsException {
    if(index < 0 || index > size() - 1)
      throw new IndexOutOfBoundsException("Index at REMOVE");

    if(head == null)
      throw new IndexOutOfBoundsException("Empty list!");

    remove(index - 1, head);
  }

  //Recursive remove method. 
  public void remove(int index, Node<T> cur){
    //Remove from front.
    if(index == -1)
    {
      if(cur.next == null)
        head = null;
      else 
        head = cur.next;
      return; 
    }
    //Remove from middle.
    if(index == 0)
    {
      cur.next = cur.next.next;
      return;
    }
    remove(index - 1, cur.next);
  } 

  @Override //Just use a counter within the linked list that takes care of size.
  public int size() {
    return size(head);
  }

  public int size(Node<T> cur){
    if(cur == null)
      return 0; 
    return 1 + size(cur.next);
  } 

  /** Removes ALL elements matching the given one using .equals().
   *
   * @param data The element that should be removed
   */
  public void removeAll(T data) {
    removeAll(head, data, 0); 
  }

  //Recursive remove all method. 
  public void removeAll(Node<T> cur, T data, int index){
    if(cur == null)
      return;
    if(cur.data.equals(data))
    {
      remove(index); 
      index--; 
    }
    removeAll(cur.next, data, index + 1);  
  } 

  /** Gets the 2nd-to-last element.
   *
   * @return The data in the second-to-last node in the list (if any)
   * @throws NoSuchElementException if the list size is less than 2
   */
  public T penultimate() throws NoSuchElementException {
    if(size() < 2)
      throw new NoSuchElementException("List is smaller than 2!");
    return penultimate(size() - 1, head);
  }

  //Recursive penultimate method.
  public T penultimate(int index, Node<T> cur){
    if(index == 1)
      return cur.data;
    return penultimate(index - 1, cur.next);
  } 

  /** Iterates through the list.
   *
   */

}
