package com.gojava6;

/**
 * Created by Dmitry Onishchenko on 9/15/15.
 * Consider 1 as "Island", 0 as "Water"
 * All vertically, horizontally 1s set making one island
 * @author Dmitry Onishchenko
 */
public class IslandProblemResolving {
	private CountStrategy countStrategy;
	
	/**
	 * Resolving problem using some strategy
	 * @param islandMap
	 */
    public IslandProblemResolving(int[][] islandMap) {
    	countStrategy = new NodePointCountStrategy(islandMap);
    }
    
    /**
     * Execute strategy's counting method
     * @return count
     */
    public int countIslands() {
        return countStrategy.countIslands();
    }

    /**
     * Test main
     * @param args
     */
    public static void main(String[] args) {
		int[][] islandMap = new int[][] {
				{ 1, 1, 0, 0, 1 },
				{ 1, 0, 0, 0, 0 },
				{ 0, 0, 1, 0, 1 },
				{ 1, 0, 0, 1, 1 } };
		
    	IslandProblemResolving islandProblemResolving = new IslandProblemResolving(islandMap);
    	
    	System.out.println(islandProblemResolving.countIslands());
    }
}