package com.github.srinivasiiitb.datastructures;

import java.util.Arrays;
import java.util.Scanner;

public class WarInStringLandings {

	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		
		String strY= s.next();
		String strZ = s.next();
		
		System.out.println(solveWar(strY,strZ));
		s.close();
	}

	private static boolean solveWar(String strY, String strZ) {

		char[] sc1 = strY.toCharArray();
		char[] sc2 = strZ.toCharArray();
		
		Arrays.sort(sc1);
		Arrays.sort(sc2);
		
		if((sc1[0] >= sc2[0]) && sc1[sc1.length-1] >= sc2[sc2.length-1] ||
		   (sc1[0] < sc2[0]) && sc1[sc1.length-1] < sc2[sc2.length-1])
			return true;
		else 
			return false;
	}
}
