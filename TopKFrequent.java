class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> output = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        Queue<String> pq = new PriorityQueue<>((a, b) -> map.get(a).equals(map.get(b)) ? b.compareTo(a) : map.get(a) - map.get(b));
        
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        
        for (String key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) pq.poll();
        }
        
        while (k > 0) {
            output.add(pq.poll());
            k--;
        }
        
        Collections.reverse(output);
        return output;
    }
}
