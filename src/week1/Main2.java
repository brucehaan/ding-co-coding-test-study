package week1;

public class Main2 {

    public static int[] findAlphabetOccurrenceArray(String string) {
        String[] arr = string.split("");
        int[] alphabetOccurrenceArray = new int[26];
        for (int i = 0; i < arr.length ; i++) {
            int index = arr[i].charAt(0) - 'a';
            if (index >= 0 && index < alphabetOccurrenceArray.length) {
                alphabetOccurrenceArray[index]++;
            }
        }
        return alphabetOccurrenceArray;
    }

    public static void main(String[] args) {
        String str1 = "hello my name is dingcodingco";
        String str2 = "we love algorithm";
        String str3 = "best of best youtube";

        System.out.println("정답 = [1, 0, 2, 2, 2, 0, 2, 1, 3, 0, 0, 2, 2, 3, 3, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0]");
        System.out.println("현재 풀이 값 = " + java.util.Arrays.toString(findAlphabetOccurrenceArray(str1)));

        System.out.println("정답 = [1, 0, 0, 0, 2, 0, 1, 1, 1, 0, 0, 2, 1, 0, 2, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0]");
        System.out.println("현재 풀이 값 = " + java.util.Arrays.toString(findAlphabetOccurrenceArray(str2)));

        System.out.println("정답 = [0, 3, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 3, 2, 0, 0, 0, 1, 0]");
        System.out.println("현재 풀이 값 = " + java.util.Arrays.toString(findAlphabetOccurrenceArray(str3)));
    }
}