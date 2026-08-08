package week2;

class NodeMain3 {
    int data;
    NodeMain3 next;

    public NodeMain3(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListMain3 {
    NodeMain3 head;

    public LinkedListMain3(int value) {
        this.head = new NodeMain3(value);
    }

    public void append(int value) {
        NodeMain3 cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new NodeMain3(value);
    }

    public void printAll() {
        NodeMain3 cur = head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public NodeMain3 getNode(int index) {
        NodeMain3 node = head;
        int count = 0;
        while (count < index) {
            node = node.next;
            count++;
        }
        return node;
    }

    public void addNode(int index, int value) {
        NodeMain3 node = new NodeMain3(value);
        if (index == 0) {
            node.next = head;
            head = node;
            return;
        }
        NodeMain3 prevNode = getNode(index - 1);
        NodeMain3 nextNode = prevNode.next;
        prevNode.next = node;
        node.next = nextNode;
    }
}

public class Main3 {
    public static void main(String[] args) {
        LinkedListMain3 linkedList = new LinkedListMain3(5);
        linkedList.append(12);
        linkedList.append(8);
        linkedList.printAll();

        linkedList.addNode(0, 3);
        linkedList.addNode(1, 6);
        linkedList.addNode(0, 7);
        linkedList.printAll();
    }
}
