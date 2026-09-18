class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0) return nums[0];
        int[] dp = new int[n+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=2;i<=n;i++){
            int inclu = nums[i-1]+dp[i-2];
            int exclu = dp[i-1];
            dp[i] =  Math.max(inclu,exclu);
        }
        return dp[n];
        
        
    }
    // private int solveMem(int i,int[] nums,int[] dp){
    //     if(i>=nums.length) return 0;
    //     int inclusive = nums[i] + solveMem(i+2,nums,dp);
    //     int enclusive= solveMem(i+1,nums,dp);
    //     dp[i]= Math.max(inclusive,enclusive);
    //     return dp[i];
    // }
    
}