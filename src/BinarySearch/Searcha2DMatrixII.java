package BinarySearch;

public class Searcha2DMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * We start search the matrix from top right corner, initialize the current position to top right corner, 
	 * if the target is greater than the value in current position, 
	 * then the target can not be in entire row of current position because the row is sorted, 
	 * if the target is less than the value in current position, 
	 * then the target can not in the entire column because the column is sorted too. 
	 * We can rule out one row or one column each time, so the time complexity is O(m+n).
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		if(matrix==null || matrix.length==0 || matrix[0].length==0) {
			return false;
		}
		
		int col = matrix[0].length - 1;
		int row = 0;
		
		while(col>=0 && row<matrix.length) {
			if(target < matrix[row][col]) {
				col--;
			} else if(target > matrix[row][col]) {
				row++;
			} else {
				return true;
			}
		}
		return false;
	}

}
