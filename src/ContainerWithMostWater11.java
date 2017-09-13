
public class ContainerWithMostWater11 {
	
	public int maxArea(int[] height) {
		int maxArea = 0;
		for(int i=0; i<height.length; i++) {
			for(int j=i+1; j<height.length; j++) {
				maxArea = Math.max(maxArea, Math.max(height[i], height[j])*(j-i));
			}
		}
		return maxArea;
	}
	
	public int maxArea1(int[] height) {
		int maxArea = 0;
		int l = 0;
		int r = height.length - 1;
		while(l < r) {
			maxArea = Math.max(maxArea, Math.min(height[l], height[r])*(r - l));
			if(height[l] < height[r]) {
				l++;
			} else {
				r++;
			}
		}
		return maxArea;
	}

}
