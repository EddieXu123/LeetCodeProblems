class PermutationSubsequence {
    // Algorithm --> Index of which number to add is found by doing k-1/(n-1)!
    // Then, k = k - index * (n-1)!
    public String getPermutation(int n, int k) {
        StringBuilder b = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>(); // list to hold the numbers [1, 2, 3...n]
        int[] factorial = new int[n + 1]; // Factorial array to hold the factorials: [1!, 2!, 3!...n!]
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i; // The factorial at i = factorial[i-1] * i
        }
        
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        // Add the numbers to the list, so now list ==> {1, 2, 3, 4, ... n}
        
        for (int i = 1; i <= n; i++) {
            int index = (k-1)/factorial[n-i];
            b.append(Integer.toString(list.get(index)));
            list.remove(index);
            k -= index * factorial[n-i];
        }
        
        return b.toString();
    }
}
