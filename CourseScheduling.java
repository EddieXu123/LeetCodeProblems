class CourseScheduling {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int counter = 0;
        
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
        }
        
        LinkedList<Integer> stack = new LinkedList<Integer>();
        
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                stack.push(i);
            }
        }
        
        while (!stack.isEmpty()) {
            int current = stack.poll();
            counter++;
            
            for (int i = 0; i < prerequisites.length; i++) {
                if (current == prerequisites[i][1]) {
                    inDegree[prerequisites[i][0]]--;
                    if (inDegree[prerequisites[i][0]] == 0) {
                        stack.push(prerequisites[i][0]);
                    }
                }
            }
        }
        
        return numCourses == counter;
                                        
    }
}
