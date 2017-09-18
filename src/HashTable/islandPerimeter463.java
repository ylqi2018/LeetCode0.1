package HashTable;

public class islandPerimeter463 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
    public int islandPerimeter(int[][] grid) {
        int islands = 0;
        int neighbours = 0;
        for(int i=0; i<grid.length; i++) {
        	for(int j=0; j<grid[i].length; j++) {
        		if(grid[i][j] == 1) {
        			islands++;	//count islands
        			if(i<grid.length-1 && grid[i+1][j]==1) neighbours++;	// count down neighbours
        			if(j<grid[i].length-1 && grid[i][j+1]==1) neighbours++;	// count right neighbours
        		}
        	}
        }
        return 4*islands - 2*neighbours;
    }

}
