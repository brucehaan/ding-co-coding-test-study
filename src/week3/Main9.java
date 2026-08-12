package week3;

import java.util.*;

public class Main9 {

    public static int[] getPriceNotFallPeriods2(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length - 1; i++) {
            int priceNotFallPeriod = 0;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    priceNotFallPeriod++;
                } else {
                    priceNotFallPeriod++;
                    break;
                }
            }
            answer[i] = priceNotFallPeriod;
        }
        return answer;
    }


    public static Integer[] getPriceNotFallPeriods(int[] prices) {
        List<Integer> answer = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int price : prices) {
            queue.offer(price);
        }

        while(!queue.isEmpty()) {
            int priceNotFallPeriod = 0;
            int currentPrice = queue.poll();

            Queue<Integer> temp = new LinkedList<>(queue);

            for (int nextPrice : temp) {
                if (currentPrice <= nextPrice) {
                    priceNotFallPeriod++;
                } else {
                    priceNotFallPeriod++;
                    break;
                }
            }
            answer.add(priceNotFallPeriod);
        }
        return answer.toArray(Integer[]::new);
    }

    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(getPriceNotFallPeriods(prices)));

        System.out.println("정답 = [4, 3, 1, 1, 0] / 현재 풀이 값 = " + Arrays.toString(getPriceNotFallPeriods(prices)));
        System.out.println("정답 = [6, 2, 1, 3, 2, 1, 0] / 현재 풀이 값 = " + Arrays.toString(getPriceNotFallPeriods(new int[]{3, 9, 9, 3, 5, 7, 2})));
        System.out.println("정답 = [6, 1, 4, 3, 1, 1, 0] / 현재 풀이 값 = " + Arrays.toString(getPriceNotFallPeriods(new int[]{1, 5, 3, 6, 7, 6, 5})));
    }
}