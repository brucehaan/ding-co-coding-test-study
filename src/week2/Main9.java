package week2;

public class Main9 {

    public static boolean isPalindrome(String string) {
        if (string.length() <= 1) return true;
        if (string.charAt(0) != string.charAt(string.length() - 1)) return false;
        return isPalindrome(string.substring(1, string.length() - 1));
    }

    public static void main(String[] args) {
        String input = "abcba";
        System.out.println(isPalindrome(input));
    }
}