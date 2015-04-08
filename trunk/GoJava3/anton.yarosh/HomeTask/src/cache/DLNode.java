package cache;

class DLNode {
    private int key;
    private int value;
    private DLNode next;
    private DLNode prev;

    public DLNode (int inputKey, int inputValue) {
	key = inputKey;
	value = inputValue;
    }

    public int getValue() {
	return value;
    }

    public int getKey() {
	return key;
    }

    public void setValue(int inputKey, int inputValue) {
	key = inputKey;
	value = inputValue;
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
	prev = n;
    }
}
