package mylib.collections;

import java.util.HashMap;
import java.util.Map;

public class MyHashMultiSet<T> {
    private final Map<T, Integer> map = new HashMap<>();
    private int size = 0;

    public void add(T value) {
        map.put(value, map.getOrDefault(value, 0) + 1);
        size++;
    }

    public boolean remove(T value) {
        Integer count = map.get(value);
        if (count == null) return false;
        if (count == 1) map.remove(value);
        else map.put(value, count - 1);
        size--;
        return true;
    }

    public int count(T value) {
        return map.getOrDefault(value, 0);
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{ ");
        for (Map.Entry<T, Integer> e : map.entrySet()) {
            sb.append(e.getKey()).append("×").append(e.getValue()).append(" ");
        }
        sb.append("}");
        return sb.toString();
    }
}
