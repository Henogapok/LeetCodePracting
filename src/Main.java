import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        System.out.println(fib(4));
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        dp[n-1] = cost[n-1];
        dp[n-2] = cost[n-2];

        for(int i = n-3; i >= 0; i--){
            dp[i] = cost[i] + Math.min(dp[i+1], dp[i+2]);
        }

        return Math.min(dp[0], dp[1]);
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>(numRows);
        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        res.add(firstRow);

        for(int j = 1; j < numRows; j++){
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = res.get(j-1);
            row.add(1);
            for(int i = 1; i < j; i++)
                row.add(prevRow.get(i-1) + prevRow.get(i));
            row.add(1);
            res.add(row);
        }
        return res;
    }

    public static List<Integer> getRow(int rowIndex) {
        List<Integer> curRow = new ArrayList<>();
        List<Integer> prevRow = new ArrayList<>();
        prevRow.add(1);
        if(rowIndex == 0)
            return prevRow;

        for(int i = 1; i <= rowIndex; i++){
            prevRow.clear();
            prevRow.addAll(curRow);
            curRow.clear();
            curRow.add(1);
            for(int j = 1; j < i; j++){
                curRow.add(prevRow.get(j-1) + prevRow.get(j));
            }
            curRow.add(1);
        }
        return curRow;
    }
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buy = prices[0];
        for(int sell : prices){
            if(sell > buy)
                profit = Math.max(profit, sell - buy);
            else
                buy = sell;
        }
        return profit;
    }

    public static boolean isSubsequence(String s, String t) {
        int S = s.length();
        int T = t.length();

        while(S > 0 && T > 0){
            int i = s.length() - S;
            int j = t.length() - T;
            if(s.charAt(i) == t.charAt(j))
                S--;
            T--;
        }
        return S == 0;
    }
    public static int fib(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i <=n; i++){
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
        return dp[n];
    }
    public static int sumSubarrayMins(int[] arr) {
        Map<Integer, Integer> dp = new HashMap<>();
        for(int item : arr){
            dp.put(item, dp.getOrDefault(item, 0)+1);
        }
    }
}