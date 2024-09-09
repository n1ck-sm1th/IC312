public class Tree<T> {

  private class Node {
    public Node left  = null;
    public Node right = null;
    public T data;

    public Node(T d) {
      data=d;
    }
  }

  private Node root = null;

  // constructors, some other methods too...
  //
   public int height() {
    return heightFrom(root);
  }

  private int heightFrom(Node n) {
    if (n == null) return -1;

    int lh = heightFrom(n.left);
    int rh = heightFrom(n.right);

    return Math.max(lh, rh) + 1;
  }
}

preorder(Node n) {
  process(n.data);
  for( Node child : n) //for each child of n
    preorder(c);
}

postorder(Node n) {
  for(Node child : n) //for each child of n
    postorder(cc);
  process(n.data);
}

inorder(Node n) {
  inorder(n.left);
  process(n.data);
  inorder(n.right);
}

levelOrder() {

  //create a queue for the nodes
  nodesQueue = new Queue<Node>();
  nodesQueue.enqueue(root);

  while(nodesQueue.size() > 0){

    n = nodesQueue.dequeue();

    //reached a leaf, nothing to do
    if(n == null): continue

    //process current node and enqueue its children
    process(n.data);
    enqueue(n.left);
    enqueue(n.right);
  }


  public class BST {
  private class Node {
    int key;
    Node left = null;
    Node right = null;

    public Node(int key) { this.key = key; }
  }

  private Node root = null;

  public void insert(int key) { root = insertUnder(root, key); }

  private Node insertUnder(Node uu, int key) {
    if (uu == null) // add a new leaf
      return new Node(key);

    if (key < uu.key) // smaller - go left
      uu.left = insertUnder(uu.left, key);
    else if (key > uu.key) // larger - go right
      uu.right = insertUnder(uu.right, key);
    // Notice no else case. If key == uu.key then there's nothing to do!
    return uu;
  }

  public boolean find(int key) { return findFrom(root, key); }

  private boolean findFrom(Node uu, int needle) {
    if (uu == null) // not found
      return false;
    else if (needle < uu.key) // smaller - go left
      return findFrom(uu.left, needle);
    else if (needle > uu.key) // larger - go right
      return findFrom(uu.right, needle);
    else // needle == uu.key
      return true;
  }
}


public void remove(int key) { root = removeUnder(root, key); }

private Node removeUnder(Node cur, int needle) {
  if (cur == null)
    throw new NoSuchElementException("could not find the needle to remove it");
  else if (needle < cur.key)
    cur.left = removeUnder(cur.left, needle);
  else if (needle > cur.key)
    cur.right = removeUnder(cur.right, needle);
  else { // found it!
    // first check easy cases
    if (cur.left == null)
      return cur.right;
    else if (cur.right == null)
      return cur.left;
    else {
      // hard case: cur.left and cur.right are both not null
      // find the successor and remove it
      int successor = getMin(cur.right);
      cur.key = successor;
      cur.right = removeUnder(cur.right, successor);
    }
  }
  return cur;
}

private int getMin(Node cur) {
  if (cur.left == null)
    return cur.key;
  else
    return getMin(cur.left);
}



