class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean[] dp = new boolean[s.length() + 1];
        
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];
        /*

        int current = 0;
        
        while (current < s.length()) {
            for (int i = 0; i < wordDict.size(); i++) {
                String str = s.substring(current, current + wordDict.get(i).length());
                
                if (str.equals(wordDict.get(i))) {
                    current = current + wordDict.get(i).length();
                }
            }
        }
        
        return true;
        */
    }
}


/*
n --> number of words in dictionary
m --> length of string s

for every word in my dictionary
    String currentStr = s.substring(current, current + word.length());
    if (!map.containsKey(currentStr)) return false;
    current = current + word.length() + 1;
}

return true;
}
*/
