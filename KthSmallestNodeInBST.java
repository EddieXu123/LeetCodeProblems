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
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left; // Traverse all the way left
        }
        
        TreeNode current = stack.pop();
        while (current != null) {
            stack.push(current);
            current = current.right;
            TreeNode temp = current;

            while(current.left != null) {
                stack.push(current.left);
                current = current.left;
            }
            current = temp.
        }
    }
}
