package week3;

import java.util.Arrays;
import java.util.Stack;

public class Main7 {

    public static int[] getReceiverTopOrdersArray(int[] heights) {
        int len = heights.length;
        int[] answer = new int[len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                int standard = heights[i];
                int temp = heights[j];
                if (temp > standard) {
                    answer[i] = j + 1;
                    break;
                }
            }
        }

        return answer;
    }

    public static int[] getReceiverTopOrders(int[] heights) {
        int len = heights.length;
        int[] answer = new int[len];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < len; i++) {
            stack.push(heights[i]);
        }
        while (!stack.empty()) {
            int top = stack.pop();
            int current = stack.size();
            for (int i = current; i >= 0; i--) {
                if (top < heights[i]) {
                    answer[current] = i + 1;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] topHeights = {6, 9, 5, 7, 4};
        System.out.println(Arrays.toString(getReceiverTopOrders(topHeights))); // [0, 0, 2, 2, 4] 가 반환되어야 한다!

        System.out.println("정답 = [0, 0, 2, 2, 4] / 현재 풀이 값 = " + Arrays.toString(getReceiverTopOrders(new int[]{6, 9, 5, 7, 4})));
        System.out.println("정답 = [0, 0, 0, 3, 3, 3, 6] / 현재 풀이 값 = " + Arrays.toString(getReceiverTopOrders(new int[]{3, 9, 9, 3, 5, 7, 2})));
        System.out.println("정답 = [0, 0, 2, 0, 0, 5, 6] / 현재 풀이 값 = " + Arrays.toString(getReceiverTopOrders(new int[]{1, 5, 3, 6, 7, 6, 5})));
    }
}