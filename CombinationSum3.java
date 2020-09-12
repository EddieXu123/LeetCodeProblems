class CombinationSum3 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(output, new ArrayList<Integer>(), k, 1, n);
        return output;
    }
    
    public void backtrack(List<List<Integer>> output, List<Integer> inner, int k, int start, int n) {
        if (inner.size() == k && sumOfList(inner) == n && !output.contains(inner)) {
            output.add(new ArrayList<>(inner));
            return;
        }
        // System.out.println(inner.size());
        for (int i = start; i <= 9; i++) {
            if (!inner.contains(i)) {
                inner.add(i);
                backtrack(output, inner, k, i+1, n);
                inner.remove(inner.size() - 1);
            }
        }
    }
    
    public int sumOfList(List<Integer> list) {
        int counter = 0;
        for (int num : list) {
            counter += num;
        }
        
        return counter;
    }
}


/*
SAVE TIME SO YOU DON'T HAVE TO FIND SUM EVERY ITERATION

public List<List<Integer>> combinationSum3(int k, int n) {
    List<List<Integer>> ans = new ArrayList<>();
    combination(ans, new ArrayList<Integer>(), k, 1, n);
    return ans;
}

private void combination(List<List<Integer>> ans, List<Integer> comb, int k,  int start, int n) {
	if (comb.size() == k && n == 0) {
		List<Integer> li = new ArrayList<Integer>(comb);
		ans.add(li);
		return;
	}
	for (int i = start; i <= 9; i++) {
		comb.add(i);
		combination(ans, comb, k, i+1, n-i);
		comb.remove(comb.size() - 1);
	}
}




*/

/*

k ==> number of elements in my inner list
n == sum I want these elements to equal



backtrack() {
if (innerList.size() == k && sum == 7 && !outerList.contains(innerList)) {
    add innerList to outerList;
    return;
}

go through 1 - 9
if (!innerList.contains(num(1-9))) 
add each element and backtrack



}



1) Create helper method to find the sum of elements in a List
iterate through list and keeping counter to return
2) Main method --> Create List<List<Integer>> output = new ArrayList<>();
backtrack(output, new ArrayList<Integer>(), k, n);
return output;
3) backtrack(List<List<Integer>> ouput, List<Integer> inner, int k, int n) {
    
}

*/

