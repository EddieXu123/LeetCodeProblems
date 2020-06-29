class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        StringBuilder b = new StringBuilder();
        String prev = countAndSay(n - 1);
        int i = 0;
        
        while (i < prev.length()) {
            char current = prev.charAt(i);
            int j = i + 1;
            while (j < prev.length() && prev.charAt(j) == current) {
                j++;
            }
            
            b.append(j - i);
            b.append(current);
            i = j;
        }
        
        return b.toString();
    }
}
