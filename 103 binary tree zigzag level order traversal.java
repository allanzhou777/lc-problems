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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // go through the binary tree in in-order traversal
        // if level % 2 == 0, add to end
        // if level % 2 == 1, add to beginning -> add(0, item)
        List<List<Integer>> l = new ArrayList<>();
        helper(root, 0, l);
        return l;
    }

    private void helper(TreeNode node, int level, List<List<Integer>> l) {
        if (node != null) {
            if (level + 1 > l.size()) {
                List<Integer> mini = new ArrayList<>();
                if (level % 2 == 0) {
                    mini.add(node.val);
                }
                else {
                    mini.add(0, node.val);
                }
                l.add(mini);
            }
            else {
                if (level % 2 == 0) {
                    l.get(level).add(node.val);
                }
                else {
                    l.get(level).add(0, node.val);
                }
            }
            // if else statements could be a bit neater, but eh
            helper(node.left, level + 1, l);
            helper(node.right, level + 1, l);

        }
    }
}