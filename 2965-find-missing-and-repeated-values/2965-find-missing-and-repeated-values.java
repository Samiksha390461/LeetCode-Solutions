class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[] ans = new int[2];
        HashSet<Integer> s = new HashSet<>();
        int n = grid[0].length;
        int actualSum=0, expSum;
        int a=0,b;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                actualSum+=grid[i][j];
                if(s.contains(grid[i][j])){
                    a=grid[i][j];
                    ans[0]=a;
                }
                s.add(grid[i][j]);
            }
        }
        expSum = (n*n)* (n*n+1)/2;
        b = expSum + a - actualSum;
        ans[1]=b;
        return ans;
    }
}