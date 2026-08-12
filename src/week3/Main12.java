package week3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main12 {
    public static String getAbsentStudent1(String[] allArray, String[] presentArray) {
        Map<String, Boolean> dict = new HashMap<>();
        for (String student : allArray) {
            dict.put(student, true);
        }

        for (String presentStudent : presentArray) {
            dict.remove(presentStudent);
        }

        for (String key : dict.keySet()) {
            return key;
        }
        return null;
    }



    public static String getAbsentStudent(String[] allArray, String[] presentArray) {

        int len = allArray.length;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < len; i++) {
            map.put(allArray[i], 0);
        }
        for (int i = 0; i < presentArray.length; i++) {
            if (map.containsKey(presentArray[i])) {
                map.put(presentArray[i], 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (map.get(allArray[i]) == 0) {
                return allArray[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String[] allStudents = {"나연", "정연", "모모", "사나", "지효", "미나", "다현", "채영", "쯔위"};
        String[] presentStudents = {"정연", "모모", "채영", "쯔위", "사나", "나연", "미나", "다현"};
        System.out.println(getAbsentStudent(allStudents, presentStudents));

        String[] allArr1 = {"류진", "예지", "채령", "리아", "유나"};
        String[] presentArr1 = {"리아", "류진", "채령", "유나"};
        System.out.println("정답 = 예지 / 현재 풀이 값 = " + getAbsentStudent(allArr1, presentArr1));

        String[] allArr2 = {"정국", "진", "뷔", "슈가", "지민", "RM"};
        String[] presentArr2 = {"뷔", "정국", "지민", "진", "슈가"};
        System.out.println("정답 = RM / 현재 풀이 값 = " + getAbsentStudent(allArr2, presentArr2));
    }
}