package greedy;

import java.util.Arrays;

public class BoatsToSavePeople_881 {
    public static int numRescueBoats(int[] people, int limit) {
        int boats = 0, r = people.length - 1, l = 0;
        Arrays.sort(people);
        while(l <= r){
            if(people[l] + people[r] <= limit){
                l++;
            }
            r--;
            boats++;
        }

        return boats;
    }

    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[]{5,1,4,2}, 6));
    }
}
