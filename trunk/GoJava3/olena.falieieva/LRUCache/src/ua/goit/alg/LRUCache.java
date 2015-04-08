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

	public void put(int key, int value) {
		if (map.size() == capacity) {
			map.remove(head.key);
			removeHead();
		}

		if (map.containsKey(key)) {
			Node oldNode = map.get(key);
			oldNode.value = value;
			if (oldNode != tail) {
				addFromMiddleToTail(oldNode);
			}
			if (oldNode == head) {
				removeHead();
				appendToTail(oldNode);
			} 
		} else {
			Node newNode = new Node(key,value);
			if (tail != null) {
				appendToTail(newNode);		
			} else {
				head = newNode;
				tail = head;
			}
			map.put(key, newNode);
		}
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			Node gettedNode = map.get(key);
			if (gettedNode == head) {
				removeHead();
				appendToTail(gettedNode);
			}
			if (gettedNode != tail) {
				addFromMiddleToTail(gettedNode);
			}
			return gettedNode.value;
		} else {
			return -1;
		}
	}

	public void cleanCache() {
		map.clear();
	}

	public int getCacheSize() {
		return map.size();
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




