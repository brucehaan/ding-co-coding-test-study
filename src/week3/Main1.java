package week3;

import java.util.Arrays;

public class Main1 {

    public static int[] bubbleSort(int[] array) {
       for (int i = 0; i < array.length; i++) {
           for (int j = i + 1; j < array.length; j++) {
               if (array[i] > array[j]) {
                   int temp = array[i];
                   array[i] = array[j];
                   array[j] = temp;
               }
           }
       }
        return array;
    }

    public static void main(String[] args) {
        int[] input = {4, 6, 2, 9, 1};
        bubbleSort(input);
        System.out.println(Arrays.toString(input)); // [1, 2, 4, 6, 9] 가 되어야 합니다!

        System.out.println("정답 = [1, 2, 4, 6, 9] / 현재 풀이 값 = " + Arrays.toString(bubbleSort(new int[]{4, 6, 2, 9, 1})));
        System.out.println("정답 = [-1, 3, 9, 17] / 현재 풀이 값 = " + Arrays.toString(bubbleSort(new int[]{3, -1, 17, 9})));
        System.out.println("정답 = [-3, 32, 44, 56, 100] / 현재 풀이 값 = " + Arrays.toString(bubbleSort(new int[]{100, 56, -3, 32, 44})));
    }
}