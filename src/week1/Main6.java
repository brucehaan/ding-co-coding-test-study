package week1;

import java.util.ArrayList;
import java.util.List;

public class Main6 {

    public static List<Integer> findPrimeListUnderNumber(int number) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        for (int i = 3; i <= number; i++) {
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    if (list.contains(i)) list.remove(Integer.valueOf(i));
                    break;
                }
                if (list.contains(i)) break;
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int input = 20;
        List<Integer> result = findPrimeListUnderNumber(input);
        System.out.println(result);
    }
}