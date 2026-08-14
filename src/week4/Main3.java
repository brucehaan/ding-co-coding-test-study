package week4;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main3 {

    public static void dfsRecursion(Map<Integer, List<Integer>> adjacentGraph, int curNode, List<Integer> visitedArray) {
        visitedArray.add(curNode);
        for (Integer integer : adjacentGraph.get(curNode)) {
            if (!visitedArray.contains(integer)) {
                dfsRecursion(adjacentGraph, integer, visitedArray);
            }
        }
        return;
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

        List<Integer> visited = new ArrayList<>();
        dfsRecursion(graph, 1, visited); // 1 이 시작노드입니다!
        System.out.println(visited); // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10] 이 출력되어야 합니다!
    }
}
