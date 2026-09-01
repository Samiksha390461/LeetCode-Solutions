class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int ans=0;
        while(i<j){
            int currWater;
            if(height[i]<height[j]){
                currWater=height[i]*(j-i);
                i++;
            }else{
                currWater=height[j]*(j-i);
                j--;
            }
            if(currWater>ans) ans=currWater;
        }
        return ans;
    }
}