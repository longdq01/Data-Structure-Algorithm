package greedy;

public class DistributeMoneytoMaximumChildren_2591 {
    public int distMoney(int money, int children) {
        if(money < children)
            return -1;

        money -= children;
        if(money < 7)
            return 0;

        int count = 0;
        while(money >= 7 && children > 0){
            money -= 7;
            children--;
            count++;
        }

        if(money > 0 && children == 0)
            return count - 1;

        if(money == 3 && children == 1){
            return count - 1;
        }
        return count;
    }
}
