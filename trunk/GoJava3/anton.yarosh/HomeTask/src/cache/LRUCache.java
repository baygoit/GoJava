package cache;

import java.util.HashMap;

public class LRUCache {
    private HashMap<Integer, DLNode> map = new HashMap<Integer, DLNode>();
    private DLNode head;
    private DLNode tail;
    private int capacity;
    private int size;

    public LRUCache(int capacity) {      
	this.capacity = capacity;
    }

    public int get(int key) {
	if (map.containsKey(key)) {
	    DLNode lastUsed = map.get(key);
	    removeNode(lastUsed);
	    setNodeToTail(lastUsed);
	    return lastUsed.getValue();
	} else {
	    return -1;
	}
    }

    public void set(int key, int value) {
	if (map.containsKey(key)) {
	    DLNode lastUsedNode = map.get(key);
	    lastUsedNode.setValue(key, value);
	    removeNode(lastUsedNode);
	    setNodeToTail(lastUsedNode);
	} else {
	    DLNode lastUsedNode = new DLNode(key, value);
	    if (size < capacity) {
		lastUsedNode.setValue(key, value);
		setNodeToTail(lastUsedNode);
		map.put(key, lastUsedNode);
		size++;
	    } else {
		map.remove(head.getKey());
		removeNode(head);
		setNodeToTail(lastUsedNode);
	    }
	}
    }

    private void removeNode(DLNode lastUsedNode) {
	DLNode prevNode = lastUsedNode.getPrev();
	DLNode nextNode = lastUsedNode.getNext();
	if (prevNode == null) {
	    head = nextNode;
	} else {
	    prevNode.setNext(nextNode);
	}

	if (nextNode == null) {
	    tail = prevNode;	    
	} else {
	    nextNode.setPrev(prevNode);
	}
    }

    private void setNodeToTail(DLNode lastUsedNode) {
	if (tail == null) {
	    tail = lastUsedNode;
	} else {
	    DLNode oldTail = tail;
	    tail = lastUsedNode;
	    oldTail.setNext(tail);
	    tail.setPrev(oldTail);
	    if (head == null) {
		head = oldTail;
	    }
	}
    }
}