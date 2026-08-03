package week1;

public class Main2 {

    public static char findAlphabetOccurrenceArray1(String string) {
        String[] alphabetArray = {"a", "b", "c", "d", "e", "f", "g", "h", "i",  "j", "k", "l", "m", "n",  "o", "p", "q", "r", "s", "t", "u", "v",  "w", "x", "y", "z"};
        int maxOccurrence = 0;
        String maxAlphabet = alphabetArray[0]; // a

        for (String alphabet : alphabetArray) {
            int occurrence = 0;

            for (char ch : string.toCharArray()) {
                if (String.valueOf(ch).equals(alphabet)) {
                    occurrence += 1;
                }
            }
            if (occurrence > maxOccurrence) {
                maxAlphabet = alphabet;
                maxOccurrence = occurrence;
            }
        }
        return maxAlphabet.charAt(0);
    }

    public static char findMaxOccurredAlphabet2(String string) {
        int[] alphabetOccurrenceArray = new int[26];

        for (char ch : string.toCharArray()) {
            if (!Character.isLetter(ch)) {
                continue;
            }
            int arrIndex = ch - 'a'; // 해당 문자를 인덱스로 치환한다. a -> 0, b -> 1
            alphabetOccurrenceArray[arrIndex] += 1; // 빈도수 배열에 인덱스로 찾아가서 해당 값을 추가해준다.
        }

        int maxOccurrence = 0;
        int maxAlphabetIndex = 0;

        for (int index = 0; index < alphabetOccurrenceArray.length; index++) {
            int alphabetOccurrence = alphabetOccurrenceArray[index];

            if (alphabetOccurrence > maxOccurrence) {
                maxOccurrence = alphabetOccurrence;
                maxAlphabetIndex = index;
            }
        }

        return (char) (maxAlphabetIndex + 'a');
    }

    public static void main(String[] args) {
        String str1 = "hello my name is dingcodingco";
        String str2 = "we love algorithm";
        String str3 = "best of best youtube";

        System.out.println("정답 = [1, 0, 2, 2, 2, 0, 2, 1, 3, 0, 0, 2, 2, 3, 3, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0]");
        System.out.println("현재 풀이 값 = " + findMaxOccurredAlphabet2(str1));

        System.out.println("정답 = [1, 0, 0, 0, 2, 0, 1, 1, 1, 0, 0, 2, 1, 0, 2, 0, 0, 1, 0, 1, 0, 1, 1, 0, 0, 0]");
        System.out.println("현재 풀이 값 = " + findMaxOccurredAlphabet2(str2));

        System.out.println("정답 = [0, 3, 0, 0, 3, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 0, 2, 3, 2, 0, 0, 0, 1, 0]");
        System.out.println("현재 풀이 값 = " + findMaxOccurredAlphabet2(str3));
    }
}