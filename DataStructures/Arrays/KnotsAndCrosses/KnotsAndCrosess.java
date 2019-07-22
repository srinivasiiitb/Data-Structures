/**
 * 
 */
package com.srinivasiiitb.datastructures.arrays;

import java.util.Scanner;

/**
 * @author Srinivas Pakala
 */
public class KnotsAndCrosses {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int tc = s.nextInt();
		
		for(int t=0;t<=tc;t++) {
			
			int m= Integer.valueOf(s.next());
			int n=Integer.valueOf(s.next());
			int k= Integer.valueOf(s.next());
			char[][] a= new char[m][n];
			
			for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					a[i][j] = s.next().charAt(0);
				}
			}
			solveKnotsAndCrosses(m,n,k,a);
		}
		s.close();
		
	}

	private static void solveKnotsAndCrosses(int m, int n, int k, char[][] a) {
		
		int count=0;
		int xCount=0,oCount=0;
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				if(a[i][j]=='x') 
					xCount+=countStreak(m,n,k,a,i,j,'x');
				else
					oCount+=countStreak(m,n,k,a,i,j,'o');
			}
		}
		System.out.println(xCount+" "+oCount);
	}

	private static int countStreak(int m, int n, int k, char[][] a,int i,int j, char string) {
    int count=0;
    int t=1;
		//horizontal check
		while(t<k && i+t<m) {
			if(a[i+t][j]!=string) break;
			if(t==k-1) count++;
			t++;
		}
		t=1;
		//vertical
		while(t<k && j+t<n) {
			if(a[i][j+t]!=string) break;
			if(t==k-1) count++;
			t++;
		}
		t=1;
		while(t<k && (j+t<n && i-t>=0)) {
			if(a[i-t][j+t]!=string) break;
			if(t==k-1) count++;
			t++;
		}
		
		t=1;
		while(t<k && (j-t>=0 && i-t>=0)) {
			if(a[i-t][j-t]!=string) break;
			if(t==k-1) count++;
			t++;
		}	
		return count;
	}
}
