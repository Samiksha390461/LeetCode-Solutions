class Solution {
    public int maximumDifference(int[] nums) {
        int n= nums.length;
        int min = nums[0];
        int ans=-1;
        for(int i=1;i<n;i++){
            if(nums[i]>min){
                int diff = nums[i]-min;
                ans= Math.max(diff,ans);
            }
            min= Math.min(nums[i],min);
        }
        return ans;
        
    }
}