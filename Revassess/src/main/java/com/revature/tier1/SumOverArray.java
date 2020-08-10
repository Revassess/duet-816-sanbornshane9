package com.revature.tier1;

public class SumOverArray {

	public static int IterateAndSum(int[] arr){
		int sum = 0;
		for(int i: arr){
			sum = sum + i;
		}
		return sum;
	}
}
