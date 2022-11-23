package com.maxarray;

public class MaxArrayJunit {

	public static int getLargest(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
		}

		return max;

	}
}
