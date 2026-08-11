package week3;

public class Main6 {
    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Stack {
        private Node head;

        public Stack() {
            this.head = null;
        }

        public void push(int value) {
            Node newHead = new Node(value);
            newHead.next = this.head;
            this.head = newHead;
        }

        public Node pop() {
            if (isEmpty()) {
                System.out.println("stack is Empty");
                return null;
            }

            Node deleteHead = this.head;
            this.head = this.head.next;
            return deleteHead;
        }

        public Object peek() {
            if (isEmpty()) {
                return "stack is Empty";
            }

            return this.head.data;
        }

        public boolean isEmpty() {
            return this.head == null;
        }
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(4);
        System.out.println(stack.peek());

        stack.push(3);
        System.out.println(stack.peek());

        stack.push(5);
        System.out.println(stack.peek());

        stack.pop();
        System.out.println(stack.peek());

        stack.pop();
        System.out.println(stack.peek());

        stack.pop();
        System.out.println(stack.peek());
    }
}
