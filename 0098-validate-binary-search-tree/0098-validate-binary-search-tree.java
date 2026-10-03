/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair{
    long min;
    long max;
    Pair(long max,long min){
        this.max=max;
        this.min=min;
    }
}
class Solution {
    static boolean flag =true;
    public boolean isValidBST(TreeNode root) {
        flag=true;
        if(root.left==null && root.right==null) return true;
        maxMin(root);
        return flag;    
    }
    Pair maxMin(TreeNode root){
        if(root==null) return new Pair(Long.MIN_VALUE,Long.MAX_VALUE);
        Pair lst = maxMin(root.left);
        Pair rst = maxMin(root.right);
        long max = Math.max(root.val,Math.max(lst.max,rst.max));
        long min = Math.min(root.val,Math.min(lst.min,rst.min));
        if(lst.max>=root.val || rst.min<=root.val) flag=false;
        return new Pair(max,min);
    }
}