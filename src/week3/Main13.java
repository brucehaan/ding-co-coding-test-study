package week3;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main13 {

    public static int getMaxDiscountedPrice(Integer[] prices, Integer[] coupons) {
        Arrays.sort(prices, Collections.reverseOrder());
        Arrays.sort(coupons, Collections.reverseOrder());

        int pricesIdx = 0, couponsIdx = 0;
        int answer = 0;

        while (pricesIdx < prices.length && couponsIdx < coupons.length) {
            int discounted = prices[pricesIdx] * (100 - coupons[couponsIdx]) / 100;
            answer += discounted;
            pricesIdx++;
            couponsIdx++;
        }

        while (pricesIdx < prices.length) {
            answer += prices[pricesIdx];
            pricesIdx++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println("정답 = 926000 / 현재 풀이 값 = " + getMaxDiscountedPrice(new Integer[]{30000, 2000, 1500000}, new Integer[]{20, 40}));
        System.out.println("정답 = 485000 / 현재 풀이 값 = " + getMaxDiscountedPrice(new Integer[]{50000, 1500000}, new Integer[]{10, 70, 30, 20}));
        System.out.println("정답 = 1550000 / 현재 풀이 값 = " + getMaxDiscountedPrice(new Integer[]{50000, 1500000}, new Integer[]{}));
        System.out.println("정답 = 1458000 / 현재 풀이 값 = " + getMaxDiscountedPrice(new Integer[]{20000, 100000, 1500000}, new Integer[]{10, 10, 10}));
    }
}