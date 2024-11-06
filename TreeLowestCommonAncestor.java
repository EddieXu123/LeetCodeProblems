/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) return right;
        if (right == null) return left;
        return root;
    }
}

/*
If current node is null, return null
If current node is either p or q, return current node because a node is an ancestor of itself

Recurse left and right subtree for p and q

If both left and right subtrees are non-null, the current node is LCA (p and q are found in different subtrees)
Else, the non-null side is the LCA because both nodes are located in the same subtree


*/
