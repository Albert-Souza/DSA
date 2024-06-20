package DataStructures;

public class LinkedQueue<T> {
    private Node head;
    private Node tail;

    public LinkedQueue() {
        head = null;
        tail = null;
    }

    public void enqueue(T val) {
        Node newNode = new Node(val);
        if (head == null) {
            tail = newNode;
            head = tail;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
    }

    public T dequeue() {
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
