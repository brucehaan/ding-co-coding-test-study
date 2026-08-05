package week1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main5 {

    public static char findNotRepeatingFirstCharacter(String string) {
        // string에서 알파벳의 빈도수를 찾는다.
        int[] occurrenceArray = findAlphabetOccurrenceArray(string);
        // 그리고 빈도수가 1인 알파벳들 중에서 string에서 뭐가 먼저 나왔는지를 찾아본다.
        List<Character> notRepeatingCharacterArray = new ArrayList<>();
        for (int index = 0; index < occurrenceArray.length; index++) {
            int alphabetOccurrence = occurrenceArray[index];
            if (alphabetOccurrence == 1) {
                notRepeatingCharacterArray.add((char)(index + 'a'));
            }
        }
        for (char ch : string.toCharArray()) {
            if (notRepeatingCharacterArray.contains(ch)) {
                return ch;
            }
        }
        return '_';
    }

    public static int[] findAlphabetOccurrenceArray(String string) {
        int[] alphabetOccurrenceArray = new int[26];
        for (char ch : string.toCharArray()) {
            if (!Character.isLetter(ch)) {
                continue;
            }
            int arrIndex = ch - 'a';
            alphabetOccurrenceArray[arrIndex] += 1;
        }
        return alphabetOccurrenceArray;
    }

    public static void main(String[] args) {
        System.out.println("정답 = d 현재 풀이 값 = " + findNotRepeatingFirstCharacter("abadabac"));
        System.out.println("정답 = c 현재 풀이 값 = " + findNotRepeatingFirstCharacter("aabbcddd"));
        System.out.println("정답 = _ 현재 풀이 값 = " + findNotRepeatingFirstCharacter("aaaaaaaa"));
    }
}
