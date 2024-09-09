public class LinkedListOfString {
    private class Node{
      String data;
      Node next;
    }

    Node head = null;

    int size() {/*---*/}
    String get(int i) {/*---*/}
    void set(int i, String e) {/*---*/}
    void add(int i, String e) {/*---*/}
    String remove(int i) {/*---*/}
}





public class LinkedListOfObject {
    private class Node{
      Object data;
      Node next;
    }

    Node head = null;

    int size() {/*---*/}
    Object get(int i) {/*---*/}
    void set(int i, Object e) {/*---*/}
    void add(int i, Object e) {/*---*/}
    Object remove(int i) {/*---*/}
}


LinkedListOfObject lst = new LinkedListOfObject();

lst.add(0, "Bob");
lst.add(1, "Barker");

if (lst.get(0).charAt(0) == lst.get(1).charAt(0)) {
  System.out.println("Both first letters are the same.");


if (((String)lst.get(0)).charAt(0) == ((String)lst.get(1)).charAt(0)) //...


lst.add(1, 17); // 17 is not a String!

public class LinkedList<T> {
    private class Node{
      T data;
      Node next;
    }

    Node head = null;

    int size() {/*---*/}
    T get(int i) {/*---*/}
    void set(int i, T e) {/*---*/}
    void add(int i, T e) {/*---*/}
    T remove(int i) {/*---*/}
}

for(int i=0; i<lst.size(); i++) {
  lst.get(i);
}

//return true if the iteration has more elements    
boolean hasNext();

//Returns the next element in the iteration
E next();

import java.lang.Iterable;
import java.util.Iterator;

//now implements Iterable
public class LinkedList<T> implements Iterable<T> {

  private class Node{
    T data;
    Node next;
  }

  Node head = null;

  int size() {/*---*/}
  T get(int i) {/*---*/}
  void set(int i, T e) {/*---*/}
  void add(int i, T e) {/*---*/}
  T remove(int i) {/*---*/}

  // Iterable interfaces require that you can return an Iterator
  @Override
  public Iterator<T> iterator(){
      return new LLIteartor(head);
  }

  // the Iterator we will return
  private class LLIterator implements Iterator<T> {
    private Node cur;

    public LLIterator(Node start) { cur = start; }

    public boolean hasNext() { return cur != null; }

    public T next() {
      T data = cur.data;
      cur = cur.next;
      return data;
    }

    // this is part of the java.util.Iterator interface but optional
    public void remove() { throw new UnsupportedOperationException();}
  }
}

LinkedList<String> lst = new LinkedList<>();
lst.add(0, "Go Navy!");
lst.add(1, "Beat Army!");

//foreach iteration, assign s to each element in lst using the Iterator methods
for(String s : lst) {
  System.out.println(s); //prints "Go Navy!", then "Beat Army!"
}


public class LinkedList<T> implements List<T>, Iterable<T> {
    private class Node {
        T data;
        Node next;
    }

    Node head = null;
    int length = 0;

    public int size() { return length; }

    public void add(int i, T e) {
        /* modify the actual list ... */
        length += 1;
    }

    public T remove(int i) {
        /* modify the actual list... */
        length -= 1;
    }

    public T get(int i) {/*---*/}
    public void set(int i, T e) {/*---*/}
    public Iterator<T> iterator() {/*...*/}
}

public class CircularArrayList<T> implements List<T> {

 private int head=0;
 private T elements[];

 //..
}


