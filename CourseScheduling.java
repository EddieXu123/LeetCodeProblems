class CourseScheduling {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int counter = 0;
        int[] inDegree = new int[numCourses]; // Array to hold onto the number of indegree a node has
        
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++; // If a node has a prerequisite, increment that node
        }
        
        LinkedList<Integer> stack = new LinkedList<>();
        
        for (int i = 0; i < inDegree.length; i++) {
            // We want to start with nodes with no prerequistes. Also, since the classes are labeled 0 to numCourses-1, we know this will be ordered
            if (inDegree[i] == 0) stack.push(i); // If a node does not have a prerequiste, push that into stack
        }
        
        while (!stack.isEmpty()) {
            counter++; // Increment counter to see if we have "taken" all the classes
            int current = stack.poll(); // Take out the class 
            for (int i = 0; i < prerequisites.length; i++) { // Going through original classes
                if (current == prerequisites[i][1]) { // If the original class's prereq is the one we currently have taken
                    inDegree[prerequisites[i][0]]--; // We can take away one OUTdegree
                    if (inDegree[prerequisites[i][0]] == 0) { // If another class has no indegree (because we take away the OUTdegree from another class potentially going into that class)
                        stack.push(prerequisites[i][0]); // Push that class into stack
                    }
                }
            }
        }
        
        return counter == numCourses;
    }
}
