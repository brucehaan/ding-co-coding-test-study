package week3;

import java.util.Arrays;

public class Main4 {

    public static int[] merge(int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];
        int resultIndex = 0;
        int array1Index = 0;
        int array2Index = 0;

        while (array1Index < array1.length && array2Index < array2.length) {
            if (array1[array1Index] < array2[array2Index]) {
                result[resultIndex++] = array1[array1Index];
                array1Index++;
            } else {
                result[resultIndex++] = array2[array2Index];
                array2Index++;
            }
        }

        while (array1Index < array1.length) {
            result[resultIndex++] = array1[array1Index];
            array1Index++;
        }
        while (array2Index < array2.length) {
            result[resultIndex++] = array2[array2Index];
            array2Index++;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arrayA = {1, 2, 3, 5};
        int[] arrayB = {4, 6, 7, 8};
        System.out.println(Arrays.toString(merge(arrayA, arrayB))); // [1, 2, 3, 4, 5, 6, 7, 8] 가 되어야 합니다!

        System.out.println("정답 = [-7, -1, 5, 6, 9, 10, 11, 40] / 현재 풀이 값 = " + Arrays.toString(merge(new int[]{-7, -1, 9, 40}, new int[]{5, 6, 10, 11})));
        System.out.println("정답 = [-1, 2, 3, 5, 10, 40, 78, 100] / 현재 풀이 값 = " + Arrays.toString(merge(new int[]{-1, 2, 3, 5, 40}, new int[]{10, 78, 100})));
        System.out.println("정답 = [-1, -1, 0, 1, 6, 9, 10] / 현재 풀이 값 = " + Arrays.toString(merge(new int[]{-1, -1, 0}, new int[]{1, 6, 9, 10})));
    }
}