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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n= inorder.length;
        return build(0,n-1,0,n-1,inorder,postorder);
        
    }
    public static TreeNode build(int postLo,int postHi,int inLo,int inHi,int[] inorder,int[] postorder){
        if(postLo>postHi || inLo>inHi) return null;
        int val= postorder[postHi];
        TreeNode root = new TreeNode(val);
        int r=0;
        for(int i=inLo;i<=inHi;i++){
            if(inorder[i]==val){
                r=i;
                break;
            }
        }
        int cnt=r-inLo;
        root.left=build(postLo,postLo+cnt-1,inLo,r-1,inorder,postorder);
        root.right= build(postLo+cnt,postHi-1,r+1,inHi,inorder,postorder);
        return root;
    }
}