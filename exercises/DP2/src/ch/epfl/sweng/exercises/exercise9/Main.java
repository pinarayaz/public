package ch.epfl.sweng.exercises.exercise9;

public class Main {

    public static void main(String[] args) {
        KeyValueStore store = new KeyValueStoreImpl();

        store.put(3, 1993);
        System.out.println(store.get(3));

        store.put(9, 1873);
        System.out.println(store.get(9));

        store.remove(3);
        System.out.println(store.get(3));
    }
}
