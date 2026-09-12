// class Solution {
//     public int[] twoSum(int[] nums, int target) {
//         HashMap<Integer,Integer> map = new HashMap<>();
//         for(int i=0;i<nums.length;i++){
//             int more = target-nums[i];
//             if(map.containsKey(more)){
//                 return new int[] {(map.get(more))+1,i+1};
//             }
//             map.put(nums[i],i);
//         }
//         return new int[] {};
        
//     }
// }
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        int left = 0;
        int right=nums.length-1;
        while(left<right){
            int sum= nums[left]+nums[right];
            if(sum==target){
                ans[0]=left+1;
                ans[1]=right+1;
                return ans;
            }
            else if(sum<target) left++;
            else right--;
        }
        return ans;
    }
}