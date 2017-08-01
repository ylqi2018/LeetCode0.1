import java.util.LinkedList;
import java.util.List;

public class LetterCombinationsofPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String digits = "234";
		new LetterCombinationsofPhoneNumber().letterCombinations(digits);

		//System.out.println(test.peek().length());
	}
	
	public List<String> letterCombinations(String digits) {
		
		LinkedList<String> ans = new LinkedList<String>(); 
		String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		ans.add("");
		
		for(int i=0; i<digits.length(); i++) {
			int x = Character.getNumericValue(digits.charAt(i));
			while(ans.peek().length() == i) {
				String t = ans.remove();
				for(char s: mapping[x].toCharArray()) {
					ans.add(t+s);
				}
			}
		}
		return ans;
	}
	
    public List<String> letterCombinations1(String digits) {
        LinkedList<String> ans = new LinkedList<String>();
		String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        if(digits==null || digits.length()==0) {
            return ans;
        }
        ans.add("");
        String t;
        for(int i=0; i<digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length()==i) {
                t = ans.remove();
                for(char s: mapping[x].toCharArray()) {
                    ans.add(t+s);
                }
            }
        }
        return ans;
    }

}
