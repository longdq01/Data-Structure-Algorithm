package string;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class MinimumDeletionsToMakeStringBalanced_1653 {
    public int minimumDeletions(String s) {
        int count = 1, n = s.length(), i = 1;
        char prev = s.charAt(0);
        List<List<Integer>> list = new ArrayList<>(); // {idx, count}
        while (i < n) {
            char cur = s.charAt(i);
            if(cur == prev){
                count++;
            }else{
                list.add(List.of(i - 1, count));
                prev = cur;
                count = 1;
            }
            i++;
        }
        list.add(List.of(i - 1, count));

        int idx = 0, tmp1 = 0, tmp2 = 0; // tmp1 = xoa b
        List<Integer> cur = list.get(idx);
        if(s.charAt(cur.get(0)) == 'a')
            idx++;

        // idx = 0 => phần tử đầu tiên của s là 'b', idx = 1 => phần tử đầu của s là 'a'
        for (int j = idx + 1; j < list.size(); j+=2) {
            tmp2 += list.get(j).get(1);
        }

        if(idx == 1 && idx < list.size()){
            tmp1 = list.get(idx).get(1);
        }
//        else{
//            for (int j = idx; j < n; j++) {
//                tmp1 += list.get(j).get(1);
//                tmp2 = Math.min(tmp2, tmp1 + tmp2 - list.get(j + 1).get(1));
//            }
//        }
        for (int j = idx; j < list.size(); j+=2) {
            tmp1 += list.get(j).get(1);
            if(j + 1 < list.size()){
                tmp2 = Math.min(tmp2, tmp1 + tmp2 - list.get(j + 1).get(1));
            }
        }
        return Math.min(tmp1, tmp2);
    }

    public static void main(String[] args) {
        MinimumDeletionsToMakeStringBalanced_1653 m = new MinimumDeletionsToMakeStringBalanced_1653();
        System.out.println(m.minimumDeletions("aaabbbbb"));
    }
}
