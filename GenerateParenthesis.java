class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        backtrack(output, 0, 0, new StringBuilder(), n);
        return output;
    }
    
    public void backtrack1(List<String> output, int open, int close, String str, int n) {
        if (str.length() == 2*n) {
            output.add(str);
            return;
        }
        
        if (open < n) {
            backtrack1(output, open + 1, close, str + "(", n);
        }
        
        if (close < open) {
            backtrack1(output, open, close + 1, str + ")", n);
        }
    }
    
    
    public void backtrack(List<String> output, int open, int close, StringBuilder sb, int n) {
        if (open == n && close == n) {
            output.add(sb.toString());
            return;
        }
        
        if (open < n) {
            sb.append("(");
            backtrack(output, open + 1, close, sb, n);
            sb.setLength(sb.length() - 1);
        }
        
        if (close < open) {
            sb.append(")");
            backtrack(output, open, close + 1, sb, n);
            sb.setLength(sb.length() - 1);
        }
    }
}
