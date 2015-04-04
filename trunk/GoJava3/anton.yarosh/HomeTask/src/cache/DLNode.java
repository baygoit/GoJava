package cache;

public class DLNode <Integer, V> implements Container<V>{
    private int key;
    private V value;

    public V getValue() {
	return value;
    }

    public int getKey() {
	return key;
    }

    public void setValue (int key, V value) {
	this.key = key;
	this.value = value;
    }
    private DLNode<Integer, V> next, prev;

    public DLNode<Integer, V> getNext() {
	return next;
    }
    public void setNext(DLNode<Integer, V> n) {
	next = n;
    }
    public DLNode<Integer, V> getPrev() {
	return prev;
    }
    public void setPrev(DLNode<Integer, V> n) {
	prev=n;
    }

    public DLNode (int key, V value) {
	this.key = key;
	this.value = value;
    }
}
