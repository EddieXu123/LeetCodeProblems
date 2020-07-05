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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> outerList = new ArrayList<>();
        if (root == null) return outerList;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        
        while (true) {
            int remainingNodes = list.size();
            if (remainingNodes == 0) break;
            
            List<Integer> inner = new ArrayList<>();
            while (remainingNodes > 0) {
                TreeNode current = list.poll();
                inner.add(current.val);
                if (current.left != null) list.add(current.left);
                if (current.right != null) list.add(current.right);
                remainingNodes--;
            }
            
            outerList.add(0, inner);
        }
        
        return outerList;
    }
}
