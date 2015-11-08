package ua.goit.alg.LRUCache;

public class Node {

  private Node next = null;
  private Node previous = null;
  private int value = 0;
  private int key = 0;

  public Node(int value){
    this.value = value;
  }

  public void setNext(Node next){
    this.next = next;
  }

  public void setPrevious(Node previous){
    this.previous = previous;
  }

  public Node getNext(){
    return next;
  }

  public Node getPrevious(){
    return previous;
  }

  public int getValue(){
    return value;
  }

  public int getKey(){
    return key;
  }

  public void setKey(int key){
    this.key = key;
  }
}
