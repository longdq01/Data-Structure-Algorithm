package hashtable;

import java.util.ArrayList;

public class MyHashSet {
    private final int SIZE = 1000;
    private ArrayList<ArrayList<Integer>> myBuckets;

    public MyHashSet() {
        myBuckets = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            myBuckets.add(new ArrayList<>());
        }
    }

    private int hashFunction(int key){
        return key % SIZE;
    }

    public void add(int key){
        int hashValueIndex = hashFunction(key);
        ArrayList<Integer> bucket = myBuckets.get(hashValueIndex);
        int keyIndex = bucket.indexOf(key);

        if(keyIndex < 0){
            bucket.add(key);
        }
    }

    public void remove(int key){
        int hashValueIndex = hashFunction(key);
        ArrayList<Integer> bucket = myBuckets.get(hashValueIndex);
        int keyIndex = bucket.indexOf(key);

        if(keyIndex >= 0){
            bucket.remove(keyIndex);
        }
    }

    public boolean contains(int key){
        int hashValueIndex = hashFunction(key);
        ArrayList<Integer> bucket = myBuckets.get(hashValueIndex);
        int keyIndex = bucket.indexOf(key);
        return keyIndex >= 0;
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);
        myHashSet.add(1);
        myHashSet.add(2);

    }
}
