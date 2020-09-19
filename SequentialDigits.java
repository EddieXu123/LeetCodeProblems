class SequentialDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        int[] allNums = {12,23,34,45,56,67,78,89,
                         123,234,345,456,567,678,789,
                         1234,2345,3456,4567,5678,6789,
                         12345,23456,34567,45678,56789,
                         123456,234567,345678,456789,
                         1234567,2345678,3456789,
                         12345678,23456789,
                         123456789};
        List<Integer> res = new ArrayList<>();
        int n = allNums.length;
        for (int i = 0; i < n; i++) {
            if (allNums[i] < low) continue;
            if (allNums[i] > high) break;
            res.add(allNums[i]);
        }
        return res;
    }
    
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> output = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            queue.add(i);
        }
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (low <= current && current <= high) output.add(current);
            int onesDigit = current % 10;
            int nextSequence = current * 10 + onesDigit + 1;
            if (onesDigit < 9 && nextSequence <= high) queue.add(nextSequence);
        }
        
        return output;
    }
}



/*
Brute force --> Create a map with all valid solutions and just add if it's in range

BFS: Add all numbers 1-9 into queue, pop numbers and add to output if between range, if not then we find the one's digit of the number (if it's less than 9 b/c we want to add one to the number so it's sequential) Then, we multiply the current by 10 and add one'sDigit + 1 to the queue if it's less than high






*/
