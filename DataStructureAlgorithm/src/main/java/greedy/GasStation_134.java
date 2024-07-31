package greedy;

public class GasStation_134 {
    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length, startIdx = 0;

        while(true){
            if(startIdx >= n)
                return -1;
            int idx = startIdx, tmp = gas[startIdx];
            for (int i = 0; i < n; i++) {
                if(tmp < cost[idx]){
                    if(startIdx > idx)
                        return -1;

                    startIdx = idx + 1;
                    break;
                }
                tmp = tmp - cost[idx] + gas[(idx + 1) % n];
                idx = (idx + 1) % n;
            }

            if(idx == startIdx)
                return startIdx;
        }
    }

    public static void main(String[] args) {
        System.out.println(canCompleteCircuit(new int[]{4}, new int[]{5}));
    }
}
