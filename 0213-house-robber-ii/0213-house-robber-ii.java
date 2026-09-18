class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int case1 = solveTab(0,n-2,nums);
        int case2 = solveTab(1,n-1,nums);
        return Math.max(case1,case2);
        
    }
    private int solveTab(int start,int end,int[] nums){
        int n = end-start+1;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1]=nums[start];
        for(int i=2;i<=n;i++){
            int take = nums[start+i-1]+ dp[i-2];
            int notTake = dp[i-1];
            dp[i] = Math.max(take,notTake);
        }
        return dp[n];
    }
}