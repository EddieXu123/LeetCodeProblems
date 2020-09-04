class PartitionLabels {
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a'] = i;
        }
        
        int last = 0;
        int start = 0;
    
        for (int i = 0; i < s.length(); i++) {
            last = Math.max(last, arr[s.charAt(i) - 'a']);
            if (last == i) {
                list.add(last - start + 1);
                start = last + 1;
            }
        }
        
        return list;
    }
    
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new ArrayList<>();
        backtrack(list, 0, s);
        return list;
    }
    
    public void backtrack(List<Integer> list, int start, String s) {
        if (start >= s.length()) return;
        int max = s.lastIndexOf(s.charAt(start));
        for (int i = start; i < max; i++) {
            max = Math.max(max, s.lastIndexOf(s.charAt(i))); // gets widest window
        }
        list.add(max - start + 1);
        backtrack(list, max + 1, s);
    }
}



/*

Idea: Get the widest margin for each letter in your current margin

HashMap<c, Int>
start at 0 --> lastIndexOf(charAt(0))
Math.max(max, s.lastIndexOf(s.charAt(i)))

lastIndexOf --> O(n)
for Loop ( --> 0 --> N) --> N

O(n^2)

"qiejxqfnqceocmy"

*/
