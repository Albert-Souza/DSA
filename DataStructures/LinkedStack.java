package DataStructures;

public class LinkedStack<T> {
    private Node head;

    public LinkedStack() {
        this.head = null;
    }

    public void push(T val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public T pop() {
        if (head == null) {return null;}
        T val = head.val;
        head = head.next;
        return val;
    }

    public T peek() {
        if (head == null) {return null;}
        return head.val;
    }

    public void traversal() {
        Node curr = head;
        System.out.print("[ ");
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println("]");
    }

    private class Node {
        private T val;
        private Node next;

        public Node(T val) {
            this.val = val;
            this.next = null;
        }
    }
}
