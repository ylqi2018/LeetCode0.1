package DivideAndConquer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class TheSkylineProblem218 {

	class BuildingPoint implements Comparable<BuildingPoint> {
		int x;				// the x position
		int height;			// the height of the rectangle
		boolean isStart;	// TRUE-start, FALSE-end
		
		@Override
		public int compareTo(BuildingPoint o) {
			// First compare by x
			// If they are different, then compare x position
			// If they are same then use this logic
			//	1. If two starts are compared then higher height building should be picked first
			//	2. If two ends compared then lower height building should be picked first
			//	3. If one start and one end is compared then start should appear before end
			if(this.x != o.x) {
				return this.x - o.x;	// minus means this.x < o.x
			} else {
				// if both starts and (-this.x + o.x) < 0, then this.x > o.x, but pick this.x first
				return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
			}
		}
	}
	
	public List<int[]> getSkyline(int[][] buildings) {
		// For all start and end of buildings put them into List of BuildingPoint
		BuildingPoint[] buildingPoints = new BuildingPoint[2*buildings.length];
		int index = 0;
		for(int[] building : buildings) {
			// The start of this building
			buildingPoints[index] = new BuildingPoint();
			buildingPoints[index].x = building[0];
			buildingPoints[index].height = building[2];
			buildingPoints[index].isStart = true;
			
			// The end of this building
			buildingPoints[index+1] = new BuildingPoint();
			buildingPoints[index+1].x = building[1];
			buildingPoints[index+1].height = building[2];
			buildingPoints[index+1].isStart = false;
			
			index += 2;
		}
		
		Arrays.sort(buildingPoints);
		
		// Using TreeMap because it gives log time performance
		// TreeMap<Key, Value>
		TreeMap<Integer, Integer> queue = new TreeMap<Integer, Integer>();
		queue.put(0, 1);
		int prevMaxHeight = 0;
		List<int[]> result = new ArrayList<int[]>();
		
		for(BuildingPoint buildingPoint : buildingPoints) {
			// If it is start of building then add the height to map.
			// If height already exists then increment the value.
			if(buildingPoint.isStart) {
				queue.compute(buildingPoint.height, (key, value) -> {
					if(value != null) {
						return value + 1;	// If the height already exists then increment the value
					}
					return 1;
				});
			} else {	// If it is end of building then decrement or remove the height from map
				queue.compute(buildingPoint.height, (key, value) -> {
					if(value == 1) {
						return null;
					}
					return value-1;
				});
			}
			// Peek the current height after addition or removal of building x
			int currentMaxHeight = queue.lastKey();	//Returns the last (highest) key currently in this map.
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
