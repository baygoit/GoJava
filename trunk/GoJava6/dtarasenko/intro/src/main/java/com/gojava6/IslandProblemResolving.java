package java.com.gojava6;

/**
 * Created by sergiigetman on 8/25/15.
 * Consider 1 as "Island", 0 as "Water"
 * All vertically, horizontally, diagonally 1s set making one island
 */
public class IslandProblemResolving {

    private int[][] islandMap;

    public IslandProblemResolving(int[][] islandMap) {
        this.islandMap = islandMap;
    }

    public int countIslands() {
        int[][] map = this.islandMap;
        int count = 0;

        for (int i = 0; i < map.length - 1; i++) {
            for (int k = 0; k < map[i].length - 1; k++) {
                if (map[i][k] == 0) {
                }
                    else {
                    if (map[i][k] == map[i][k + 1]) {
                        count++;
                    }
                    if (map[i][k] == map[i + 1][k]) {
                        count++;
                    }
                    if (map[i][k] == map[i + 1][k + 1]) {
                        count++;
                    }
                }
                if ((k == map[i].length - 2) && (map[i][k + 1] == 1) &&
                        (map[i][k + 1] == map[i + 1][k + 1])) {
                    count++;
                }
                if ((i == map.length - 2) && (map[i + 1][k] == 1) &&
                        (map[i + 1][k] == map[i + 1][k + 1])) {
                    count++;
                }
            }
        }
        return count;
    }
}
