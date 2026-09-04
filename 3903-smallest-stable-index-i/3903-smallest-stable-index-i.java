class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n= nums.length;
        for(int i=0;i<n;i++){
            int max = findMax(nums,0,i);
            int min = findMin(nums,i,n);
            int score = max-min;
            if(score<=k) return i;
        }
        return -1;
        
    }
    public int findMax(int[] arr,int stIdx,int ltIdx){
        int max = Integer.MIN_VALUE;
        for(int i=stIdx;i<=ltIdx;i++){
            if(arr[i]>max) max=arr[i];
        }
        return max;
    }
    public int findMin(int[] arr,int stIdx,int ltIdx){
        int min= Integer.MAX_VALUE;
        for(int i=stIdx;i<ltIdx;i++){
            if(arr[i]<min) min=arr[i];
        }
        return min;
    }
    
}