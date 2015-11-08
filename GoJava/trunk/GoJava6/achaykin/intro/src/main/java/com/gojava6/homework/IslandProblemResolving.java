package com.gojava6.homework;

import java.util.Random;

public class IslandProblemResolving {

    private int[][] map;
    private Boolean[][] existMap;


    public IslandProblemResolving() {
        createRandomMap();
    }

    public IslandProblemResolving(int[][] map) {
        this.map = map;
    }

    public int[][] createRandomMap() {
        int[][] result = new int[6][6];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                result[i][j] = new Random().nextInt(2);
            }
        }
        return result;
    }

    public void createBooleanMap(int[][] actualMap) {

        for (int i = 0; i < actualMap.length; i++) {
            for (int j = 0; j < actualMap[i].length; j++) {
                existMap = new Boolean[actualMap.length][actualMap[i].length];
            }
        }

        for (int i = 0; i < actualMap.length; i++) {
            for (int j = 0; j < actualMap[i].length; j++) {
                existMap[i][j] = false;
            }
        }
    }

    public void printMap(int[][] map) {
        System.out.println("We have such map:");

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void searchIslands(int[][] map, int xAbscissa, int yOrdinatus, Boolean[][] existDryLand) {

        if (map == null && !existDryLand[xAbscissa][yOrdinatus]) {
            return;
        } else if (xAbscissa < 0 || xAbscissa >= map.length || yOrdinatus < 0 || yOrdinatus >= map[xAbscissa].length) {
            return;
        } else if (!existDryLand[xAbscissa][yOrdinatus] && map[xAbscissa][yOrdinatus] == 1) {
            existDryLand[xAbscissa][yOrdinatus] = true;

            searchIslands(map, xAbscissa - 1, yOrdinatus, existDryLand);
            searchIslands(map, xAbscissa + 1, yOrdinatus, existDryLand);
            searchIslands(map, xAbscissa, yOrdinatus - 1, existDryLand);
            searchIslands(map, xAbscissa, yOrdinatus + 1, existDryLand);
        }
    }

    public int countIslands() {
        int count = 0;

        createBooleanMap(map);

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1 && !existMap[i][j]) {
                    searchIslands(map, i, j, existMap);
                    count++;
                }
            }
        }
        return count;
    }

    public void printAmountOfIslands(int number) {
        System.out.println("On our map located " + number + " islands.");
    }


    public static void main(String[] args) {

        int[][] map = new IslandProblemResolving().createRandomMap();

        IslandProblemResolving islands = new IslandProblemResolving(map);

        islands.printMap(map);

        islands.printAmountOfIslands(islands.countIslands());

    }

}
