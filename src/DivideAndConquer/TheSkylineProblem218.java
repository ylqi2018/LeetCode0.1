package DivideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class TheSkylineProblem218 {
	
	/**
	 * Represents either start or end of building
	 * @author Xiaohan
	 *
	 */
	static class BuildingPoint implements Comparable<BuildingPoint> {
		int x;
		int height;
		boolean isStart;
		
		@Override
		public int compareTo(BuildingPoint o) {
			// First compare by x
			// If they are same then use this logic
			// If two starts are compared then higher height should be picked first
			// If two ends are compared then lower height building should be picked first
			// If one start and end is compared then start should appear before end
			if(this.x != o.x) {
				return this.x - o.x;
			} else {
				return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
			}
		}	
	}
	
	public List<int[]> getSkyline(int[][] buildings) {
		// For all start and end of building put them into List of BuildingPoint
		BuildingPoint[] buildingPoints = new BuildingPoint[2 * buildings.length];
		int index = 0;
		for(int building[] : buildings) {
			buildingPoints[index] = new BuildingPoint();
			buildingPoints[index].x = building[0];
			buildingPoints[index].height = building[2];
			buildingPoints[index].isStart = true;
			
			buildingPoints[index+1] = new BuildingPoint();
			buildingPoints[index+1].x = building[1];
			buildingPoints[index+1].height = building[2];
			buildingPoints[index+1].isStart = false;
			
			index += 2;
		}
		
		Arrays.sort(buildingPoints);
		
		// Using TreeMap because it gives log time performance
		TreeMap<Integer, Integer> queue = new TreeMap<Integer, Integer>();
		queue.put(0, 1);	// Key=0 and Value=1
		int prevMaxHeight = 0;
		
		List<int[]> result = new ArrayList<int[]>();
		
		for(BuildingPoint buildingPoint : buildingPoints) {
			//If it is a start of building then add the height to map.
			//If height already exists then increment the value
			if(buildingPoint.isStart) {
				queue.compute(buildingPoint.height, (key, value) -> {
					if(value != null) {
						return value+1;
					}
					return 1;
				});
			} else {
				queue.compute(buildingPoint.height, (key, value) -> {
					if(value==1) {
						return null;
					}
					return value-1;
				});
			}
			
			// Peek the current height after addition or removal of building x
			int currentMaxHeight = queue.lastKey();
			if(prevMaxHeight != currentMaxHeight) {
				result.add(new int[]{buildingPoint.x, currentMaxHeight});
				prevMaxHeight = currentMaxHeight;
			}
		}
		return result;

	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
