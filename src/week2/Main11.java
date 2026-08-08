package week2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main11 {

    public static boolean isAvailableToOrder(String[] menus, String[] orders) {
        // O(NlogN) + O(M) * O(logN) = O((N+M) * logN)
        Arrays.sort(menus); // 메뉴의 길이가 N, O(logN)
        for(String order : orders) { // 오더의 길이가 M이라고 한다면 O(M)
            if (!isExistTargetNumberBinary(order, menus)) { // O(logN)
                return false;
            }
        }
        return true;
    }

    private static boolean isExistTargetNumberBinary(String target, String[] array) {
        int currentMin = 0;
        int currentMax = array.length - 1;
        int currentGuess = (currentMin + currentMax) / 2;

        int findCount = 0;

        while (currentMin <= currentMax) {
            findCount += 1;
            if (array[currentGuess].equals(target)) {
                return true;
            } else if (array[currentGuess].compareTo(target) < 0) {
                currentMin = currentGuess + 1;
            } else { // array[currentGuess] > target
                currentMax = currentGuess - 1;
            }
            currentGuess = (currentMin + currentMax) / 2;
        }
        return false;
    }

    public static boolean isAvailableToOrder2(String[] menus, String[] orders) {
        // O(N) + O(M) * O(1) = O(N+M)
//        Set<String> menusSet = new HashSet<>(); // O(N)
//        for (String menu : menus) {
//            menusSet.add(menu);
//        }
        Set<String> menusSet = new HashSet<>(Arrays.asList(menus));
        for (String order : orders) { // M -> O(M)
            if (!menusSet.contains(order)) { // O(1)
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] shopMenus = {"만두", "떡볶이", "오뎅", "사이다", "콜라"};
        String[] shopOrders = {"오뎅", "콜라", "만두"};

        boolean result = isAvailableToOrder2(shopMenus, shopOrders);
        System.out.println(result);
    }
}
