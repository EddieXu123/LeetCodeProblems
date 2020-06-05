class ApplePicking {
    public int totalFruit(int[] tree) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = 0;
        int start = 0; // Start of sliding window
        for (int end = 0; end < tree.length; end++) { // End of sliding window
            map.put(tree[end], map.getOrDefault(tree[end], 0) + 1); // Counting frequency of fruits in basket
            while (map.size() > 2) { // While we are unable to put anymore fruits in the basket
                map.put(tree[start], map.get(tree[start]) - 1); // Decrease the first fruit by one
                if (map.get(tree[start]) == 0) map.remove(tree[start]); // If the fruit is gone, then remove from the map
                start++; // Everytime the first fruit is decreased, we increase (count how many of the first fruit we had in our basket)
            }
            
            max = Math.max(max, end - start + 1); // Return max
        }
        return max;
    }
}
