package week1;

public class Main3 {

    public static int findMaxPlusOrMultiply(int[] array) {
        int answer = 0;
        for (int i : array) {
            if (i <= 1 || answer <= 1) {
                answer += i;
            } else {
                answer *= i;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] arr1 = {0, 3, 5, 6, 1, 2, 4};
        int[] arr2 = {3, 2, 1, 5, 9, 7, 4};
        int[] arr3 = {1, 1, 1, 3, 3, 2, 5};

        System.out.println("정답 = 728 현재 풀이 값 = " + findMaxPlusOrMultiply(arr1));
        System.out.println("정답 = 8820 현재 풀이 값 = " + findMaxPlusOrMultiply(arr2));
        System.out.println("정답 = 270 현재 풀이 값 = " + findMaxPlusOrMultiply(arr3));
    }
}