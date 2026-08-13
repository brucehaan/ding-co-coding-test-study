package week3;

import java.util.Stack;

public class Main14 {

    public static boolean isCorrectParenthesis(String string) {
        Stack<String> stack = new Stack<>();
        String[] arr = string.split("");
        for (String s : arr) {
            if (s.equals("(")) stack.push(s);
            else if (s.equals(")")) {
                if (stack.empty()) return false;
                stack.pop();
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        System.out.println("정답 = True / 현재 풀이 값 = " + isCorrectParenthesis("(())"));
        System.out.println("정답 = False / 현재 풀이 값 = " + isCorrectParenthesis(")"));
        System.out.println("정답 = False / 현재 풀이 값 = " + isCorrectParenthesis("((())))"));
        System.out.println("정답 = False / 현재 풀이 값 = " + isCorrectParenthesis("())()"));
        System.out.println("정답 = False / 현재 풀이 값 = " + isCorrectParenthesis("((())"));
    }
}