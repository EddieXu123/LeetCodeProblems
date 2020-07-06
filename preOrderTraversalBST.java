public class preOrderTraversalBST {  // Root, Left, Right
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(result);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            if (current != null) {
                result.add(current.val);
                stack.push(current.left);
                stack.push(current.right);
            }
        }
        
        return result;
    }
    
    
    // Now, for the recursive solution
    
    public List<Integer> preorderRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }
    
    public void preorder(TreeNode root, List<Integer> list) {  // Helper method to fill list with node values
        if (root == null) return;
        list.add(root.val);  // First print current 
        preorder(root.left);  // Recurse left
        preorder(root.right);  // Recurse right
    }
}
