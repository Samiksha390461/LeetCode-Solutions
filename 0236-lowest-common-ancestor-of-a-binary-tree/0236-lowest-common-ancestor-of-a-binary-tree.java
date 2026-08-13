/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root==p || root==q) return root;
        boolean pLiesInLeft = exists(root.left,p.val);
        boolean qLiesInLeft = exists(root.left,q.val);
        if(pLiesInLeft && qLiesInLeft) return lowestCommonAncestor(root.left,p,q);
        else if(!pLiesInLeft && !qLiesInLeft) return lowestCommonAncestor(root.right,p,q);
        else return root;
        
    }
    private boolean exists(TreeNode root,int data){
        if(root==null) return false;
        if(root.val==data) return true;
        return exists(root.left,data) || exists(root.right,data);
    }
}