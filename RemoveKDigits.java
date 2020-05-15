import java.util.*;

public class RemoveKDigits {
  public static String removeKDigits(String s, int k) {
    Stack<Character> stack = new Stack<Character>();
    int i = 0;
    while (i < s.length()) {
      while (k > 0 && !stack.isEmpty() && stack.peek() > s.charAt(i)) {
        k--;
        stack.pop();
      }
      stack.push(s.charAt(i));
      i++;
    }
    
    while (k > 0) {
      stack.pop();
      k--;
    }
    
    StringBuilder b = new StringBuilder();
    while (!stack.isEmpty()) {
      b.append(stack.pop());
    }
    b.reverse();
    
    while (b.charAt(0) == '0' && b.length() > 1) {
      b.deleteCharAt(0);
    }
    
    return b.toString();
  }
    
  public static void main(String[] args) {
    System.out.println(removeKDigits("10200", 1));
  }
}
