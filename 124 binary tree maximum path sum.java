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
    private int output;
    public int maxPathSum(TreeNode root) {
        output = Integer.MIN_VALUE;
        TreeNode temp = root;
        traverse(temp);
        return output;

    }
    // go through every node and see which 'peak node' gives the highest path sum
    private void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        output = Math.max(output, maxValTwoPaths(node));
        traverse(node.left);
        traverse(node.right);
        
    }

    // the maximum path value of a path with 'node' as the peak
    private int maxValTwoPaths(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return node.val + Math.max(0, maxValOnePath(node.left)) + Math.max(0, maxValOnePath(node.right));
    }

    // the peak node must be included
    private int maxValOnePath (TreeNode node) {
        if (node == null) {
            return 0;
        }
        int m = Math.max(maxValOnePath(node.right), maxValOnePath(node.left));
        return node.val + Math.max(m, 0);
    }
}

// link to a better solution: https://leetcode.com/problems/binary-tree-maximum-path-sum/solutions/389609/full-explanation-article-with-pseudo-code-beats-java-100-time-and-100-space-solution/