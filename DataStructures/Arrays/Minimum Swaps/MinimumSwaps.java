package com.github.srinivasiiitb.datastructures.arrays;

import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * Minimum Swaps
Swapnil has a matrix of integers and wants to find the minimum number of swaps required to bring the largest element to the center of the matrix. Swaps can be made with horizontally and vertically adjacent elements only.

For a matrix m x n, where m is the number of rows and n the number of columns. For even values of both m and n, there are 4 centers.

He can do it with small matrices but for large ones, he’s lost. Help him solve this problem.

Input Format
The first line contains an integer t denoting the number of test cases. The first line of each test case contains two integers separated by space m and n denoting the number of rows and the number of columns in the matrix respectively. The following m lines describe the matrix. Each line consists of n integers, each i.

Output Format
For each test case, output the minimum number of swaps required. If there are several largest integers, output the minimum required to get any one of them to any one of the center positions.
 */
public class MinimumSwaps{

	static MinimumSwaps ms = new MinimumSwaps();
	
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = Integer.valueOf(sc.next());
        for (int it = 0; it <= t; it++) {
            int m = Integer.valueOf(sc.next());
            int n = Integer.valueOf(sc.next());
    
            long[][] matrix = new long[m][n];
            
            for(int i=0;i<m;i++) {
    			    for(int j=0;j<n;j++) {
    				    matrix[i][j]= Long.valueOf(sc.next());
    			}
    		}
           System.out.println(getMinimumSwaps(m,n,matrix));
        }
        sc.close();
    }

	private static int getMinimumSwaps(int m, int n, long[][] matrix) {
		if(m<=2 && n <=2)
			return 0;
		List<Coordinates> centers = findNoOfCenters(m,n,matrix);
		return getMinimumSwaps(m,n,matrix,centers);
	}

	private static List<Coordinates> findNoOfCenters(int m, int n, long[][] matrix) {
		
		List<Coordinates> centers = new ArrayList<>();
    
		if(m%2 ==0 && n%2 ==0) {
			
			Coordinates center1 = ms.new Coordinates(m/2,n/2);
			Coordinates center2 = ms.new Coordinates((m/2)-1,(n/2)-1);
			Coordinates center3 = ms.new Coordinates((m/2)-1,n/2);
			Coordinates center4 = ms.new Coordinates(m/2,(n/2)-1);
			
			centers.add(center1);
			centers.add(center2);
			centers.add(center3);
			centers.add(center4);
			
		}else if(m%2 == 1 && n%2 ==1) {
			Coordinates center = ms.new Coordinates(m/2,n/2);
			
			centers.add(center);
			
		}else if(m%2 == 0 && n%2 ==1) {
			Coordinates center1 = ms.new Coordinates(m/2,n/2);
			Coordinates center2 = ms.new Coordinates((m/2)-1,n/2);

			centers.add(center1);
			centers.add(center2);
			
		}else if(m%2 == 1 && n%2 ==0) {
			Coordinates center1 = ms.new Coordinates(m/2,(n/2)-1);
			Coordinates center2 = ms.new Coordinates(m/2,n/2);
			
			centers.add(center1);
			centers.add(center2);
		}
		return centers;
	}

	private static int getMinimumSwaps(int m, int n, long[][] matrix, List<Coordinates> centers) {
	
		long max = matrix[0][0];
		TreeMap<Long,Integer> swaps = new TreeMap<>();
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(matrix[i][j] >= max) {
					max = matrix[i][j];
					for(int k=0;k<centers.size();k++) {
						int distance = Math.abs(i-centers.get(k).i)+ Math.abs(j-centers.get(k).j);
						if(swaps.get(max)==null) 
							swaps.put(max, distance);
						else if(swaps.get(max)!=null && distance<swaps.get(max))
							swaps.put(max, distance);
					}
				}
			}
		}
		if(!swaps.isEmpty()) {
			Entry<Long,Integer> maxElem = swaps.lastEntry();
			return maxElem.getValue();
		}
		return 0;	
	}
	
	class Coordinates{
		public int i;
		public int j;
		public Coordinates(int i,int j) {
			this.i=i;
			this.j = j;
		}
	}
}
