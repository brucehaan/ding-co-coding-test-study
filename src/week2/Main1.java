package week2;

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    public LinkedList(int value) {
        this.head = new Node(value);
    }

    public void append(int value) {
        Node cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new Node(value);
    }

    public void printAll() {
        Node cur = this.head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
}

public class Main1 {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(5);
        linkedList.append(12);
        linkedList.printAll();
    }
}
