package week4;

import java.sql.Array;
import java.util.*;

public class Main4 {

    public static List<Integer> dfsStack(Map<Integer, List<Integer>> adjacentGraph, int startNode) {
        Stack<Integer> stack = new Stack<>();
        stack.push(startNode);
        List<Integer> visited = new ArrayList<>();
        while (!stack.empty()) {
            int currentNode = stack.pop();
            visited.add(currentNode);
            for (Integer integer : adjacentGraph.get(currentNode)) {
                if (!visited.contains(integer)) {
                    stack.push(integer);
                }
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, List.of(2, 5, 9));
        graph.put(2, List.of(1, 3));
        graph.put(3, List.of(2, 4));
        graph.put(4, List.of(3));
        graph.put(5, List.of(1, 6, 8));
        graph.put(6, List.of(5, 7));
        graph.put(7, List.of(6));
        graph.put(8, List.of(5));
        graph.put(9, List.of(1, 10));
        graph.put(10, List.of(9));

        System.out.println(dfsStack(graph, 1)); // 1 이 시작노드입니다!
        // [1, 9, 10, 5, 8, 6, 7, 2, 3, 4] 이 출력되어야 합니다!
    }
}
