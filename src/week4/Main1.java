package week4;

import java.util.ArrayList;
import java.util.List;

class MaxHeapMain1 {
    List<Integer> items;

    public MaxHeapMain1() {
        this.items = new ArrayList<>();
        this.items.add(null);
    }

    public void insert(int value) {
        items.add(value);
        int curIndex = items.size() - 1;
        while (curIndex > 1) {
            int parentIndex = curIndex / 2;
            if (items.get(parentIndex) < items.get(curIndex)) {
                int temp = items.get(curIndex);
                items.set(curIndex, items.get(parentIndex));
                items.set(parentIndex, temp);
                curIndex = parentIndex;
            } else {
                break;
            }
        }
    }
}

public class Main1 {
    public static void main(String[] args) {
        MaxHeapMain1 maxHeap = new MaxHeapMain1();
        maxHeap.insert(3);
        maxHeap.insert(4);
        maxHeap.insert(2);
        maxHeap.insert(9);
        System.out.println(maxHeap.items); // [null, 9, 4, 2, 3] 가 출력되어야 합니다!
    }
}
