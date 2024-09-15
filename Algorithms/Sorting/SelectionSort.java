package com.arrays.sorting;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 8, 1, 4, 2, 3 };
		int n = arr.length;
		System.out.println("Array before Sorting: " + Arrays.toString(arr)+"\n");
		
		long startTime = System.nanoTime();
		
		for (int i = 0; i < n - 1; i++) { // We dont need to swap the last value that is why we have n-1
			int minIndex = i; // Assuming the first element as minmum value

			// Actual Loop where we compare and swap
			for (int j = i + 1; j < n; j++) {   // After each pass, the smallest or largest element is moved to its correct position. 
												// So, next pass, you don't need to compare elements that are already sorted.
												// first run arr[0] is sorted, next arr[0] and arr[1] are sorted
												// For this reason, you start comparing from `i + 1` instead of `0` on each pass, 
												// because the first `i` elements are already sorted. and +1 is as we compare next element

				if (arr[j] < arr[minIndex]) {
					System.out.println(arr[j]+" < "+arr[minIndex]);
					minIndex = j; //We are moving minIndex to j value and continue for rest ie minIndex is now 1 not 0
					//For example
					// 1 < 8, so index of 8 is 0, and index of 1 is 1. We assumed arr[0] as min value, but we have 1 so our min value Index now is 1
					//Continue loop 1<4, 1<2, 1<3. In this round we have 1 as smallest value now we need to swap, bring 1 to sorted part (beginning)
				}
			}
			
			//sorting is done outside the inner loop
			int temp = arr[minIndex]; //We confirmed index 1 is smallest, put the value of min index to temp
			arr[minIndex] = arr[i]; //moving the not minValue to minIndex, i.e in fist round we have 8 in arr[0] and 1 in arr[1] which is arr[minIndex]
			arr[i] = temp; //Now arr[0] will be minValue 
			
			System.out.println("Sorted array: " + Arrays.toString(arr));
		}
		long endTime = System.nanoTime();
		System.out.println("Time Taken is " + (endTime - startTime) + " nano seconds"); //Time Taken is 2041 nano seconds
		System.out.println("\nArray before Sorting: " + Arrays.toString(arr));
	}
	
	/*
	 * Array before Sorting: [8, 1, 4, 2, 3]
	 * 
	 * 1 < 8 
	 * Sorted array: [1, 8, 4, 2, 3] 
	 * 4 < 8 
	 * 2 < 4 
	 * Sorted array: [1, 2, 4, 8, 3]
	 * 3 < 4 
	 * Sorted array: [1, 2, 3, 8, 4] 
	 * 4 < 8 
	 * Sorted array: [1, 2, 3, 4, 8] 
	 * Time Taken is 2041 nano seconds (consider removing sysouts to capture)
	 * 
	 * Array before Sorting: [1, 2, 3, 4, 8]
	 */
}


