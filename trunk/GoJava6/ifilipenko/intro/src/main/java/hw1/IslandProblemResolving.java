package hw1;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * Consider 1 as "Island", 0 as "Water"
 * All vertically, horizontally, diagonally 1s set making one island
 */

public class IslandProblemResolving {
    Queue<Node> q = new LinkedList<>();
    Set<Node> visited = new HashSet<>();

    public int countIslands(int[][] grid) {
        int res = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    Node node = new Node(i, j);
                    if (!visited.contains(node)) {
                        bfs(node, grid, visited);
                        res++;
                    }
                }
            }
        }
        return res;
    }

    void bfs(Node root, int[][] grid, Set<Node> visited) {
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            visited.add(node);
            // get all neighbors
            if (node.i > 0) {
                Node top = new Node(node.i - 1, node.j);
                if (!visited.contains(top) && grid[top.i][top.j] == 1) {
                    nodeAdding(top);
                }
            }
            if (node.i < grid.length - 1) {
                Node bottom = new Node(node.i + 1, node.j);
                if (!visited.contains(bottom) && grid[bottom.i][bottom.j] == 1) {
                    nodeAdding(bottom);
                }
            }
            if (node.j < grid[0].length - 1) {
                Node right = new Node(node.i, node.j + 1);
                if (!visited.contains(right) && grid[right.i][right.j] == 1) {
                    nodeAdding(right);
                }
            }
            if (node.j > 0) {
                Node left = new Node(node.i, node.j - 1);
                if (!visited.contains(left) && grid[left.i][left.j] == 1) {
                    nodeAdding(left);
                }
            }
        }
    }

    private void nodeAdding(Node node) {
        q.add(node);
        visited.add(node);
    }
}
