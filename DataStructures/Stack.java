package DataStructures;

@SuppressWarnings("unchecked")
public class Stack<T> {
    private T[] data;
    private int popPosition;

    public Stack(int size) {
        data = (T[]) new Object[size];
        popPosition = -1;
    }

    public void push(T elem) {
        data[++popPosition] = elem;
    }

    public T pop() {
        T elem = data[popPosition];
        data[popPosition--] = null;
        return elem;
    }

    public T peek() {
        return data[popPosition];
    }

    public void traversal() {
        System.out.print("[ ");
        for (int i = popPosition; i >= 0; i--) {
            System.out.print(data[i] + " ");
        }
        System.out.println("]");
    }
}
