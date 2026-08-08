package week2;

class NodeMain2 {
    int data;
    NodeMain2 next;

    public NodeMain2(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListMain2 {
    NodeMain2 head;

    public LinkedListMain2(int value) {
        this.head = new NodeMain2(value);
    }

    public void append(int value) {
        NodeMain2 cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new NodeMain2(value);
    }

    public void printAll() {
        NodeMain2 cur = head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public NodeMain2 getNode(int index) {
        NodeMain2 cur = this.head;
        int count = 0;
        while (count < index) {
            cur = cur.next;
            count++;
        }
        return cur;
    }
}

public class Main2 {
    public static void main(String[] args) {
        LinkedListMain2 linkedList = new LinkedListMain2(5);
        linkedList.append(12);
        System.out.println(linkedList.getNode(1).data); // 5를 들고 있는 노드를 반환해야 합니다!
    }
}
