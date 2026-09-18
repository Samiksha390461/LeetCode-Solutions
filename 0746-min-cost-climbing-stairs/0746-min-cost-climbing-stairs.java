class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n= cost.length;
        int[] dp = new int[n+1];
        for(int i=0;i<n+1;i++) dp[i]=-1;
        return Math.min(solveMem(0,cost,dp),solveMem(1,cost,dp));
    }
    private int solveMem(int i,int[] cost,int[] dp){
        if(i>=cost.length) return 0;
        if(dp[i]!=-1) return dp[i];
        dp[i]= cost[i] + Math.min(solveMem(i+1,cost,dp),solveMem(i+2,cost,dp));
        return dp[i];

    }
}
