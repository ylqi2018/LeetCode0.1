
public class MinimumWindowSubstring76 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String minWindow(String s, String t) {
		int[] map = new int[128];
		char[] sc = s.toCharArray();
		for(char c: sc) {
			map[c]++;
		}
		
		int count = t.length();
		int begin = 0;
		int end = 0;
		int d = Integer.MAX_VALUE;
		int head = 0;
		
		while(end < sc.length) {
			if(map[sc[end++]]-- > 0) {
				count--;
			} 
			while(count==0) {
				if(end - begin < d) {
					d = end - (head - begin);
				}
				if(map[sc[begin++]]++==0) {
					count++;
				}
			}
		}
		return d==Integer.MAX_VALUE ? "" : s.substring(head, d);
	}
}
