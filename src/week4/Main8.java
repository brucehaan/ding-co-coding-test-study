package week4;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Collections;

// heap에다가 넣어둔 다음에 최고로 많은 재고들을 꺼내서 stock에 추가해주면 될것.
// 현재 재고가 바닥나는 시점 이전까지
public class Main8 {

    public static int getMinimumCountOfOverseasSupply(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int lastAddedDateIndex = 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        while (stock <= k) { // stock이 k보다 크게 되면 멈출 것이다
            while (lastAddedDateIndex < dates.length && dates[lastAddedDateIndex] <= stock) {
                maxHeap.offer(supplies[lastAddedDateIndex]);
                lastAddedDateIndex++;
            }
            answer++;
            int supply = maxHeap.poll();
            stock += supply;
        }
        return answer;
    }

    public static void main(String[] args) {
        int ramenStock = 4;
        int[] supplyDates = {4, 10, 15};
        int[] supplySupplies = {20, 5, 10};
        int supplyRecoverK = 30;

        System.out.println(getMinimumCountOfOverseasSupply(ramenStock, supplyDates, supplySupplies, supplyRecoverK));
        System.out.println("정답 = 2 / 현재 풀이 값 = " + getMinimumCountOfOverseasSupply(4, new int[]{4, 10, 15}, new int[]{20, 5, 10}, 30));
        System.out.println("정답 = 4 / 현재 풀이 값 = " + getMinimumCountOfOverseasSupply(4, new int[]{4, 10, 15, 20}, new int[]{20, 5, 10, 5}, 40));
        System.out.println("정답 = 1 / 현재 풀이 값 = " + getMinimumCountOfOverseasSupply(2, new int[]{1, 10}, new int[]{10, 100}, 11));
    }
}