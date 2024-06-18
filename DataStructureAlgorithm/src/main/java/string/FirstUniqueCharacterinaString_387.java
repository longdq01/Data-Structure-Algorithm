package string;

public class FirstUniqueCharacterinaString_387 {
    public int firstUniqChar(String s) {
        int[] c = new int[26];

        for (int i = 0; i < s.length(); i++) {
            int v = s.charAt(i);
            c[v - 97] = c[v - 97] + 1;
        }

        for (int i = 0; i < s.length(); i++){
            if(c[s.charAt(i) - 97] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacterinaString_387 f = new FirstUniqueCharacterinaString_387();
        System.out.println(f.firstUniqChar("leetcode"));
    }
}
