/*
 * Cool Problem: Given a string, find the length of the longest substring without repeating characters.
 *  
 * Basic Idea: Have HashMap storing characters as key and position as values. Have two pointers that define max substring
 * Move right pointer to scan string and update the HashMap. If the character is already in the HashMap, then move the left pointer to the right of the same character last found
 * Note that the two pointers can only move forward.
 * 
 * @author cbmbbz
 * 
 */
import java.util.HashMap;

class LongestSubStringWithoutRepeatingChar {
    public int lengthOfLongestSubstring(String s) {
    	
        if (s.length() == 0 || s == null) {
            return 0;
        }
        
        int max = 0;
        // HashMap storing character and character position as values
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0, j = 0; i < s.length(); ++i) {
        	// If the character already exists
            if (map.containsKey(s.charAt(i))) {
            	// Skip over it by moving the left pointer to the right of the same character last found
                j = Math.max(j, map.get(s.charAt(i)) + 1);
            }
            // Otherwise add the character and index to the map
            map.put(s.charAt(i), i);
            // The maximum length is either the current max or a new max (number of elements between i and j)
            max = Math.max(max, i - j + 1);
        }
        return max;
    }
}
