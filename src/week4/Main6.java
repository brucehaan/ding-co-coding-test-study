package week4;

public class Main6 {

    public static int fiboRecursion(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fiboRecursion(n - 1) + fiboRecursion(n - 2);
    }

    public static void main(String[] args) {
        int input = 20;
        System.out.println(fiboRecursion(input)); // 6765
    }
}