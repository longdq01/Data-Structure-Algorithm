package hashtable;

import java.util.ArrayList;

public class MyHashMap {
    private final int SIZE = 1000;
    private ArrayList<ArrayList<Data>> myBuckets;

    private class Data{
        int key;
        int value;
        Data(int key, int value){
            this.key = key;
            this.value = value;
        }

        @Override
        public boolean equals(Object obj) {
            if(obj instanceof Data){
                return this.key == ((Data) obj).key;
            }
            return false;
        }
    }

    public MyHashMap() {
        myBuckets = new ArrayList<>();
        for (int i = 0; i < SIZE; i++) {
            myBuckets.add(new ArrayList<>());
        }
    }

    private int hashFunction(int key){
        return key % SIZE;
    }

    public void put(int key, int value){
        int hashValueIndex = hashFunction(key);
        ArrayList<Data> bucket = myBuckets.get(hashValueIndex);
        Data data = new Data(key, value);
        int keyIndex = bucket.indexOf(data);
        if(keyIndex >= 0){
            bucket.get(keyIndex).value = value;
        }else{
            bucket.add(data);
        }
    }

    public void remove(int key){
        int hashValueIndex = hashFunction(key);
        ArrayList<Data> bucket = myBuckets.get(hashValueIndex);
        Data data = new Data(key, 0);
        bucket.remove(data);
    }

    public int get(int key){
        int hashValueIndex = hashFunction(key);
        ArrayList<Data> bucket = myBuckets.get(hashValueIndex);
        Data data = new Data(key, 0);
        int keyIndex = bucket.indexOf(data);
        if(keyIndex >= 0){
           return bucket.get(keyIndex).value;
        }
        return -1;
    }
}
