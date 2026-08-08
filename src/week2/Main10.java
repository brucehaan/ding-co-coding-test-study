package week2;

class NodeMain10 {
    int data;
    NodeMain10 next;

    public NodeMain10(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListMain10 {
    NodeMain10 head;

    public LinkedListMain10(int value) {
        this.head = new NodeMain10(value);
    }

    public void append(int value) {
        NodeMain10 cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new NodeMain10(value);
    }

    public NodeMain10 getKthNodeFromLast(int k) {
        NodeMain10 cur = head;
        int count = 0;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        cur = head;
        for(int i = 0; i < count - k; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public NodeMain10 getKthNodeFromLast2(int k) {
        NodeMain10 slow = head;
        NodeMain10 fast = head;

        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}

public class Main10 {
    public static void main(String[] args) {
        LinkedListMain10 linkedList = new LinkedListMain10(6);
        linkedList.append(7);
        linkedList.append(8);
        System.out.println(linkedList.getKthNodeFromLast2(2).data); // 7이 나와야 합니다!
    }
}