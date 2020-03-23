/*
 * Longest Palindromic Substring
 * Given a String, return the longest substring that is a palindrome.
 * 
 * Basic Idea: Starting with a left and right pointer in the middle of the string, we want to move the pointers outwards
 * until we either do not have a palindrome or we are outside of our input string. Using this length, we can then find the 
 * maximum palindromic substring.
 */

public class LongestPalindromicSubstring {
  public static String longestPalindrome(String s) {
    if (s.length() == 0) {
      return "";
    }
    
    // Pointers to the start and end of the palindromic substring
    int start = 0;
    int end = 0;
    
    for (int i = 0; i < s.length(); i++) {
    	// We want to iteratively find the maximum bound of the substring
      int len1 = getBounds(s, i, i);
      int len2 = getBounds(s, i, i + 1);
      int len = Math.max(len1, len2);
      
      // If this iteration's bound is greater than all of the previous bounds
      if (len > end - start) {
    	  // We can define our new pointers
        start = i - ((len - 1) / 2);
        end = i + (len/2);
      }
        
    }
    
    return s.substring(start, end + 1);
  }

  
  /* 
   * Helper Method to get the bounds of the longest palindrome
   * @param s, the original input string
   * @param left, right, the left and right pointers starting from the middle to detect indeces of the longest substring
   * @return the length of the longest palindromic substring
   */
  public static int getBounds(String s, int left, int right) {
    if (s.length() == 0 || left > right) {
      return 0;
    }
    
    // We treat upper and lowercase letters the same
    s = s.toLowerCase();
    
    // while we are within our bounds of the string and the substring is a palindrome
    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
    	// Increment the pointers outwards
      left--;
      right++;
    }
    
    // Returning the index
    return right - left - 1;
  }
  
  
  public static void main(String[] args) {
	  System.out.println(longestPalindrome("Racecar"));
	  System.out.println(longestPalindrome("ShcheHannahhaeh"));
	  
  }
  
  
}
