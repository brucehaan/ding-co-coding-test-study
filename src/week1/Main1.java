package week1;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main1 {

    public static int findMaxNum(int[] array) {  // 이 부분을 채워보세요!
        int max = 0;
        for (int j : array) {
            if (j > max) max = j;
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 5, 6, 1, 2, 4};
        int[] arr2 = {6, 6, 6};
        int[] arr3 = {6, 9, 2, 7, 1888};
        int[] arr4 = {3, 5, 6, 1, 2, 4, 3, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2,
                43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5,
                6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2,
                43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5,
                6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 43, 5, 6, 1, 2, 4};

        System.out.println("정답 = 6 / 현재 풀이 값 = " + findMaxNum(arr1));
        System.out.println("정답 = 6 / 현재 풀이 값 = " + findMaxNum(arr2));
        System.out.println("정답 = 1888 / 현재 풀이 값 = " + findMaxNum(arr3));
        System.out.println("정답 = 43 / 현재 풀이 값 = " + findMaxNum(arr4));
    }
}
