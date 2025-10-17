import mylib.collections.MyHashSet;
import mylib.collections.MyHashMultiSet;

public class Main {
    public static void main(String[] args) {
        MyHashSet<String> set = new MyHashSet<>();
        set.add("apple");
        System.out.println(set);

        MyHashMultiSet<String> multi = new MyHashMultiSet<>();
        multi.add("apple");
        multi.add("orange");
        System.out.println(multi);
    }
}
