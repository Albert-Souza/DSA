package DataStructures;

public class LinkedList<T> {
    private Node head;

    private class Node {
        private T val;
        private Node next;
    
        public Node(T val) {
            this.val = val;
        }
    }

    public LinkedList() {
        head = null;
    }

    public void append(T val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
    }

    public void prepend(T val) {
        Node newNode = new Node(val);
        newNode.next = head;
        head = newNode;
    }

    public void remove(T val) {
        if (head != null && head.val == val) {
            head = head.next;
        } else {
            Node curr = head;
            while (curr != null && curr.next != null) {
                if (curr.next.val == val) {
                    curr.next = curr.next.next;
                    return;
                } 
                curr = curr.next;
            }
        }
    }

    public boolean has(T val) {
        Node curr = head;
        while (curr != null) {
            if (curr.val == val) {return true;}
            curr = curr.next;
        }
        return false;
    }

    public void traversal() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
