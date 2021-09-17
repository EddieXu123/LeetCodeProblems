class Solution {
  
    /* Brute force solution */
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int min = Integer.MAX_VALUE;
        int localMin = Integer.MAX_VALUE;
        boolean hasAnswer = false;
        
        for (int i = 1; i <= 6; i++) {
            if (exists(tops, bottoms, i)) {
                hasAnswer = true;
                localMin = Math.min(top(tops, bottoms, i), bottom(tops, bottoms, i));
            }
            
            min = Math.min(min, localMin);
        }
        
        return hasAnswer ? min : -1;
    }
    
    public boolean exists(int[] tops, int[] bottoms, int val) {
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != val && bottoms[i] != val) return false;
        }
        
        return true;
    }
    
    public int top(int[] tops, int[] bottoms, int val) {
        int answer = 0;
        
        for (int i = 0; i < tops.length; i++) {
            if (tops[i] != val) answer++;
        }
        
        return answer;
    }
    
    public int bottom(int[] tops, int[] bottoms, int val) {
        int answer = 0;
        
        for (int i = 0; i < bottoms.length; i++) {
            if (bottoms[i] != val) answer++;
        }
        
        return answer;
    }

  
  // Better solution
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int[] top = new int[7];
        int[] bottom = new int[7];
        int[] same = new int[7];
        
        for (int i = 0; i < tops.length; i++) {
            top[tops[i]]++;
            bottom[bottoms[i]]++;
            if (tops[i] == bottoms[i]) {
                same[tops[i]]++;
            }
        }
        
        for (int i = 1; i < 7; i++) {
            if (top[i] + bottom[i] - same[i] == tops.length) {
                return tops.length - Math.max(top[i], bottom[i]);
            }
        }
        
        return -1;
    }
}
