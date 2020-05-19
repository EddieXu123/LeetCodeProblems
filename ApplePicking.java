class ApplePicking {
    public int totalFruit(int[] tree) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int start = 0;
        for (int end = 0; end < tree.length; end++) {
            map.put(tree[end], map.getOrDefault(tree[end], 0) + 1);
            while (map.size() > 2) {
                map.put(tree[start], map.get(tree[start]) - 1);
                if (map.get(tree[start]) == 0) map.remove(tree[start]);
                start++;
            }
            
            result = Math.max(result, end - start + 1);
        }
        return result;
    }
}
