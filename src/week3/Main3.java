package week3;

import java.util.Arrays;

public class Main3 {

    public static void insertionSort(int[] array) {
        int n = array.length;
        for(int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (array[i - j] < array[i - j - 1]) {
                    int temp = array[i - j];
                    array[i - j] = array[i - j - 1];
                    array[i - j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        int[] input = {4, 6, 2, 9, 1};
        insertionSort(input);
        System.out.println(Arrays.toString(input)); // [1, 2, 4, 6, 9] 가 되어야 합니다!

        int[] arr1 = {5, 8, 4, 7, 7};
        insertionSort(arr1);
        System.out.println("정답 = [4, 5, 7, 7, 8] / 현재 풀이 값 = " + Arrays.toString(arr1));

        int[] arr2 = {3, -1, 17, 9};
        insertionSort(arr2);
        System.out.println("정답 = [-1, 3, 9, 17] / 현재 풀이 값 = " + Arrays.toString(arr2));

        int[] arr3 = {100, 56, -3, 32, 44};
        insertionSort(arr3);
        System.out.println("정답 = [-3, 32, 44, 56, 100] / 현재 풀이 값 = " + Arrays.toString(arr3));
    }
}
