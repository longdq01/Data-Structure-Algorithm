package twopointer;

import java.util.Arrays;

public class SortColors {
    public static int[] sortColors (int[] colors) {
        int n = colors.length;
        int current = 0, start = 0, end = n - 1;
        while(current <= end){
            if(colors[current] == 0){
                swap(colors, current, start);
                current++;
                start++;
            }else if(colors[current] == 1){
                current++;
            }else{
                swap(colors, current, end);
                end--;
            }
        }

        return colors;
    }

    private static void swap(int[] colors, int i, int j){
        int tmp = colors[i];
        colors[i] = colors[j];
        colors[j] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortColors(new int[]{0, 1, 1, 2, 0, 2, 0, 2, 1, 2})));
    }
}
