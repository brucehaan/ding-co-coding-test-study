package week1;

import java.util.ArrayList;
import java.util.List;

public class Main6 {

    public static List<Integer> findPrimeListUnderNumber(int number) {
        List<Integer> list = new ArrayList<>();
        for (int n = 2; n <= number; n++) {
            boolean isPrime = true;
            for(int i : list) {
                if (i * i <= n && n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) list.add(n);
        }
        return list;
    }

    public static void main(String[] args) {
        int input = 20;
        List<Integer> result = findPrimeListUnderNumber(input);
        System.out.println(result);
    }
}