package week4;

import java.util.HashMap;
import java.util.Map;

public class Main7 {

    public static long fiboDynamicProgramming(int n, Map<Integer, Long> fiboMemo) {
        if (fiboMemo.containsKey(n))
            return fiboMemo.get(n);
        long nthFibo = fiboDynamicProgramming(n - 1, fiboMemo) + fiboDynamicProgramming(n - 2, fiboMemo);
        fiboMemo.put(n, nthFibo);
        return nthFibo;
    }

    public static void main(String[] args) {
        int input = 50;
        // memo 라는 변수에 Fibo(1)과 Fibo(2) 값을 저장해놨습니다!
        Map<Integer, Long> memo = new HashMap<>();
        memo.put(1, 1L);
        memo.put(2, 1L);

        System.out.println(fiboDynamicProgramming(input, memo));
    }
}