class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        Set<Integer> visited = new HashSet<>();
        visited.add(start);

        while (!queue.isEmpty()) {
            int currIndex = queue.poll();
            int jumpVal = arr[currIndex];
            if (jumpVal == 0) return true;
            int leftJump = currIndex - jumpVal;
            if (leftJump >= 0 && !visited.contains(leftJump)) {
                queue.add(leftJump);
                visited.add(leftJump);
            }
            int rightJump = currIndex + jumpVal;
            if (rightJump < arr.length && !visited.contains(rightJump)) {
                queue.add(rightJump);
                visited.add(rightJump);
            }        
        }

        return false;
    }
}

