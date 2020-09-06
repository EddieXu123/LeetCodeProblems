class LargestTimeFromDigits {
    public String largestTimeFromDigits(int[] A) {
        String ans = "";
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    if (i == j || i == k || j == k) continue;
                    String h = "" + A[i] + A[j] + "";
                    String m = "" + A[k] + A[6 - i - j - k];
                    String t = h + ":" + m;
                    if (h.compareTo("24") < 0 &&
                        m.compareTo("60") < 0 &&
                        ans.compareTo(t) < 0) ans = t;
                }
            }
        }
        
        return ans;
    }
}



/*


the first digit can only be 1-2
the second digit can only be 2-3

the third digit can only be 1-6
the last digit can be anything


Questions to ask:
Does 05:21 work or do i have to use all 4 digits always


Sounds like an if else question



[0,1,2]


*/
