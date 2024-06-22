package DataStructures;

import java.lang.reflect.Array;

@SuppressWarnings("unchecked")
public class HashTable<K, V> {
    private LinkedList[] data;

    private class LinkedList {
        private Node head;
        private int size;

        private class Node {
            private K key;
            private V val;
            private Node next;
        
            public Node(K key, V val) {
                this.key = key;
                this.val = val;
            }
        }
    
        public LinkedList() {
            head = null;
            size = 0;
        }

        public void add(K key, V val) {
            Node newNode = new Node(key, val);
            newNode.next = head;
            head = newNode;
            size++;
        }

        public void remove(K key) {
            if (head != null && head.key == key) {
                head = head.next;
                size--;
                return;
            } else {
                Node curr = head;
                while (curr != null && curr.next != null) {
                    if (curr.next.key == key) {
                        curr.next = curr.next.next;
                        size--;
                        return;
                    } 
                    curr = curr.next;
                }
            }
        }

        public V getByKey(K key) {
            Node curr = head;
            while (curr != null) {
                if (curr.key == key) {return curr.val;}
                curr = curr.next;
            }
            return null;
        }

        public void replaceValue(K key, V val) {
            Node curr = head;
            while (curr != null) {
                if (curr.key == key) {
                    curr.val = val;
                    return;
                }
                curr = curr.next;
            }
        }
    
        public boolean has(K key) {
            Node curr = head;
            while (curr != null) {
                if (curr.key == key) {
                    return true;
                }
                curr = curr.next;
            }
            return false;
        }

        public K[] getKeys() {
            K[] keys = (K[]) new Object[size];
            Node curr = head;
            for (int i = 0; i < size; i++) {
                keys[i] = curr.key;
                curr = curr.next;
            }
            return keys;
        }

        public V[] getValues() {
            V[] values = (V[]) new Object[size];
            Node curr = head;
            for (int i = 0; i < size; i++) {
                values[i] = curr.val;
                curr = curr.next;
            }
            return values;
        }
    }

    public HashTable() {
        this(100);
    }

    public HashTable(int size) {
        data = (LinkedList[]) Array.newInstance(LinkedList.class, size);
    }

    public void add(K key, V val) {
        if (has(key)) {throw new IllegalArgumentException("Key already exists");}
        int index = getIndex(key);
        if (data[index] == null) {data[index] = new LinkedList();}
        data[index].add(key, val);
    }

    public void remove(K key) {
        int index = getIndex(key);
        if (has(key)) {data[index].remove(key);}
        if (data[index].head == null) {data[index] = null;}
    }

    public void replace(K key, V value) {
        if (!has(key)) {
            add(key, value);
            return;
        }
        int index = getIndex(key);
        data[index].replaceValue(key, value);
    }

    public V get(K key) {
        int index = getIndex(key);
        if (data[index] == null) {return null;}
        return data[index].getByKey(key);
    }

    public boolean has(K key) {
        int index = getIndex(key);
        if (data[index] == null) {return false;}
        return data[index].has(key);
    }

    public void traversal() {
        System.out.print("{ ");
        for (int i = 0; i < data.length; i++) {
            LinkedList lkList = data[i];
            if (lkList != null) {
                K[] keys = lkList.getKeys();
                V[] values = lkList.getValues();
                for (int j = 0; j < keys.length; j++) {
                    System.out.print(keys[j] + ":" + values[j] + " ");
                }
            }
        }
        System.out.println("}");
    }
    
    private int getIndex(K key) {
        return Math.abs(key.hashCode() % data.length);
    }
}
