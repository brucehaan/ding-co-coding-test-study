package week3;

import java.util.Arrays;

public class Main2 {

    public static int[] selectionSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len - 1; i++) {
            int minIndex = i; // i = 0
            for (int j = 0; j < len - i; j++) {
                if (array[i + j] < array[minIndex]) {
                    minIndex = i + j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] input = {4, 6, 2, 9, 1};
        selectionSort(input);
        System.out.println(Arrays.toString(input)); // [1, 2, 4, 6, 9] 가 되어야 합니다!

        int[] arr1 = {4, 6, 2, 9, 1};
        selectionSort(arr1);
        System.out.println("정답 = [1, 2, 4, 6, 9] / 현재 풀이 값 = " + Arrays.toString(arr1));

        int[] arr2 = {3, -1, 17, 9};
        selectionSort(arr2);
        System.out.println("정답 = [-1, 3, 9, 17] / 현재 풀이 값 = " + Arrays.toString(arr2));

        int[] arr3 = {100, 56, -3, 32, 44};
        selectionSort(arr3);
        System.out.println("정답 = [-3, 32, 44, 56, 100] / 현재 풀이 값 = " + Arrays.toString(arr3));
    }
}