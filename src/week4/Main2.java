package week4;

import java.util.ArrayList;
import java.util.List;

class MaxHeapMain2 {
    List<Integer> items;

    public MaxHeapMain2() {
        this.items = new ArrayList<>();
        this.items.add(null);
    }

    public void insert(int value) {
        items.add(value);
        int curIndex = items.size() - 1;
        while (curIndex > 1) { // curIndex 가 1이 되면 정상을 찍은거라 다른 것과 비교 안하셔도 됩니다!
            int parentIndex = curIndex / 2;
            if (items.get(parentIndex) < items.get(curIndex)) {
                Integer temp = items.get(parentIndex);
                items.set(parentIndex, items.get(curIndex));
                items.set(curIndex, temp);
                curIndex = parentIndex;
            } else {
                break;
            }
        }
    }

    public int delete() {
        int temp = items.get(1);
        items.set(1, items.getLast());
        items.set(items.size() - 1, temp);
        Integer prevMax = items.removeLast();
        int curIndex = 1;

        while (curIndex <= items.size() - 1) {
            int leftChildIndex = curIndex * 2;
            int rightChildIndex = curIndex * 2 + 1;
            int maxIndex = curIndex;

            if (leftChildIndex <= items.size() - 1 && items.get(leftChildIndex) > items.get(maxIndex)) {
                maxIndex = leftChildIndex;
            }
            if (rightChildIndex <= items.size() - 1 && items.get(rightChildIndex) > items.get(maxIndex)) {
                maxIndex = rightChildIndex;
            }

            if (maxIndex == curIndex) break;

            temp = items.get(curIndex);
            items.set(curIndex, items.get(maxIndex));
            items.set(maxIndex, temp);
            curIndex = maxIndex;
        }

        return prevMax; // 8 을 반환해야 합니다.
    }
}

public class Main2 {
    public static void main(String[] args) {
        MaxHeapMain2 maxHeap = new MaxHeapMain2();
        maxHeap.insert(8);
        maxHeap.insert(6);
        maxHeap.insert(7);
        maxHeap.insert(2);
        maxHeap.insert(5);
        maxHeap.insert(4);
        System.out.println(maxHeap.items); // [null, 8, 6, 7, 2, 5, 4]
        System.out.println(maxHeap.delete()); // 8 을 반환해야 합니다!
        System.out.println(maxHeap.items); // [null, 7, 6, 4, 2, 5]
    }
}
