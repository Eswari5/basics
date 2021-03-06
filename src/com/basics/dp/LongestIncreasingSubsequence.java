package com.basics.dp;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

	//if we don't use max, simply print value 'k' returned by lisRec
	//it will be wrong. analyse recursion why this is happening
	//int a[] = {1,3,5,2,3};
	//think why it will fail with below code
	private static int max = Integer.MIN_VALUE;
	
	public static void main(String args[]) {
		int a[] = { 50,3,10,7,40,1};
		int n = a.length;
		lisRec(a, n);
		System.out.println("Recursive result=" + max);
		int k = lisdp(a,n);
		System.out.println("DP result=" + k);
	}

	private static int lisRec(int[] a, int n) { 
		if (n == 0) return 0;
		if (n == 1) return 1;
		
		int res = 1;
		for (int i=1;i<n;i++) {
			int curr = lisRec(a, i);
			if (a[n-1] > a[i-1] && curr+1 > res)
				res = curr + 1;
		}
		
		if (res > max) max = res;
		return res;
	}
	
	private static int lisdp(int[] a, int n) {
		if (n == 0) return 0;
		int t[] = new int[n];
		Arrays.fill(t, 1);
		int max = 0;
		
		for (int i=1;i<n;i++) {
			for (int j=0;j<i;j++) {
				if (a[i] > a[j] && t[j]+1>t[i]) {
					t[i] = t[j] + 1;
				}
			}
		}
		
		for (int i=0;i<n;i++) {
			if (max < t[i]) {
				max = t[i];
			}
		}
		return max;
	}

}