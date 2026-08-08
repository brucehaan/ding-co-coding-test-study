package week2;

public class Main8 {

    public static boolean isPalindrome(String string) {
        if (string == null || string.length() % 2 == 0) {
            return false;
        }
        int half = string.length() / 2;
        for (int i = 0; i < half; i++) {
            if (string.charAt(i) != string.charAt(half * 2 - 1 - i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String input = "abcba";
        System.out.println(isPalindrome(input));
    }
}