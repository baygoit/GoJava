package com.gojava6;

import java.util.HashSet;
import java.util.Objects;

public class NodePointCountStrategy implements CountStrategy {
	private HashSet<Node> checkedNodes = new HashSet<>();
	private int[][] map;
	private int rows;
	private int cols;
	
	public NodePointCountStrategy(int[][] islandMap) {
		this.map = islandMap;
		this.rows = map.length;
		this.cols = map[0].length;
	}
	
	@Override
	public int countIslands() {
    	int islandCount = 0;
    	
    	for (int i = 0; i < rows; i++) {
    		for (int j = 0; j < cols; j++) {
    			if (map[i][j] == 1) {
    				Node startNode = new Node(i, j);
    				
    				if (addIfNotExist(startNode)) {
    					Node east = getEast(startNode);
    					
    					if (east != null) {
    						checkedNodes.add(east);
    						lookAround(east);
    					}
    					
    					Node south = getSouth(startNode);
    					if (south != null && addIfNotExist(south)) {
    						lookAround(south);
    					}
    					
    					islandCount++;
    				}    				
    			}
    		}    		
    	}

		return islandCount;
	}
	
	private boolean addIfNotExist(Node node) {
		if (!checkedNodes.contains(node)) {
			checkedNodes.add(node);
			return true;
		}
		return false;
	}
	
	private void lookAround(Node sourceNode) {
    	/* North */
    	Node node = getNorth(sourceNode);
    	if (node != null && addIfNotExist(node)) {
    		lookAround(node);
    	}
    	
    	/* East */
    	node = getEast(sourceNode);
    	if (node != null && addIfNotExist(node)) {
    		lookAround(node);
    	}
    	
    	/* South */
    	node = getSouth(sourceNode);
    	if (node != null && addIfNotExist(node)) {
    		lookAround(node);
    	}
    	
    	/* West */
    	node = getWest(sourceNode);
    	if (node != null && addIfNotExist(node)) {
    		lookAround(node);
    	}
    }
	
	/**
	 * North node from source node's position
	 * @param node - source node
	 * @return north node or null if not exist
	 */
	private Node getNorth(Node node) {
		int row = node.row - 1;
		if (row < 0) return null;
		if (!isIsland(row, node.col)) {
			return null;
		}
		
		return new Node(row, node.col);
	}
	
	/**
	 * East node from source node's position
	 * @param node - source node
	 * @return east node or null if not exist
	 */
	private Node getEast(Node node) {
		int col = node.col + 1;
		if (col >= cols) return null;
		if (!isIsland(node.row, col)) {
			return null;
		}
		
		return new Node(node.row, col);
	}
	
	/**
	 * South node from source node's position
	 * @param node - source node
	 * @return south node or null if not exist
	 */
	private Node getSouth(Node node) {
		int row = node.row + 1;
		if (row >= rows) return null;
		if (!isIsland(row, node.col)) {
			return null;
		}
		
		return new Node(row, node.col);
	}
	
	/**
	 * West node from source node's position
	 * @param node - source node
	 * @return west node or null if not exist
	 */
	private Node getWest(Node node) {
		int col = node.col - 1;
		if (col < 0) return null;
		if (!isIsland(node.row, col)) {
			return null;
		}
		
		return new Node(node.row, col);
	}
	
	/**
	 * Consider 1 as "Island"
	 * @param row
	 * @param col
	 * @return true if the "Island" otherwise false
	 */
	private boolean isIsland(int row, int col) {
		return map[row][col] == 1;
	}
	
	/**
	 * Created by Dmitry Onishchenko on 9/15/15.
	 * Node class for {@link NodePointCountStrategy}
	 * @author Dmitry Onishchenko
	 */
	private class Node {
		public int row;
		public int col;
		
		public Node(int row, int col) {
			this.row = row;
			this.col = col;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (obj == null) return false;
			if (obj == this) return true;
			if (!(obj instanceof Node)) return false;
			
			Node other = (Node) obj;
			return row == other.row && col == other.col;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(row, col);
		}
		
		@Override
		public String toString() {
			return "Node[" + row + "," + col + "]";
		}
	}
}
