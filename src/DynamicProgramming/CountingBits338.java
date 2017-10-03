package DynamicProgramming;

public class CountingBits338 {
	
	/*
	 * An easy recurrence for this problem is f[i] = f[i/2]+i%2;
	 */
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i=1; i<=num; i++) {
            res[i] = res[i/2] + (i&1);
        }
        return res;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 5;
		CountingBits338 cb = new CountingBits338();
		int[] res = cb.countBits(num);
		System.out.println(res);
	}

}
