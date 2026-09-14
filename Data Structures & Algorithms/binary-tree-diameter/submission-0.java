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
    private int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
     max=0;
     maxlength(root);
     return max;

    }
    public int maxlength(TreeNode root){
        if(root==null)return 0;

        int left=maxlength(root.left);
        int right=maxlength(root.right);
        max= Math.max(max,left+right);
        return 1+Math.max(left,right);
    }
}
