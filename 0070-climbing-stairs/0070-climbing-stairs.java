class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return solveMem(n,dp);
        // if(n==1) return 1;
        // else if(n==2) return 2;
        // else return climbStairs(n-1) + climbStairs(n-2);

    }
    private int solveMem(int n,int[] dp){
        if(n==1) return 1;
        if(n==2) return 2;
        if(dp[n]!=0) return dp[n];
        dp[n] = solveMem(n-1,dp) + solveMem(n-2,dp);
        return dp[n];
    }
}