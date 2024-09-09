int fac(int n) {
  if (n == 0)
    return 1;
  else
    return n * fac(n-1);
}

public class LinkedList {

  private class Node {
    int data;
    Node next;

    Node(int data, Node next) {
      this.data = data;
      this.next = next;
    }
  }

  private Node head; // first Node in the list

  //... remaining methods
}

void traverse() {
  Node cur = head;
  while (cur != null) {
    //... perform some action on cur
    cur = cur.next;
  }
}

void traverse() {
  traverse(head);
}

void traverse(Node cur) {
  if (cur == null)
    return;
  //... perform some action on cur
  traverse(cur.next);
}

int length(Node cur) {
  if (cur == null)
    // length of an empty list is zero
    return 0;
  // length of a non-empty list is one more than the length when you
  // chop off the head
  return 1 + length(cur.next);
}

public void addInOrder(int element) {
  head = addInOrder(head, element);
}

//This is a helper method, so our user doesn't have to know or care
//about nodes.
private Node addInOrder(Node cur, int element) {
  if (cur == null) {
    // we've reached the end of the list, so make a new tail
    tail = new Node(element, null);
    return tail;
  } else if (element < cur.data) {
    // the new element comes before the current node, so insert it here.
    // Note that this constructor sets the "next" of the new node to "cur".
    return new Node(element, cur);
  } else {
    // otherwise the new element comes after cur, so use recursion!
    cur.next = addInOrder(cur.next, element);
    return cur;
  }
}


void traverse_reverse_iter() {
  Node stop = null;
  while (stop != head) {
    Node cur = head;
    while (cur.next != stop)
      cur = cur.next;
    //... perform some action on cur
    stop = cur;
  }
}


void traverse_reverse_rec(Node cur) {
  if (cur == null)
    return;
  traverse_reverse_rec(cur.next);
  //... perform some action on cur
}


void traverse(Node node) {
  if (node == null) //base case
    return;

  //... perform some action on node

  traverse(node.next) //recursive case
}


int sum(int n) {
   if(n==0) return 0;
   else return n+sum(n-1);
}


