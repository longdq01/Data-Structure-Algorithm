package string;

public class FindIndexFirstOccurrenceinString_28 {
    public static int strStr(String haystack, String needle) {
        int i = 0;
        while(i < haystack.length()){
            int idx = i, j = 0;
            while(i < haystack.length() && j < needle.length() &&
                    haystack.charAt(i) == needle.charAt(j)){
                j++;
                i++;
            }
            if(j == needle.length())
                return idx;
            i = ++idx;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(strStr("sadbutsad", "sad"));
    }
}
