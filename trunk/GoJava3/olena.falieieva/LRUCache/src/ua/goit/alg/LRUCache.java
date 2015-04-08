package ua.goit.alg;

import java.util.HashMap;

public class LRUCache {

	private Node head;
	private Node tail;
	private final int capacity;
	private final HashMap<Integer, Node> map;

	public LRUCache(int capacity) { 
		map = new HashMap<Integer, Node>();
		this.capacity = capacity;
	}

	public void set(int key, int value) {
		if (map.size() == capacity) {
			map.remove(head.key);
			removeHead();
		}
		if (map.containsKey(key)) {
			Node oldNode = map.get(key);
			oldNode.value = value;
			addToTail(oldNode); 
		} else {
			Node newNode = new Node(key,value);
			if (tail != null) {
				appendToTail(newNode);		
			} else {
				head = newNode;
				tail = head;
			}
			map.put(key,newNode);
		}
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node gettedNode = map.get(key);
			addToTail(gettedNode);
			return gettedNode.value;
		} else {
			return -1;
		}
	}

	private void addToTail(Node node) {
		if (node == head) {
			removeHead();
			appendToTail(node);
		}
		if (node != tail) {
			addFromMiddleToTail(node);
		}
	}

	private void removeHead() {
		head = head.next;
		head.prev = null; 
	}

	private void addFromMiddleToTail(Node node) {
		Node prev = node.prev;
		Node next = node.next;
		prev.next = next;
		next.prev = prev;
		appendToTail(node);
	}

	private void appendToTail(Node node) {
		if (tail != null) {
			node.next = null;
			node.prev = tail;
			tail.next = node;
			tail = node;
		} 
	}

	private static class Node {
		int value;
		final int key;
		Node next;
		Node prev;
		public Node(int key,int value) {
			this.value = value;
			this.key = key;
		}
	}
}




