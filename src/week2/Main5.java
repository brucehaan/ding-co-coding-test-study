package week2;

class NodeMain5 {
    int data;
    NodeMain5 next;

    public NodeMain5(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListMain5 {
    NodeMain5 head;

    public LinkedListMain5(int value) {
        this.head = new NodeMain5(value);
    }

    public void append(int value) {
        NodeMain5 cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new NodeMain5(value);
    }
}

public class Main5 {

    public static int getLinkedListSum(LinkedListMain5 linkedList1, LinkedListMain5 linkedList2) {
        int sum1 = getSingleLinkedListSum(linkedList1);
        int sum2 = getSingleLinkedListSum(linkedList2);
        return sum1 + sum2;
    }

    private static int getSingleLinkedListSum(LinkedListMain5 linkedList) {
        int sum = 0;
        NodeMain5 cur = linkedList.head;
        while (cur != null) {
            sum = sum * 10 + cur.data;
            cur = cur.next;
        }
        return sum;
    }

    public static void main(String[] args) {
        LinkedListMain5 linkedList1 = new LinkedListMain5(6);
        linkedList1.append(7);
        linkedList1.append(8);

        LinkedListMain5 linkedList2 = new LinkedListMain5(3);
        linkedList2.append(5);
        linkedList2.append(4);

        System.out.println(getLinkedListSum(linkedList1, linkedList2));
    }
}