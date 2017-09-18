import java.util.Vector;

public class TrappingRainWater42 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
		int ans = new TrappingRainWater42().trap2(height);
		System.out.println(ans);
	}
	
    public int trap(int[] height) {
        int ans = 0;
        int len = height.length;
        for(int i=0; i<len-1; i++) {
        	int max_left = 0;
        	int max_right = 0;
        	// search the left part for max bar size
        	for(int j=i; j>=0; j--) {
        		max_left = Math.max(max_left, height[j]);
        	}
        	for(int j=i; j<len; j++) {
        		max_right = Math.max(max_right, height[j]);
        	}
        	ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }
    
    public int trap1(int[] height) {
    	if(height == null || height.length < 2) {
    		return 0;
    	}
    	
    	int left = height[0];
    	int right = height[height.length - 1];
    	int i = 0;
    	int j = height.length - 1;
    	
    	int res = 0;
    	
    	while(i <= j) {
    		left = Math.max(left, height[i]);
    		right = Math.max(right, height[j]);
    		
    		if(left < right) {
    			res += left - height[i];
    			i++;
    		} else {
    			res += right - height[j];
    			j--;
    		}
    	}
    	return res;
    }
    
    
    public int trap2(int[] height) {
    	//(height == null || height.length<=2) 
    	if(height == null) {
    		return 0;
    	}
    	
    	int ans = 0;
    	int len = height.length;
    	int[] left_max = new int[len];
    	int[] right_max = new int[len];
    	
    	left_max[0] = height[0];
    	for(int i=1; i<len; i++) {
    		left_max[i] = Math.max(height[i], left_max[i-1]);
    	}
    	
    	right_max[len-1] = height[len-1];
    	for(int i=len-2; i>=0; i--) {
    		right_max[i] = Math.max(height[i], right_max[i+1]);
    	}
    	
    	for(int i=1; i<len-1; i++) {
    		ans += Math.min(left_max[i], right_max[i]) - height[i];
    	}
    	
    	return ans;
    }

}
