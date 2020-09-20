class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();
        List<Integer> inner = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(output, inner, candidates, target, 0);
        return output;
    }
    
    public void backtrack(List<List<Integer>> output, List<Integer> inner, int[] cand, int sum, int start) {
        if (sum < 0) return;
        else if (sum == 0) {
            output.add(new ArrayList<>(inner));
            return;
        }
        
        for (int i = start; i < cand.length; i++) {
            inner.add(cand[i]);
            backtrack(output, inner, cand, sum - cand[i], i);
            inner.remove(inner.size() - 1);
        }
    }
}

/*
Idea: backtrack
Sort the candidates

subtract the current value from the sum


*/
