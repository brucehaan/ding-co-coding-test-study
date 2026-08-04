package week1;

public class Main4 {

    public static boolean isNumberExist(int number, int[] array) {
        for (int i : array) {
            if (i == number) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr1 = {3, 5, 6, 1, 2, 4};
        int[] arr2 = {6, 6, 6};
        int[] arr3 = {6, 9, 2, 7, 1888};

        System.out.println("정답 = True 현재 풀이 값 = " + isNumberExist(3, arr1));
        System.out.println("정답 = False 현재 풀이 값 = " + isNumberExist(7, arr2));
        System.out.println("정답 = True 현재 풀이 값 = " + isNumberExist(2, arr3));
    }
}