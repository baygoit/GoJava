package ua.goit.alg;
import java.util.HashMap;


public class LRUCache {

	private Node head;
	private Node tail;
	public int capacity;

	HashMap<Integer, Node> map = new HashMap<Integer, Node>();

	public LRUCache(int capacity) { 
		this.capacity = capacity;
	}

	public void put(int key, int value){

		if (map.size() == capacity) {
			map.remove(head.key);
			removeHead();
		}

		Node newNode = new Node(key,value);
		if(!map.containsKey(key)){
			if (tail!=null){
				appendToTail(newNode);		
			} else {
				head = newNode;
				tail = head;
			};

		} else {
			Node oldNode = map.get(key);
			oldNode.value = value;
			if (oldNode != tail){
				addFromMiddleToTail(oldNode);
			}
			if (oldNode == head) {
				removeHead();
				appendToTail(oldNode);
			} 

			oldNode.value = value;
		}
		map.put(key, newNode);
	}

	public int get(int key) {
		if(map.containsKey(key)) {
			Node getted = map.get(key);
			if (getted == head){
				removeHead();
				appendToTail(getted);
			}
			if (getted !=tail) {
				addFromMiddleToTail(getted);
			}
			return tail.value;
		} else {
			return -1;
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
		int key;
		Node next;
		Node prev;
		public Node(int key,int value){
			this.value = value;
			this.key = key;
		}
	}

	
}




