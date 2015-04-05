package cache;

class DLNode {
    private int key;
    private int value;
    private DLNode next;
    private DLNode prev;

    public DLNode (int key, int value) {
	this.key = key;
	this.value = value;
    }

    public int getValue() {
	return value;
    }

    public int getKey() {
	return key;
    }

    public void setValue (int key, int value) {
	this.key = key;
	this.value = value;
    }
    
    public DLNode getNext() {
	return next;
    }
    
    public void setNext(DLNode n) {
	next = n;
    }
    
    public DLNode getPrev() {
	return prev;
    }
    
    public void setPrev(DLNode n) {
	prev=n;
    }
}
