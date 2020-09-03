class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String s) {
        String result = s + s;
        return result.substring(1, result.length() - 1).contains(s);
        /*
        int len = s.length();
        for (int i = len / 2; i >= 1; i--) { // loop for divisor to partition string
            if (len % i == 0) { // If it divides evenly into my string.length()
                int m = len / i; // Get how many portions of this substring I'll get
                String sub = s.substring(0, i); // Build up the substring
                StringBuilder b = new StringBuilder();
                for (int j = 0; j < m; j++) {
                    b.append(sub); // Append the substring "portions" times
                }
                
                if (b.toString().equals(s)) return true; // Check if the appended portion equals the original string
            }
        }
        
        return false;
        */
    }
}

/*

Find all lengths that can divide by string evenly.

Once you find this number, divide the strings length by this length (to get how many portions of the substring I can produce)

Afterwards, create the substring.

Then, append this substring (portions) time

return if this new output string equals s




*/
