package string;

public class LongerContiguousSegmentsOfOnesthanZeros_1869 {
    public boolean checkZeroOnes(String s) {
        int[] d = new int[]{0, 0};

        int l = 0, r = 0, n = s.length();
        while(r < n){
            int sr = s.charAt(r) - '0', sl = s.charAt(l) - '0';
            if(sr != sl){
                d[sl] = Math.max(d[sl], r - l);
                l = r;
            }
            r++; 
        }
        int sl = s.charAt(l) - '0';
        d[sl] = Math.max(d[sl], r - l);
        return d[1] > d[0];
    }
}
