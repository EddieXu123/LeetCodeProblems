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
class SumRootToLeafBinaryTree {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }
    
    public int dfs(TreeNode root, int val) {
        if (root == null) return 0;
        val = val * 2 + root.val; 
        return root.left == null && root.right == null ? 
            val : dfs(root.left, val) + dfs(root.right, val);
    }
}



/*
Idea: First, we can recursively build up each binary number by doing some dfs.
Then, we can turn these binary numbers into base 10 numbers and add the total together.
O(n^2) --> Two passes
O(n) stack, store the numbers in an arraylist or something


Optimized: We can store the base 10 number each time we go down.
if (root.val == 1) {
    answer += Math.pow(2, height)
}

Have a helper function that finds the height of a node
Doesn't help if the leaves are not all at the same level.

val = val * 2 + root.val --> Gives the sum of binary nodes from root to current.


*/
