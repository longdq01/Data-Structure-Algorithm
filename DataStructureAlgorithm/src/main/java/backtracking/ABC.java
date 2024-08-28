package backtracking;

import tree.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ABC {
    public static int arraySign(int[] nums) {
        int prod = 1;
        for (int num : nums) {
            prod *= Integer.compare(num, 0);
        }
        return prod;
    }

    public int findLucky(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int max = -1;
        for (int key: map.keySet()){
            if(key == map.get(key)){
                max = Math.max(key, max);
            }
        }
        return max;
    }


    public int Tribonacci(int n) {
        Integer[] dp = new Integer[38];
        dp[0] = 0; dp[1] = 1; dp[2] = 1;

        return util(n, dp);
    }

    public int util(int n, Integer[] dp){
        if(n == 0)
            return 0;
        if(n == 1 || n == 2)
            return 1;

        int d1, d2, d3;
        if(dp[n - 1] == null){
            dp[n - 1] = util(n - 1, dp);
        }
        if(dp[n - 2] == null){
            dp[n - 2] = util(n - 2, dp);
        }
        if(dp[n - 3] == null){
            dp[n - 3] = util(n - 3, dp);
        }
        d1 = dp[n - 1];
        d2 = dp[n - 2];
        d3 = dp[n - 3];

        return d1 + d2 + d3;
    }

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
       if(money == 3 && children == 1)
           return count - 1;
       return count;
    }

    public boolean isPowerOfFour(int n) {
        double tmp = (Math.log(n) / Math.log(4));
        return tmp - (int) tmp == 0;
    }

    public static int reverseBits(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int tmp = n % 2;
            sb.insert(0, tmp);
            n /= 2;
        }
        sb.reverse();
        int res = 0, l = sb.length() - 1;
        for (int i = l; i >= 0; i--) {
            res += (int) Math.pow(2, l - i) * (sb.charAt(i) - '0');
        }
        return res;
    }

    public static int repeatedNTimes(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(i + 1 != nums[i] && nums[i] != nums[nums[i] - 1]){
                int tmp = nums[i];
                nums[i] = nums[tmp - 1];
                nums[tmp - 1] = tmp;
            }
        }

        for (int i = 0; i < n; i++) {
            if(i + 1 != nums[i]){
                return nums[i];
            }
        }
        return -1;
    }

    int findClosestNumber(int[] nums){
        int v = Integer.MAX_VALUE;
        for (int num: nums) {
            if(Math.abs(num) < Math.abs(v)){
                v = num;
            }else if(Math.abs(num) == Math.abs(v) && num > v){
                v = num;
            }
        }
        return v;
    }

    public int omittedNumber(List<Integer> nums) {
        nums.add(0);
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            if(nums.get(i) != i){
                int tmp = nums.get(i);
                nums.set(i, nums.get(tmp));
                nums.set(tmp, tmp);
            }
        }

        for (int i = 0; i < n; i++) {
            if(nums.get(i) != i)
                return i;
        }
        return -1;
    }

    public int maxAscendingSum(int[] nums) {
        int max = nums[0], s = 0, prev = -1;
        for (int num: nums) {
            if(num > prev){
                s += num;
            }else{
                s = num;
            }
            max = Math.max(max, s);
            prev = num;
        }
        return max;
    }

    public int mostFrequentEven(List<Integer> nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num: nums){
            if(num % 2 == 0)
                map.put(num, map.getOrDefault(num, 0) + 1);
        }

        if(map.isEmpty())
            return -1;

        int k = Integer.MAX_VALUE, v = -1;
        for(int key: map.keySet()){
            int val = map.get(key);
            if(val > v || (key < k && val == v)){
                k = key;
                v = val;
            }
        }
        return k;
    }

    public static int numberOfMatches(int n) {
        int match = 0;
        while(n != 1){
            if(n % 2 == 0){
                match += n / 2;
                n = n / 2;
            }
            else{
                match += (n - 1) / 2;
                n = (n - 1) / 2 + 1;
            }
        }
        return match;
    }

    public boolean univalNodes(TreeNode root) {
        if(root == null)
            return true;

        if(root.left != null && root.left.val != root.val)
            return false;

        if(root.right != null && root.right.val != root.val)
            return false;

        return univalNodes(root.left) && univalNodes(root.right);
    }

    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < 2*n; i++) {
            ans[i] = nums[i%n];
        }
        return ans;
    }

    public String sortVowels(String s) {
        int n = s.length();
        List<Character> vowels = List.of('u', 'e', 'o', 'a', 'i', 'U', 'E', 'O', 'A', 'I');
        ArrayList<Character> characters = new ArrayList<>();
        ArrayList<Integer> indexes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(vowels.contains(c)){
                characters.add(c);
                indexes.add(i);
            }
        }

        characters.sort((o1, o2) -> (int) o1 - (int) o2);
        StringBuilder sb = new StringBuilder(s);
        int idx = 0;
        for(int i: indexes){
            sb.replace(i, i + 1, String.valueOf(characters.get(idx++)));
        }
        return sb.toString();
    }

    public int getMaximumGenerated(int n) {
        int[] dp = new int[n];
        dp[0] = 0; dp[1] = 1;
        int max = dp[1];

        for (int i = 2; i < n; i++) {
            if(i % 2 == 0){
                dp[i] = dp[i/2];
            }else{
                dp[i] = dp[i/2] + dp[i/2 + 1];
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty())
                    return false;
                char top = stack.pop();

                if(c == ')'){
                    if(top != '(')
                        return false;
                }else if(c == ']'){
                    if(top != '[')
                        return false;
                }else if(c == '}'){
                    if(top != '{')
                        return false;
                }
            }
        }
        return stack.isEmpty();
    }

    int maxDiameter = Integer.MIN_VALUE;
    public int diameterOfBinaryTree(TreeNode root) {
        return treeHeight(root);
    }

    public int treeHeight(TreeNode root){
        if(root == null)
            return 0;

        int leftHeight = treeHeight(root.left);
        int rightHeight = treeHeight(root.right);
        maxDiameter = Math.max(maxDiameter, leftHeight + rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public List<String> commonChars(String[] A) {
        ConcurrentHashMap<Character, Integer> map = new ConcurrentHashMap<>();
        for(int i = 0; i < A[0].length(); i++){
            char chr = A[0].charAt(i);
            map.put(chr, map.getOrDefault(chr, 0) + 1);
        }

        for (int i = 1; i < A.length; i++) {
            HashMap<Character, Integer> tmp = new HashMap<>();
            for(int j = 0; j < A[i].length(); j++){
                char chr = A[i].charAt(j);
                tmp.put(chr, tmp.getOrDefault(chr, 0) + 1);
            }

            for (Character key: map.keySet()){
                int v1 = map.get(key);
                int v = tmp.getOrDefault(key, 0);
                if(v == 0){
                    map.remove(key);
                }else{
                    map.put(key, Math.min(v, v1));
                }
            }
        }

        ArrayList<String> res = new ArrayList<>();
        for (Character key: map.keySet()) {
            int v = map.get(key);
            for (int i = 0; i < v; i++) {
                res.add(String.valueOf(key));
            }
        }
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> traversals = new ArrayList<>();
        inorderTraversal(root, traversals);
        return traversals;
    }

    public void inorderTraversal(TreeNode root, ArrayList<Integer> traversals){
        if(root == null)
            return;

        inorderTraversal(root.left, traversals);

        traversals.add(root.val);

        inorderTraversal(root.right, traversals);
    }

    public String[] findRelativeRanks(int[] nums) {
        int[] nums1 = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums1);
        HashMap<Integer, String> map = new HashMap<>();
        int tmp = nums1.length - 1;
        for (int i = tmp; i >= 0; i--) {
            if(tmp - i == 0){
                map.put(nums1[i], "Gold Medal");
            }else if(tmp - i == 1){
                map.put(nums1[i], "Silver Medal");
            }else if(tmp - i == 2){
                map.put(nums1[i], "Bronze Medal");
            }else{
                map.put(nums1[i], tmp - i + 1 + "");
            }
        }
        String[] s = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            s[i] = map.get(nums[i]);
        }
        return s;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayList<Integer> dp = new ArrayList<>();

        for (int i = 1; i <= numRows; i++) {
            ArrayList<Integer> dp1 = new ArrayList<>();
            for (int j = 0; j < dp.size() - 1; j++) {
                dp1.add(dp.get(j) + dp.get(j + 1));
            }
            dp1.add(1);
            res.add(dp1);
            if(i > 1){
                dp1.add(0, 1);
            }
            dp = dp1;
        }

        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorderTraversal(root, res);
        return res;
    }

    public void postorderTraversal(TreeNode root, List<Integer> res){
        if(root == null)
            return;

        postorderTraversal(root.left, res);
        postorderTraversal(root.right, res);
        res.add(root.val);
    }

    public int frogJump(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return 0;

        int[] dp = new int[n];
        dp[0] = 0; dp[1] = Math.abs(nums[0] - nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(Math.abs(nums[i] - nums[i - 1]) + dp[i - 1], Math.abs(nums[i] - nums[i - 2]) + dp[i - 2]);
        }
        return dp[n - 1];
    }

    public int commonFactors(int a, int b) {
        int m = Math.min(a, b);
        int count = 0;
        for (int i = 2; i <= m; i++) {
            if(a % i == 0 && b % i == 0)
                count++;
        }
        return count + 1;
    }

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if(isPrime(i))
                count++;
        }
        return count;
    }
    
    public boolean isPrime(int n){
        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }

    public boolean heightBalanced(TreeNode root) {
        if(root == null)
            return true;

        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left - right) > 1)
            return false;
        else return left != -1 && right != -1;
    }

    public int height(TreeNode root){
        if(root == null)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left - right) > 1)
            return -1;
        else if(left == -1 || right == -1)
            return -1;

        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static boolean checkStraightLine(int[][] coordinates) {
        // y = ax + b
        if(coordinates[1][0] - coordinates[0][0] == 0){
            for (int i = 2; i < coordinates.length; i++) {
                if(coordinates[i][0] != coordinates[0][0])
                    return false;
            }
            return true;
        }
        double a = (double) (coordinates[1][1] - coordinates[0][1]) / (coordinates[1][0] - coordinates[0][0]);
        double b = coordinates[1][1] - a * coordinates[1][0];

        for (int i = 2; i < coordinates.length; i++) {
            if(a * coordinates[i][0] + b != coordinates[i][1])
                return false;
        }
        return true;
    }

    public int sumSubarrayMins(int[] arr, int k) {
        Arrays.sort(arr);
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if(i < n / 2){
                min = Math.min(min, arr[i] + k);
                max = Math.max(max, arr[i] + k);
            }else{
                min = Math.min(min, arr[i] - k);
                max = Math.max(max, arr[i] - k);
            }
        }
        return max - min;
    }

    public static void main(String[] args) {
        checkStraightLine(new int[][]{
                {0, 0},
                {   0, -1},
                {0 ,1}

        });
    }
}
