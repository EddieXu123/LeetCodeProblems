class WordPattern {
    public boolean wordPattern(String pattern, String output) {
        String[] str = output.split(" ");
        if (pattern.length() != str.length) return false;
        HashMap<Character, String> map = new HashMap<>();
        HashMap<String, Character> map1 = new HashMap<>();
        
        for (int i = 0; i < pattern.length(); i++) {
            if (map.containsKey(pattern.charAt(i))) {
                if (!str[i].equals(map.get(pattern.charAt(i)))) return false;
            }
            else {
                if (map1.containsKey(str[i])) {
                    if (pattern.charAt(i) != map1.get(str[i])) return false;
                }
                else {
                    map.put(pattern.charAt(i), str[i]);
                    map1.put(str[i], pattern.charAt(i));
                }
            }
        }
        
        return true;
        
    }
}



/*
hashmap to map letter to string
if letter already exists, the string must be map.get(letter);
the string could also already exist but is mapped to multiple letters, so we need 
to do a double check
*/
