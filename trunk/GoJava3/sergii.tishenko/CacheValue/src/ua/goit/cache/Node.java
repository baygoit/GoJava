package ua.goit.cache;

public class Node {
  Node prevNode;
  Node nextNode;

  int value;
  int key;

  public Node(int key, int value, Node nextNode, Node prevNode) {
    super();
    this.prevNode = prevNode;
    this.nextNode = nextNode;
    this.value = value;
    this.key = key;
  }

  public int getKey() {
    return key;
  }

  public void setKey(int key) {
    this.key = key;
  }

  public Node(int key, int value) {
    super();
    this.prevNode = null;
    this.nextNode = null;
    this.value = value;
    this.key = key;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + value;
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Node other = (Node) obj;
    if (value != other.value)
      return false;
    return true;
  }

  public Node getPrevNode() {
    return prevNode;
  }

  public void setPrevNode(Node prevNode) {
    this.prevNode = prevNode;
  }

  public Node getNextNode() {
    return nextNode;
  }

  public void setNextNode(Node nextNode) {
    this.nextNode = nextNode;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }

}
