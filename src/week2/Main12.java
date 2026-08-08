package week2;

import java.util.ArrayList;
import java.util.List;

public class Main12 {

    static List<Integer> list = new ArrayList<>();
    public static int getCountOfWaysToTargetByDoingPlusOrMinus(int[] array, int target) {
        list.clear();
        getAllWaysByDoingPlusOrMinus(array, 0, 0);

        int targetCount = 0;
        for(int element : list) {
            if(element == target) {
                targetCount++;
            }
        }
        return targetCount;
    }
    private static void getAllWaysByDoingPlusOrMinus(int[] array, int currentIndex, int currentSum) {
        if (currentIndex == array.length) {
            list.add(currentSum);
            return ;
        }
        getAllWaysByDoingPlusOrMinus(array, currentIndex + 1, currentSum + array[currentIndex]);
        getAllWaysByDoingPlusOrMinus(array, currentIndex + 1, currentSum - array[currentIndex]);
    }

    public static void main(String[] args) {
        int[] numbers = {1, 1, 1, 1, 1};
        int targetNumber = 3;

        System.out.println(getCountOfWaysToTargetByDoingPlusOrMinus(numbers, targetNumber)); // 5를 반환해야 합니다!
    }
}