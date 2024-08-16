package dynamic_programming;

public class CanPlaceFlowers_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int prev = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if(prev == 0 && flowerbed[i] == 0 && n > 0){
                flowerbed[i] = 1;
                n--;
            }

            if(prev == 1 && flowerbed[i] == 1){
                n++;
            }
            prev = flowerbed[i];
        }

        return n == 0;
    }
}
