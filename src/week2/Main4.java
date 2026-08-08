package week2;

class NodeMain4 {
    int data;
    NodeMain4 next;

    public NodeMain4(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListMain4 {
    NodeMain4 head;

    public LinkedListMain4(int value) {
        this.head = new NodeMain4(value);
    }

    public void append(int value) {
        NodeMain4 cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new NodeMain4(value);
    }

    public void printAll() {
        NodeMain4 cur = head;
        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }

    public NodeMain4 getNode(int index) {
        NodeMain4 node = head;
        int count = 0;
        while (count < index) {
            node = node.next;
            count++;
        }
        return node;
    }

    public void addNode(int index, int value) {
        NodeMain4 newNode = new NodeMain4(value);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        NodeMain4 node = getNode(index - 1);
        NodeMain4 nextNode = node.next;
        node.next = newNode;
        newNode.next = nextNode;
    }

    public void deleteNode(int index) {
        if (index == 0) {
            head = head.next;
            return;
        }
        NodeMain4 prevNode = getNode(index - 1).next;
        NodeMain4 indexNode = getNode(index);
        prevNode.next = indexNode.next;
    }
}

public class Main4 {
    public static void main(String[] args) {
        LinkedListMain4 linkedList = new LinkedListMain4(5);
        linkedList.append(12);
        linkedList.append(8);
        linkedList.printAll();
        linkedList.addNode(1, 6);
        linkedList.addNode(0, 7);
        linkedList.deleteNode(1);
        linkedList.printAll();
        // head
        // head
        // [7][6][12][8]
        linkedList.deleteNode(0);
        // [6][12][8]
        linkedList.printAll();
    }
}