package com.example.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class DeckOfCards {
    public boolean hasGroupsSizeX(int[] deck) {
        int n = deck.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int d: deck) {
            freq.put(d, freq.getOrDefault(d, 0) + 1);
        }

        ArrayList<Integer> lst = new ArrayList<>();
        for (int key: freq.keySet()) {
            lst.add(freq.get(key));
        }

        int min = Collections.min(lst);
        if(min < 2)
            return false;
        for (int v: lst){
            if(v % min != 0){
                return false;
            }
        }
        return true;
    }
}
