package greedy;

public class LemonadeChange_860 {
    public boolean lemonadeChange(int[] bills) {
        int[] changes = new int[]{0, 0};
        for(int bill: bills){
            if(bill == 10){
                if(changes[0] == 0)
                    return false;
                changes[0] -= 1;
                changes[1] += 1;
            }else if(bill == 20){
                if(changes[1] > 0 && changes[0] > 0){
                    changes[1] -= 1;
                    changes[0] -= 1;
                }else if(changes[1] == 0 && changes[0] >= 3){
                    changes[0] -= 3;
                }else
                    return false;
            }else{
                changes[0] += 1;
            }
        }
        return true;
    }
}
