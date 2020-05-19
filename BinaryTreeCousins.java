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
class BinaryTreeCousins {
    TreeNode yParent = null;
    TreeNode xParent = null;
    int xDepth, yDepth;
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        getDP(root, x, y, 0, null);
        return xDepth == yDepth && yParent != xParent;
    }
    
    public void getDP(TreeNode root, int x, int y, int depth, TreeNode parent) {
        if (root == null) {
            return;
        }
        
        if (root.val == x) {
            xParent = parent;
            xDepth = depth;
        }
        else if (root.val == y) {
            yParent = parent;
            yDepth = depth;
        }
        else {
            getDP(root.left, x, y, depth + 1, root);
            getDP(root.right, x, y, depth + 1, root);
        }
    }
}
