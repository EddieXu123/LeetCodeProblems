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
class DeleteNode {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) root.left = deleteNode(root.left, key); // Recursively traverse left subtree
        else if (key > root.val) root.right = deleteNode(root.right, key); // Recursively traverse right subtree
        
        else{ // Otherwise, root.val == key, so there is one of three cases
            if (root.left == null) return root.right; // Either the left child is null, so we return right
            else if(root.right == null) return root.left; // Or right child is null, so we return left
            // Otherwise, the node whose key we care about has children
            int minNode = findMin(root.right); // We swap out the node with the Node in the right subtree with the smallest value (leftmost child in the node's right subtree)
            root.val = minNode; // Swap the value
            root.right = deleteNode(root.right, root.val); // Then delete the minimal value from the right subtree (note the second parameter is root.val)
        }
        
        return root;
    }

    public int findMin(TreeNode node){
        while (node.left != null) { // While the subtree has left children
            node = node.left; // Go left
        }
        
        return node.val; // Return the minimum value of the left subtree
    }
}
