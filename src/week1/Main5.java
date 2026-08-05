package week1;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main5 {

    public static char findNotRepeatingFirstCharacter(String string) {
        List<String> list = new LinkedList<>();
        String[] split = string.split("");
        for (String s : split) {
            if (list.contains(s)) {
                list.remove(s);
            } else {
                list.add(s);
            }
        }
        if (list.isEmpty()) {
            list.add("_");
        }
        return list.get(0).charAt(0);
    }

    public static void main(String[] args) {
        System.out.println("정답 = d 현재 풀이 값 = " + findNotRepeatingFirstCharacter("abadabac"));
        System.out.println("정답 = c 현재 풀이 값 = " + findNotRepeatingFirstCharacter("aabbcddd"));
        System.out.println("정답 = _ 현재 풀이 값 = " + findNotRepeatingFirstCharacter("aaaaaaaa"));
    }
}
