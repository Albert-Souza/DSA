package DataStructures;

@SuppressWarnings("unchecked")
public class Queue<T>{
    private T[] data;
    private int enqPosition;
    private int deqPosition;
    private int size;

    public Queue(int size) {
        data = (T[]) new Object[size];
        enqPosition = 0;
        deqPosition = size;
        this.size = 0;
    }

    public void enqueue(T elem) {
        if (size == data.length) {throw new IllegalStateException("Queue is full");}
        if (enqPosition == data.length) {enqPosition = 0;}
        data[enqPosition++] = elem;
        size++;
    }

    public T dequeue() {
        if (deqPosition == data.length) {deqPosition = 0;}
        T val = data[deqPosition];
        data[deqPosition++] = null;
        size--;
        return val;
    }

    public T peek() {
        return data[deqPosition];
    }

    public void traversal() {
        int count = size;
        int i = deqPosition;
        System.out.print("[ ");
        while (count > 0) {
            if (i == data.length) {i = 0;}
            System.out.print(data[i] + " ");
            i++;
            count--;
        }
        System.out.println("]");
    }
}
