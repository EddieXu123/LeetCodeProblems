class ReOrganizeString {
    public String reorganizeString(String S) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Character> pq = new PriorityQueue<>((x, y) -> map.get(y) - map.get(x));
        
        for (Character c : map.keySet()) {
            pq.add(c);
        }
        
        StringBuilder b = new StringBuilder();
        while (pq.size() > 1) {
            char first = pq.poll();
            map.put(first, map.get(first) - 1);
            char second = pq.poll();
            map.put(second, map.get(second) - 1);
            b.append(first);
            b.append(second);
            if (map.get(first) > 0) pq.add(first);
            if (map.get(second) > 0) pq.add(second);
        }
        
        while (!pq.isEmpty()) {
            char c = pq.poll();
            if (map.get(c) > 1) return "";
            b.append(c);
        }
        
        return b.toString();
    }
}
