class Anagrams {
    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        
        if (p.length() > s.length()) return list;
        
        for (Character c : p.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        
        int end = 0;
        int begin = 0;
        // Keep track of if your map has been exhausted or not (if all letters in p have been reached)
        int counter = map.size();
        
        while (end < s.length()) {
            if (map.containsKey(s.charAt(end))) {
                map.put(s.charAt(end), map.get(s.charAt(end)) - 1);
                // Whenever a character in p has been exhausted, decrease the counter
                // When the counter reaches 0, we know we have hit every character in p and can
                // start sliding the begin pointer
                if (map.get(s.charAt(end)) == 0) counter--;
            }
            end++;
            
            while (counter == 0) {
                if (map.containsKey(s.charAt(begin))) {
                    // We want to refill our map once we have found a letter in s
                    map.put(s.charAt(begin), map.get(s.charAt(begin)) + 1);
                    // As soon as we refill a letter, the counter keeping track of the
                    // characters that appear in s that belong to p increments
                    if (map.get(s.charAt(begin)) > 0) {
                        counter++;
                    }
                }
                
                if (end - begin == p.length()) {
                    list.add(begin);
                }
                begin++;
            }
        }
        
        return list;
    }
}
