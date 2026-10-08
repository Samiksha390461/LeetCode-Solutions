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
class Quad{
    long max;
    long min;
    long size;
    boolean isBST;
    Quad(long max,long min,long size,boolean isBST){
        this.max=max;
        this.min=min;
        this.size=size;
        this.isBST=isBST;
    }
}
class Solution {
    static long maxSum;
    public int maxSumBST(TreeNode root) {
        maxSum=0;
        helper(root);
        return (int)(maxSum);
    }
    private Quad helper(TreeNode root){
        if(root==null){
            return new Quad(Long.MIN_VALUE,Long.MAX_VALUE,0,true);
        }
        Quad left = helper(root.left);
        Quad right= helper(root.right);
        long val = (long)(root.val);
        long max = Math.max(val,Math.max(left.max,right.max));
        long min = Math.min(val,Math.min(left.min,right.min));
        long size = val+left.size+right.size;
        boolean isBST= left.isBST && right.isBST && (val>left.max) && (val<right.min);
        if(isBST) maxSum=Math.max(size,maxSum);
        return new Quad(max,min,size,isBST);
    }
}