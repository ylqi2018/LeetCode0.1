

import java.util.ArrayList;
import java.util.List;

public class Combinations77 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<Integer>> combs = new ArrayList<List<Integer>>();
		combs = new Combinations77().combine(4, 2);
	}
	
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combs = new ArrayList<List<Integer>>();
        backtrack(combs, new ArrayList<Integer>(), 1, n, k);
        return combs;
    }
    
    private void backtrack(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
    	if(k == 0) {
    		combs.add(comb);
    		return;
    	}
    	for(int i=start; i<=n; i++) {
    		comb.add(i);
    		backtrack(combs, comb, i+1, n, k-1);
    		comb.remove(comb.size()-1);
    	}
    }

}
