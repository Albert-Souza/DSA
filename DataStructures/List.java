package DataStructures;

@SuppressWarnings("unchecked")
public class List<T> {
    private T[] data;
    private int size;
    
    public List() {
        data = (T[]) new Object[10];
        size = 0;
    }

    public void append(T elem) {
        if (size == data.length) {enlarge();}
        data[size++] = elem;
    }

    public T get(int index) {
        if (index >= size) {throw new IllegalStateException("Index out of bounds");}
        return data[index];
    }

    public void put(T elem, int index) {
        if (index >= size) {throw new IllegalStateException("Index out of bounds");}
        if (size == data.length) {enlarge();}
        for (int i = size-1; (i >= index); i--) {
            data[i+1] = data[i];
        }
        data[index] = elem;
        size++;
    }

    public void drop(int index) {
        if (index >= size) {throw new IllegalStateException("Index out of bounds");}
        data[index] = null;
        for (int i = index+1; (i < size); i++) {
            data[i-1] = data[i];
        }
        data[--size] = null;
        if ((size == data.length / 4) && (size > 10)) {shrink();}
    }

    public void traversal() {
        System.out.print("[ ");
        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("]");
    }

    private void enlarge() {
        T[] newData = (T[]) new Object[data.length * 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void shrink() {
        T[] newData = (T[]) new Object[data.length / 2];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
