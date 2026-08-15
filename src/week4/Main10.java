package week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main10 {

    static HashMap<Integer, Integer> memo = new HashMap<>(Map.of(
            1, 1,
            2, 2
    ));

    public static int getAllWaysOfTheaterSeat(int totalCount, int[] fixedSeatArray) {
        int answer = 1;
        int currentIndex = 0;
        int countOfWays = 0;
        for (int fixedSeat : fixedSeatArray) {
            int fixedSeatIndex = fixedSeat - 1;
            countOfWays = fiboDynamicProgramming(fixedSeatIndex - currentIndex, memo);
            answer *= countOfWays;
            currentIndex = fixedSeatIndex + 1;
        }
        countOfWays = fiboDynamicProgramming(totalCount - currentIndex, memo);
        answer *= countOfWays;
        return answer;
    }

    public static void main(String[] args) {
        int seatCount = 9;
        int[] vipSeatArray = {4, 7};

        // 12가 출력되어야 합니다!
        System.out.println(getAllWaysOfTheaterSeat(seatCount, vipSeatArray));
    }

    private static int fiboDynamicProgramming(int n, HashMap<Integer, Integer> fiboMemo) {
        if (fiboMemo.containsKey(n)) return fiboMemo.get(n);

        int nthFibo = fiboDynamicProgramming(n - 1, fiboMemo) + fiboDynamicProgramming(n - 2, fiboMemo);
        fiboMemo.put(n, nthFibo);
        return nthFibo;
    }
}
