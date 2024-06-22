package DataStructures;

@SuppressWarnings("unchecked")
public class Tuple<T> {
    private final T[] data;
    
    public Tuple(T[] elems) {
        T[] newData = (T[]) new Object[elems.length];
        for (int i = 0; i < elems.length; i++) {
            newData[i] = elems[i];
        }
        data = newData;
    }

    public T get(int index) {
        return data[index];
    }

    public void traversal() {
        System.out.print("( ");
        for (T elem : data) {
            System.out.print(elem + " ");
        }
        System.out.println(")");
    }
}
