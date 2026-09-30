class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);

        Set<List<Integer>> result = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            Set<Integer> set = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                int req = -nums[i] - nums[j];
                if (set.contains(req)) {
                    result.add(Arrays.asList(nums[i], req, nums[j]));
                }
                set.add(nums[j]);
            }
        }
        return new ArrayList<>(result);
    }
}