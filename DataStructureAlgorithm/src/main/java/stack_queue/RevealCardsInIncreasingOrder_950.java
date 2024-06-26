package stack_queue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class RevealCardsInIncreasingOrder_950 {
    public static int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> deque = new ArrayDeque<Integer>();

        int n = deck.length;
        for (int i = n - 1; i >= 0; i--) {
            Integer last = deque.pollLast();
            if(last != null)
                deque.addFirst(last);
            deque.addFirst(deck[i]);
        }
        for (int i = 0; i < n; i++) {
            deck[i] = deque.pollFirst();
        }
        return deck;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(deckRevealedIncreasing(new int[]{17, 13, 11, 2, 3, 5, 7})));
    }
}
