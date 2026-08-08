package week2;

public class Main6 {

    public static boolean isExistingTargetNumberBinary(int target, int[] array) {
        int currentMin = 0;
        int currentMax = array.length - 1;
        int currentGuess = (currentMin + currentMax) / 2;

        int findCount = 0;
        while (currentMin <= currentMax) {
            findCount += 1;
            if (array[currentGuess] == target) {
                System.out.println(findCount);
                return true;
            } else if (array[currentGuess] < target) {
                currentMin = currentGuess + 1;
            } else { // array[currentGuess] > target
                currentMax = currentGuess - 1;
            }
            currentGuess = (currentMin + currentMax) / 2;
        }
        return false;
    }

    public static void main(String[] args) {
        int findingTarget = 14;
        int[] findingNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

        boolean result = isExistingTargetNumberBinary(findingTarget, findingNumbers);
        System.out.println(result);
    }
}