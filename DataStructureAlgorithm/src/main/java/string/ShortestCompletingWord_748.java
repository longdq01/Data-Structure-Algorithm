package string;

public class ShortestCompletingWord_748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] counts1 = countChars(licensePlate);
        int shortestIdx = -1;
        for (int i = 0; i < words.length; i++) {
            int[] counts2 = countChars(words[i]);
            int f = 1;
            for (int j = 0; j < 26; j++) {
                if(counts1[j] > counts2[j]){
                    f = 0;
                    break;
                }
            }
            if(f == 1){
                if(shortestIdx == -1)
                    shortestIdx = i;
                else
                    shortestIdx = words[shortestIdx].length() <= words[i].length() ? shortestIdx : i;
            }
        }
        return words[shortestIdx];
    }

    public int[] countChars(String str){
        int[] countChars = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(Character.isAlphabetic(c))
                countChars[Character.toLowerCase(c) - 'a']++;
        }
        return countChars;
    }
}
