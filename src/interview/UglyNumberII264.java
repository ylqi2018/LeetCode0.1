package interview;

import java.util.Vector;

public class UglyNumberII264 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public int nthUglyNumber(int n) {
		Vector<Integer> res = new Vector<Integer>(1, 1);
		res.add(1);
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		int m2 = 1;
		int m3 = 1;
		int m5 = 1;
		int mn = 0;
		while(res.size() < n) {
			m2 = res.elementAt(i2) * 2;
			m3 = res.elementAt(i3) * 3;
			m5 = res.elementAt(i5) * 5;
			mn = min(m2, m3, m5);
			if(mn == m2) i2++;
			if(mn == m3) i3++;
			if(mn == m5) i5++;
			res.add(mn);
		}
		return res.lastElement();		
	}
	
	private int min(int a, int b, int c) {
		int l = Math.min(a, b);
		return Math.min(l, c);
	}
	
	public int nthUglyNumber1(int n) {
		int[] res = new int[n];
		res[0] = 1;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;
		int m2 = 1;
		int m3 = 1;
		int m5 = 1;
		int mn = 0;
        int i = 1;
		while(i < n) {
			m2 = res[i2] * 2;
			m3 = res[i3] * 3;
			m5 = res[i5] * 5;
			if(m2<=m3 && m2<=m5) {
				i2++;
				res[i] = m2;
			}
            if(m3<=m2 && m3<=m5) {
				i3++;
				res[i] = m3;
			}
            if(m5<=m2 && m5<=m3) {
				i5++;
				res[i] = m5;
			}
            i++;
		}
		return res[n-1];		
	}

}
