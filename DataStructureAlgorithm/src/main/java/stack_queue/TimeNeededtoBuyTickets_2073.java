package stack_queue;

public class TimeNeededtoBuyTickets_2073 {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length, loop = tickets[k];
        int count = loop * n;
        for (int i = 0; i < n; i++) {
            if(i != k){
                int val = tickets[i] - loop;
                if(val < 0){
                    count += val;
                }
                if(i > k && val >= 0){
                    count--;
                }
            }
        }
        return count;
    }
}
