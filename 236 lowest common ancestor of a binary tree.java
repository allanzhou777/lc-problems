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
        TreeNode temp = root;
        boolean inLeft = hasBoth(temp.left, p, q);
        boolean inRight = hasBoth(temp.right, p, q);
        while (inLeft || inRight) {
            if (inLeft) {
                temp = temp.left;
                inLeft = hasBoth(temp.left, p, q);
                inRight = hasBoth(temp.right, p, q);
            }
            else {
                temp = temp.right;
                inLeft = hasBoth(temp.left, p, q);
                inRight = hasBoth(temp.right, p, q);
            }
        }
        return temp;
        
    }

    private boolean hasBoth(TreeNode node, TreeNode p, TreeNode q) {
        return hasItem(node, p) && hasItem(node, q);
    }

    private boolean hasItem(TreeNode node, TreeNode p) {
        if (node == p) {
            return true;
        }
        if (node == null) {
            return false;
        }
        return hasItem(node.left, p) || hasItem(node.right, p);
    }
}