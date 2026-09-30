class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int n =nums.length;
        for(int i=0;i<n-2;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k = n-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum<0) j++;
                else if(sum>0) k--;
                else{
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1]) j++;
                    while(j<k && nums[k]==nums[k+1]) k--;
                }
            }
        }
        return ans;
        
    }
}
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {

//         Arrays.sort(nums);

//         Set<List<Integer>> result = new HashSet<>();

//         for (int i = 0; i < nums.length - 2; i++) {

//             if (i > 0 && nums[i] == nums[i - 1]) {
//                 continue;
//             }
//             Set<Integer> set = new HashSet<>();
//             for (int j = i + 1; j < nums.length; j++) {
//                 int req = -nums[i] - nums[j];
//                 if (set.contains(req)) {
//                     result.add(Arrays.asList(nums[i], req, nums[j]));
//                 }
//                 set.add(nums[j]);
//             }
//         }
//         return new ArrayList<>(result);
//     }
// }