package com.example.board.problem2;

public class Solution {

    public int solution(int sum, int[] coins) {

        int[] dp = new int[sum + 1];
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                dp[i] += dp[i - coin];
            }
        }

        return dp[sum];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        int sum = 4;
        int[] coins = {1, 2, 3};

        System.out.println(solution.solution(sum, coins));

        sum = 10;
        coins = new int[]{2, 5, 3, 6};

        System.out.println(solution.solution(sum, coins));

        sum = 3;
        coins = new int[]{1, 2, 3, 4};

        System.out.println(solution.solution(sum, coins));
    }
}
