// Nicholas Smith
// ANY SOURCES OR COLLABORATION YOU USED HERE

import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
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

  /**
   * Main method
   */
  public static void main(String[] args){
    LinkedList<Integer> list = new LinkedList<>();
    System.out.println(list.size());
  }  

  
  private Node<Integer> head;  

  @Override
  public T get(int index) throws IndexOutOfBoundsException {
    return get(index, head);
  }

  public T get(int index, Node head){
    //Use traverse to get to the place, then index it.
    if(index < 0 || index > size()-1)  //Out of bounds testing.
      throw new IndexOutOfBoundsException("Index!");
    return elements[index]; //Goes into the elements array and retrives index. 
  }

  @Override
  public void set(int index, T data) throws IndexOutOfBoundsException {
    return set(index, head);
  }

  public void set(int index, Node head){
    if(index < 0 || index > size()-1)
      throw new IndexOutOfBoundsException("Index!");
     elements[index] = data;
  } 

  @Override
  public void add(int index, T data) throws IndexOutOfBoundsException {
   add(index, head);
  }

  public void add(int index, Node head){
    if(index < 0 || index > size())
      throw new IndexOutOfBoundsException("Index!"); //Ensuring we are in bounds. 
    if (size() == capacity)
      throw new IllegalStateException("Full"); //Size returns how many elements are in the list.
    if(elements[index] == null)
      elements[index] = data; //Automatic insertion.
    else 
    {
      //Make recursive call.
      for(int a = size(); a > index ; a--)
      {    
        elements[a] = elements[a-1];
      }
        elements[index] = data;
    } 
  }

  @Override
  public void remove(int index) throws IndexOutOfBoundsException {
   remove(index, head);
  }

  public void remove(int index, Node<T> Head){
    if(index < 0 || index > size())
      throw new IndexOutOfBoundsException("Index!");
    if  
    else //Shifting method.  
    {  
      //Make recursive call
      remove(index-1, 
      for(int a = index; a < size() - 1 ; a++)
      {    
        elements[a] = elements[a+1];
      }
        elements[size()-1] = null; //Make the end part null to avoid duplicates. 
    } 
  } 

  @Override
  public int size() {
    size(head);//Helper method for size. 
    return 0;
  }

  private int size(Node<T> cur){
    if(cur == null)
      return 0;
    return 1+ size(cur.next);
  } 

  public void traverse() {
    traverse(head);
  }

  public void traverse(Node<T> cur) {
    if (cur == null)
      return;
    //... perform some action on cur
    traverse(cur.next);
  }


  /** Removes ALL elements matching the given one using .equals().
   *
   * @param element The element that should be removed
   */
  public void removeAll(T element) {
    throw new UnsupportedOperationException(); // TODO erase this and get it working
  }

  /** Gets the 2nd-to-last element.
   *
   * @return The data in the second-to-last node in the list (if any)
   * @throws NoSuchElementException if the list size is less than 2
   */
  public T penultimate() throws NoSuchElementException {
    throw new UnsupportedOperationException(); // TODO erase this and get it working
  }
}
