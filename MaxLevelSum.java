class MaxLevelSum {
    public int maxLevelSum(TreeNode root) {
        if (root == null) return 0;
        
        int maxLevelSum = Integer.MIN_VALUE;
        int currLevel = 0;
        int maxLevel = 0;
        Queue<TreeNode> pq = new LinkedList<>();
        
        pq.add(root);
        while (true) {
            int size = pq.size();
            if (size == 0) break;
            
            int levelSum = 0;
            currLevel++;
            
            while (size > 0) {
                TreeNode current = pq.poll();
                levelSum += current.val;
                if (current.left != null) pq.add(current.left);
                if (current.right != null) pq.add(current.right);
                size--;
            }
            
            if (levelSum > maxLevelSum) {
                maxLevel = currLevel;
                maxLevelSum = levelSum;
            }
        }
        
        return maxLevel;
    }
}
