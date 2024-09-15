package com.arrays.sorting;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {

		int[] arr = { 8, 1, 4, 2, 3 };
		bubbleSortBasic(arr);
		bubbleSortOptimised(arr);

	}

	public static void bubbleSortOptimised(int[] arr) {
		int n = arr.length;
		System.out.println("Array before Sorting: " + Arrays.toString(arr));

		long startTime = System.nanoTime();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n -i - 1; j++) { //Here, we reduce iternations in inner loop as last element is already sorted
				
				//For example
				//Run 1 => `[8, 1, 4, 2, 3]`, `8` is moved to the end of the array. After this pass, the array becomes `[1, 4, 2, 3, 8]`, so `8` is already sorted.
				//	8 is sorted and last element is placed as 8, so total limit would be n-0, (where 0 is i), finally n-i-1, 
				//Run 2 => we only need to check the remaining elements `[1, 4, 2, 3]`, which are the first 4 elements of the original array.
				//	4, 8 are sorted, so we can ignore last 2 places. limit will be n-1-1, (i=1), 

				if (arr[j] > arr[j + 1]) { 
					System.out.println(arr[j] + " > " + arr[j + 1]); // here 8 > 1
					int temp = arr[j]; 
					arr[j] = arr[j + 1]; 
					arr[j + 1] = temp; 
				}
			}
		}
		long endTime = System.nanoTime();
		System.out.println("Sorted array: " + Arrays.toString(arr));
		System.out.println("Time Taken is " + (endTime - startTime) + " nano seconds"); //Time Taken is 1209 nano seconds
	}

	public static void bubbleSortBasic(int[] arr) {
		int n = arr.length;
		System.out.println("Array before Sorting: " + Arrays.toString(arr));
		long startTime = System.nanoTime();
		
		// determines the number of passes as each pass in inner loop we check one element and its adjacent
		for (int i = 0; i < n; i++) {
			System.out.println("Outer Loop Element is "+arr[i]); 

			// Actual Swapping & Comparison in Inner loop
			for (int j = 0; j < n - 1; j++) {
				// Checking the inner loops first value with inner loop next value
				if (arr[j] > arr[j + 1]) { // We end up with j+1 reaching array out of bound, we need to iterate only till n-1
					System.out.println(arr[j] + " > " + arr[j + 1]); // here 8 > 1

					// Swap the a[j] with a[j+1]
					int temp = arr[j]; // save current value of arr[j] which is 5, so we can assign back to arr[j+1]
					arr[j] = arr[j + 1]; // now arr[j] and arr[j+1] are same, we have arr[j] = 1 and arr[j+1] = 1
					arr[j + 1] = temp; // now swapping is done, as we assign old arr[j] which is 5 to arr[j+1] from temp
					System.out.println("Sorted array: " + Arrays.toString(arr));
				}
			}
			System.out.println("Sorted array: " + Arrays.toString(arr));
			System.out.println();
		}
		long endTime = System.nanoTime();

		System.out.println("Final Sorted array: " + Arrays.toString(arr));

		System.out.println("Time Taken is " + (endTime - startTime) + " nano seconds"); //Time Taken is 725834 nano seconds
		
		// We still have a problem with unnecessary iterations. As each iteration of `i`
		// moves the largest value to the end, we can skip this last element in
		// subsequent iterations.
		
		
		/*Array before Sorting: [8, 1, 4, 2, 3]
		  Outer Loop Element is 8
		  8 > 1
		  Sorted array: [1, 8, 4, 2, 3]
		  8 > 4
		  Sorted array: [1, 4, 8, 2, 3]
		  8 > 2
		  Sorted array: [1, 4, 2, 8, 3]
		  8 > 3
		  Sorted array: [1, 4, 2, 3, 8]
		  Sorted array: [1, 4, 2, 3, 8]

		  Outer Loop Element is 4
		  4 > 2
		  Sorted array: [1, 2, 4, 3, 8]
		  4 > 3
		  Sorted array: [1, 2, 3, 4, 8]
		  Sorted array: [1, 2, 3, 4, 8]

		  Outer Loop Element is 3
		  Sorted array: [1, 2, 3, 4, 8]
		 
		  Outer Loop Element is 4
		  Sorted array: [1, 2, 3, 4, 8]
		  
		  Outer Loop Element is 8
		  Sorted array: [1, 2, 3, 4, 8]

		  Final Sorted array: [1, 2, 3, 4, 8]
		  Time Taken is 765250 nano seconds*/

	}
}
