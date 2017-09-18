package interview;

import java.util.Deque;
import java.util.LinkedList;

public class MaximalRectangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        char matrix[][] = {
        		{'1', '0', '1', '0', '0'},
        		{'1', '0', '1', '1', '1'},
        		{'1', '1', '1', '1', '1'},
        		{'1', '0', '1', '1', '0'}};
        MaximalRectangle mr = new MaximalRectangle();
        int maxRectangle = mr.maximalRectangle(matrix);
        System.out.println(maxRectangle);
        assert maxRectangle == 8;
	}
	
	public int maximalRectangle(char[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int[] temp = new int[matrix[0].length];
        int area = 0;
        int maxArea = 0;
        
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<temp.length; j++) {
                if(Character.getNumericValue(matrix[i][j])==0) {
                    temp[j] = 0;
                } else {
                    temp[j] += Character.getNumericValue(matrix[i][j]);
                }
            }
            area = maxHistogram(temp);
            if(area > maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }
    
    public int maxHistogram(int[] heights) {
        Deque<Integer> stack = new LinkedList<Integer>();
        int maxArea = 0;
        int area = 0;
        int i = 0;
        for(i=0; i<heights.length;) {
            if(stack.isEmpty() || heights[i] >= heights[stack.peekFirst()]) {
                stack.offerFirst(i++);
            } else {
                int top = stack.pollFirst();
                if(stack.isEmpty()) {
                    area = heights[top] * i;
                } else {
                    area = heights[top] * (i - stack.peekFirst() - 1);
                }
            }
            if(area > maxArea) {
                maxArea = area;
            }
        }
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
        }
        return maxArea;
    }

}
