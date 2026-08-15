package week4;

import java.util.*;

public class Main5 {

    public static List<Integer> bfsQueue2(Map<Integer, List<Integer>> adjGraph, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        List<Integer> visited = new ArrayList<>();

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            visited.add(currentNode);
            for (Integer integer : adjGraph.get(currentNode)) {
                if (!visited.contains(integer)) {
                    queue.add(integer);
                }
            }
        }
        return visited;
    }

    public static List<Integer> bfsQueue(Map<Integer, List<Integer>> adjGraph, int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        List<Integer> visited = new ArrayList<>();
        Set<Integer> queued = new HashSet<>(); // 큐에 추가된 노드를 추적
        queued.add(startNode);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            visited.add(currentNode);

            for (Integer i : adjGraph.get(currentNode)) {
                if (!visited.contains(i) && !queued.contains(i)) {
                    queue.offer(i);
                    queued.add(i);
                }
            }
        }
        return visited;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(1, List.of(2, 3, 4));
        graph.put(2, List.of(1, 5));
        graph.put(3, List.of(1, 6, 7));
        graph.put(4, List.of(1, 8));
        graph.put(5, List.of(2, 9));
        graph.put(6, List.of(3, 10));
        graph.put(7, List.of(3));
        graph.put(8, List.of(4));
        graph.put(9, List.of(5));
        graph.put(10, List.of(6));

        System.out.println(bfsQueue(graph, 1)); // 1 이 시작노드입니다!
        // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] 이 출력되어야 합니다!
    }
}