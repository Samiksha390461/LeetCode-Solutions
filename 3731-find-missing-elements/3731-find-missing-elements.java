class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        Arrays.sort(nums);
        ArrayList ans = new ArrayList<>();
        int n=nums.length;
        int sm=nums[0];
        int lg = nums[n-1];
        int j=0;
        for(int i=sm;i<=lg;i++){
            if(nums[j]==i && j<n) j++;
            else ans.add(i);
            
        }
        return ans;
        
    }
}