package com.gojava6;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class IslandProblemResolving {
    private int[][] islandMap;

    public IslandProblemResolving(int[][] islandMap) {

        this.islandMap = islandMap;
    }

    public int countIslands() {

        Set<Node> visited = new HashSet<>();
        int res = 0;

        for (int i = 0; i < islandMap.length; i++) {
            for (int j = 0; j < islandMap[0].length; j++) {
                if (islandMap[i][j] == 1) {
                    Node node = new Node(i, j);
                    if (!visited.contains(node)) {
                        bfs(node, islandMap, visited);
                        res++;
                    }

                }
            }
        }
        return res;
    }

    void bfs(Node root, int[][] islandMap, Set<Node> visited) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node node = q.poll();
            visited.add(node);
            if (node.i > 0) {
                Node top = new Node(node.i - 1, node.j);
                if (!visited.contains(top) && islandMap[top.i][top.j] == 1) {
                    q.add(top);
                    visited.add(top);
                }
            }

            if (node.i < islandMap.length - 1) {
                Node bottom = new Node(node.i + 1, node.j);
                if (!visited.contains(bottom) && islandMap[bottom.i][bottom.j] == 1) {
                    q.add(bottom);
                    visited.add(bottom);
                }
            }
            if (node.j < islandMap[0].length - 1) {
                Node right = new Node(node.i, node.j + 1);
                if (!visited.contains(right) && islandMap[right.i][right.j] == 1) {
                    q.add(right);
                    visited.add(right);
                }
            }
            if (node.j > 0) {
                Node left = new Node(node.i, node.j - 1);
                if (!visited.contains(left) && islandMap[left.i][left.j] == 1) {
                    q.add(left);
                    visited.add(left);
                }
            }

        }
    }

    static class Node {
        int i, j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public int hashCode() {
            return this.i * 1001 + this.j;
        }

        @Override
        public boolean equals(Object o) {

            if (o == null) {
                return false;
            }
            if (o == this) {
                return true;
            }
            Node node = (Node) o;
            if (this.i == node.i && this.j == node.j) {
                return true;
            }
            return false;
        }

    }
}
