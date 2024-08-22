package bitwise;

public class NumberComplement_476 {
    public int findComplement(int num) {
        int bit = (int)(Math.log(num) / Math.log(2)) + 1;
        for (int i = 0; i < bit; i++) {
            num ^= (1 << i);
        }
        return num;
    }
}
