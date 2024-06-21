package DataStructures;

public class LinkedDeque<T> {
    private Node left;
    private Node right;

    private class Node {
        private T val;
        private Node prev;
        private Node next;
        
        public Node(T val) {
            this.val = val;
        }
    }

    public LinkedDeque() {
        left = null;
        right = null;
    }

    public void pushLeft(T val) {
        Node newNode = new Node(val);
        newNode.next = left;
        if (left != null) {left.prev = newNode;}
        left = newNode;
        if (right == null) {right = left;}
    }

    public void pushRight(T val) {
        Node newNode = new Node(val);
        newNode.prev = right;
        if (right != null) {right.next = newNode;}
        right = newNode;
        if (left == null) {left = right;}
    }

    public T popLeft() {
        if (left == null) {return null;}
        T val = left.val;
        left = left.next;
        if (left != null) {left.prev = null;} 
        else {right = null;}
        return val;
    }

    public T popRight() {
        if (right == null) {return null;}
        T val = right.val;
        right = right.prev;
        if (right != null) {right.next = null;} 
        else {left = null;}
        return val;
    }

    public T peekLeft() {
        if (left == null) {return null;}
        return left.val;
    }

    public T peekRight() {
        if (right == null) {return null;}
        return right.val;
    }

    public void traversal() {
        Node curr = left;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }
}
