class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        generate(0,nums,ans,new ArrayList<>()); 
        return ans;   
        
    }
    public void generate(int index,int[] nums,List<List<Integer>> ans,ArrayList<Integer> current){
        ans.add(new ArrayList<>(current));
        for(int i =index;i<nums.length;i++){
            current.add(nums[i]);
            generate(i+1,nums,ans,current);
            current.remove(current.size()-1);
        }

    }
}