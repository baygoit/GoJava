package cache;

class DLNode {
    private int key;
    private int value;
    private DLNode next;
    private DLNode prev;

    DLNode(int inputKey, int inputValue) {
	key = inputKey;
	value = inputValue;
    }

    int getValue() {
	return value;
    }

    int getKey() {
	return key;
    }

    void setValue(int inputKey, int inputValue) {
	key = inputKey;
	value = inputValue;
    }
    
    DLNode getNext() {
	return next;
    }
    
    void setNext(DLNode n) {
	next = n;
    }
    
    DLNode getPrev() {
	return prev;
    }
    
    void setPrev(DLNode n) {
	prev = n;
    }
}
