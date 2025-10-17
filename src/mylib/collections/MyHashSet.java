package mylib.collections;

import java.util.LinkedList;

public class MyHashSet<T> {
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<T>[] buckets;
    private int size;

    @SuppressWarnings("unchecked")
    public MyHashSet() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        size = 0;
    }

    private int hash(T value) {
        return Math.abs(value.hashCode() % buckets.length);
    }

    public boolean add(T value) {
        int index = hash(value);
        if (buckets[index] == null) buckets[index] = new LinkedList<>();
        if (buckets[index].contains(value)) return false;
        buckets[index].add(value);
        size++;
        return true;
    }

    public boolean contains(T value) {
        int index = hash(value);
        return buckets[index] != null && buckets[index].contains(value);
    }

    public boolean remove(T value) {
        int index = hash(value);
        if (buckets[index] != null && buckets[index].remove(value)) {
            size--;
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ ");
        for (LinkedList<T> bucket : buckets) {
            if (bucket != null) {
                for (T val : bucket) sb.append(val).append(" ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
