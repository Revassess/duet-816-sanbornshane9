package com.revature.tier1;

import java.util.ArrayList;

public class NumberSumLength {

	public static boolean checkNumberPowerLength(long num){
		ArrayList<Long> allDigits = new ArrayList<Long>();
		long length = 0;
		long hold = num;

		while(num > 0){
			length ++;
			allDigits.add(num%10);
			num = num /10;
		}

		int sum = 0;
		for(Long d : allDigits){
			sum = sum + (int)Math.pow(d,length);
		}
		return (hold == sum);
	}
}
