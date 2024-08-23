//Nicholas Smith (Help from Iker Perez Calderon, specifically on how to think
//about the shifting problems like add and remove)
//265904

/** A List implementation with fixed, bounded capacity.
 *
 * When an instance of this class is constructed, the chosen capacity
 * represents the maximum size the list can ever grow to.
 */
public class BoundedList<T> implements List<T> {
  private T[] elements;//Elements is what the data is stored in. 
  
  // TODO you might want another private field...
  //Additional private field to ensure we know the capcity.
  private int capacity;
  
  //For testing purposes. 
  public static void main(String[] args){
    
    List<Integer> lst = new BoundedList<Integer>(5); //list with a capacity of 3
    //When making the constructor for a Bounded list it goes ListType<Type it
    //contains> (Size) <- This is within the constructor.

    lst.add(0, 1);   // [ 1 ] Goes into the overridden list method in this class to add to the bounded list.
    lst.add(0, 2);   // [ 2 1 ]
    lst.add(1, 3);   // [ 2 3 1 ]
    //lst.add(4, 4);   // IndexOutOfBoundsException -- adding more than +1 the current size
    //lst.add(5, 5);   // IndexOutOfBoundsException -- outside the bounds of the fixedList at size 5
    //lst.add(-1, -1); // IndexOutOfBoundsException -- negative index
    lst.add(3, 4);   // [ 2 3 1 4 ]
    lst.add(0, 5);   // [ 5 2 3 1 4 ]
    //lst.add(0, 6);   // IllegalStateException -- list is full
    System.out.println(lst); 

  }

  /** Create a new BoundedList with the given maximum capacity.
   */
  public BoundedList(int capacity) {
    @SuppressWarnings("unchecked")
    T[] elements = (T[]) new Object[capacity];
    this.elements = elements;
    this.capacity = capacity;
  }

  //Retrives the element at a particular index.
  @Override
  public T get(int index) throws IndexOutOfBoundsException {
    if(index < 0 || index > size()-1)  //Out of bounds testing.
      throw new IndexOutOfBoundsException("Index!");
    return elements[index]; //Goes into the elements array and retrives index. 
  }

  //Changes a particular indexed element in the code.
  @Override
  public void set(int index, T data) throws IndexOutOfBoundsException {
    if(index < 0 || index > size()-1)
      throw new IndexOutOfBoundsException("Index!");
    elements[index] = data;
  }

  //Adds a new element to the list, while keeping everything properly sorted and
  //sized. 
  @Override
  public void add(int index, T data) throws IndexOutOfBoundsException, IllegalStateException {
    if(index < 0 || index > size())
      throw new IndexOutOfBoundsException("Index!"); //Ensuring we are in bounds. 
    if (size() == capacity)
      throw new IllegalStateException("Full"); //Size returns how many elements are in the list.
    if(elements[index] == null)
      elements[index] = data; //Automatic insertion.
    else 
    {  
      for(int a = size(); a > index ; a--)
      {    
        elements[a] = elements[a-1];
      }
        elements[index] = data;
    }
  }

  //Removes an element from the list. 
  @Override
  public void remove(int index) throws IndexOutOfBoundsException {
   if(index < 0 || index > size())
      throw new IndexOutOfBoundsException("Index!");
    else //Shifting method.  
    {  
      for(int a = index; a < size() - 1 ; a++)
      {    
        elements[a] = elements[a+1];
      }
        elements[size()-1] = null; //Make the end part null to avoid duplicates. 
    }
  }

  //Returns the number of elements in the list. 
  @Override
  public int size() {
    int s = 0;  
    for(T x: elements){
      if(x != null)
        s++; //Count for every non null element. 
    }
    return s; 
  }

  @Override
  // this produces a string like "[ 1 2 3 4 ]"
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("[ ");
    for (int i = 0; i < size(); ++i) {
      sb.append(get(i).toString());
      sb.append(' ');
    }
    sb.append(']');
    return sb.toString();
  }
}
