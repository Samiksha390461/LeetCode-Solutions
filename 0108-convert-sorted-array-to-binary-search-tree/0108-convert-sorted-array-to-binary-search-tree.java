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
class Solution {
    public TreeNode sortedArrayToBST(int[] nums){
        int n= nums.length;
        return convertBST(nums,0,n-1);
    }
    public TreeNode convertBST(int[] nums,int lo,int hi){
        if(lo>hi) return null;
        int mid=(lo+hi)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left=convertBST(nums,lo,mid-1);
        root.right=convertBST(nums,mid+1,hi);
        return root;
    }
    
}