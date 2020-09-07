class LargestOverlap {
    public int largestOverlap(int[][] A, int[][] B) {
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();
        
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length * A.length; i++) {
            // If A[row][column] == 1, add some index indicator variable
            if (A[i / A.length][i % A.length] == 1) {
                listA.add(i / A.length * 100 + i % A.length);
            }
        }
        
        for (int i = 0; i < A.length * A.length; i++) {
            if (B[i / A.length][i % A.length] == 1) {
                listB.add(i / A.length * 100 + i % A.length);
            }
        }
        
        // indexI are all indices in A that equal 1, indexB are all indicies in B that equal 1
        for (int indexI : listA) {
            for (int indexB : listB) {
                // Get the offset and map its frequency
                int offset = indexI - indexB;
                map.put(offset, map.getOrDefault(offset, 0) + 1);
            }
        }
        
        int max = 0;
        for (int key : map.keySet()) {
            max = Math.max(max, map.get(key));
        }
        
        return max;
    }
}



/*

Naive:
function checkOverLap --> Checks if A[index][index1] == B[index][index1] == 1
O(r*c)
Function --> Shifts Matrix A like flood fill
O(n^2)

total --> O(n^4)


Optimized:
Flatten out matrix A and B into lists. Check for which indeces listA == 1 and where listB == 1. To find the offset, subtract i - j and map the frequency. Get the max of this frequency.







*/
