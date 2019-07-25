/**
 * 
 */
package com.github.srinivasiiitb.datastructures;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author Srinivas Pakala
 *
 */
public class BinaryMadness{

	/**
	 * @param args
	 */
	public static void main(String[] args) {

      Scanner sc= new Scanner(System.in);
		System.out.println(Long.MAX_VALUE);
		short t = Short.valueOf(sc.next());
		for(int tc=0;tc<t;tc++) {
		BigInteger n = new BigInteger(sc.next());	
		String b = n.toString(2);
		System.out.println(b);
		int zc=0;
		int oc= 0;
		for (int i = 0; i < b.length(); i++) {
	        for (int j = i+1; j <= b.length(); j++) {
	            String bb= b.substring(i,j);
	            int c1=0;
	            int c2=0;
	            for(int k=0;k<bb.length();k++) {
	            	if(bb.charAt(k)=='0') c1++;
	            	else c2++;
	            }
	            if(c1%2==1) zc++;
	            if(c2%2==1) oc++;
	        }
	    }
		System.out.println(zc+" "+oc);
		}
		sc.close();
}
	
}
