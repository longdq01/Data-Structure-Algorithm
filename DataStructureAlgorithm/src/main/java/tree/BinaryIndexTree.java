package tree;

import java.util.Arrays;

public class BinaryIndexTree {
    public static void main(String[] args) {
        int a[] = new int[]{0,3,2,1,5,3,6,2,0,7,1};
        int f[] = new int[a.length];
        int result = 0;
        int i = 4;
        while(i >= 1){
            result = result + f[i];
            i -= i & -i;
        }
        System.out.println(Arrays.toString(f));
    }
}
