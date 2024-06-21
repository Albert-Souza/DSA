package DataStructures;

@SuppressWarnings("unchecked")
public class Deque<T> {
    private T[] data;
    private int leftPosition;
    private int rightPosition;
    private int size;

    public Deque(int size) {
        data = (T[]) new Object[size];
        leftPosition = 0;
        rightPosition = size - 1;
        this.size = 0;
    }

    public void pushLeft(T val) {
        if (size == data.length) {throw new IllegalStateException("Deque is full");}
        leftPosition = (leftPosition - 1 + data.length) % data.length;
        data[leftPosition] = val;
        size++;
    }

    public void pushRight(T val) {
        if (size == data.length) {throw new IllegalStateException("Deque is full");}
        rightPosition = (rightPosition + 1) % data.length;
        data[rightPosition] = val;
        size++;
    }

    public T popLeft() {
        T val = data[leftPosition];
        data[leftPosition] = null;
        leftPosition = (leftPosition + 1) % data.length;
        size--;
        return val;
    }

    public T popRight() {
        T val = data[rightPosition];
        data[rightPosition] = null;
        rightPosition = (rightPosition - 1 + data.length) % data.length;
        size--;
        return val;
    }

    public T peekLeft() {
        return data[leftPosition];
    }

    public T peekRight() {
        return data[rightPosition];
    }

    public void traversal() {
        System.out.print("[ ");
        for (int i = 0, pos = leftPosition; i < size; i++, pos = (pos + 1) % data.length) {
            System.out.print(data[pos] + " ");
        }
        System.out.println("]");
    }
}
