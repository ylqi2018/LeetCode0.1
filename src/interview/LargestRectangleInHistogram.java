package interview;

import java.util.Deque;
import java.util.LinkedList;

public class LargestRectangleInHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestRectangleInHistogram mh = new LargestRectangleInHistogram();
		int[] heights = {2, 2, 2, 3};
		int maxArea = mh.largestRectangleArea(heights);
		System.out.println(maxArea);
	}
	
	public static int largestRectangleArea(int[] heights) {
		Deque<Integer> stack = new LinkedList<Integer>();
		int maxArea = 0;
		int area = 0;
		int i;
		
		for(i=0; i< heights.length;) {
			if(stack.isEmpty() || heights[stack.peekFirst()] <= heights[i]) {
				stack.offerFirst(i++);
			} else {
				int top = stack.pollFirst();
				if(stack.isEmpty()) {
					area = heights[top] * i;
				} else {
					area = heights[top] * (i - stack.peekFirst() - 1);
				}
				
				if(area > maxArea) {
					maxArea = area;
				}
			}
		}//end of for loop
		
		while(!stack.isEmpty()) {
			int top = stack.pollFirst();
			if(stack.isEmpty()) {
				area = heights[top] * i;
			} else {
				area = heights[top] * (i - stack.peekFirst() - 1);
			}
			
			if(area > maxArea) {
				maxArea = area;
			}
		}//end of while
		return maxArea;
	}//end of largestRectangleArea
	
	// public static int largestRectangleArea(int[] height) {
//  if (height == null || height.length == 0) {
//      return 0;
//  }
//  int[] lessFromLeft = new int[height.length]; // idx of the first bar the left that is lower than current
//  int[] lessFromRight = new int[height.length]; // idx of the first bar the right that is lower than current
//  lessFromRight[height.length - 1] = height.length;
//  lessFromLeft[0] = -1;

//  for (int i = 1; i < height.length; i++) {
//      int p = i - 1;

//      while (p >= 0 && height[p] >= height[i]) {
//          p = lessFromLeft[p];
//      }
//      lessFromLeft[i] = p;
//  }

//  for (int i = height.length - 2; i >= 0; i--) {
//      int p = i + 1;

//      while (p < height.length && height[p] >= height[i]) {
//          p = lessFromRight[p];
//      }
//      lessFromRight[i] = p;
//  }

//  int maxArea = 0;
//  for (int i = 0; i < height.length; i++) {
//      maxArea = Math.max(maxArea, height[i] * (lessFromRight[i] - lessFromLeft[i] - 1));
//  }

//  return maxArea;
//}

}//end of class
