package DataStructures;

public class MaxHeap {
    private Integer[] data;
    private int lastIndex;

    public MaxHeap(int size) {
        data = new Integer[size+1];
        lastIndex = 0;
    }

    public void insert(int val) {
        data[++lastIndex] = val;
        heapifyUp(lastIndex);
    }

    public int extract() {
        if (lastIndex == 0) {throw new IllegalStateException("Heap is empty");}
        int val = data[1];
        data[1] = data[lastIndex];
        data[lastIndex--] = null;
        heapifyDown(1);
        return val;
    }

    public int peek() {
        return data[1];
    }

    private void heapifyUp(int index) {
        if (index == 1) {return;}
        int curr = data[index];
        int parent = data[index/2];

        if (curr > parent) {
            int temp = curr;
            data[index] = parent;
            data[index/2] = temp;
            heapifyUp(index/2);
        }
    }

    private void heapifyDown(int index) {
        int greater = index;
        int leftIndex = 2 * index;
        int rightIndex = 2 * index + 1;
    
        if (leftIndex <= lastIndex && data[leftIndex] > data[greater]) {
            greater = leftIndex;
        }
    
        if (rightIndex <= lastIndex && data[rightIndex] > data[greater]) {
            greater = rightIndex;
        }
    
        if (greater != index) {
            int temp = data[index];
            data[index] = data[greater];
            data[greater] = temp;
            heapifyDown(greater);
        }
    }

    public void traversal() {
        System.out.print("[ ");
        for (int i = 1; i <= lastIndex; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println("]");
    }
}
