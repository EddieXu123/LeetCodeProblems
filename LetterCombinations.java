class LetterCombinations {
    public List<String> letterCombinations(String digits) {
        List<String> answer = new ArrayList<>();
        if (digits.length() == 0) {
            return answer;
        }
        
        String[] mapping = {
            "0",
            "1",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
        };
        
        recurse(answer, mapping, "", 0, digits);
        return answer;
    }
    
    public void recurse(List<String> answer, String[] mapping, String current, int index, String digits) {
        if (index == digits.length()) {
            answer.add(current);
            return;
        }
        
        String str = mapping[digits.charAt(index) - '0'];
        for (int i = 0; i < str.length(); i++) {
            recurse(answer, mapping, current + str.charAt(i), index + 1, digits);
        }
    }
}
