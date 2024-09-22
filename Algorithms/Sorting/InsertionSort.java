package com.arrays.sorting;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = { 8, 1, 4, 2, 3 };
		insertionSortOptimized(arr);
		insertionSort(arr);

	}

	public static void insertionSortOptimized(int[] arr) {
		int n = arr.length;
		System.out.println("Array before Sorting: " + Arrays.toString(arr) + "\n");

		long startTime = System.nanoTime();

		// Loop through the array starting from the second element
		for (int i = 1; i < n; i++) {

			// Consider [1, 4, 8, | 2, 3] after 3 iteration
			// i = 3, arr[i] = 2
			int temp = arr[i]; // We pick the element to be sorted i.e '2' place it in temp
			int j = i - 1; // We compare with one position back, i.e. i=3 mean j=2 => j = i-1, arr[2] = 8

			// Starts from the second element (index 1) and iterates through the array.
			// case 1:: j >=0 because. now our goal is to compare 2 with 8, and next 2 with  4, next
			// with 1 so we go j-1, we need to make sure j>=0 so loop doesnt error out
			// Case 2:: we need to compare one back position with temp, 8 > 2, next 4 > 2, next 1 > 2
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j]; // Now, we store the jth value in next [1, 4, 8,| 8, 3] and temp is 2
				j = j - 1; // we move to next part reduting one element i.e we compare 4 with 2 i.e now j become 2 and arr[2] = 4
				// arr[j + 1] = temp; // we made [1, 4, 2,| 8, 3] NOTE THIS ONE CHANGE CAN BE
				// TAKEN OUT OF LOOP THIS IS UNNECESSARY temp be same 2, we compare j elements with 2
				// NEXT LOOP WE HAVE [1, 4, 4, |8 , 3] and 1<4 so loop ends here
			}

			// [1, 4, 4, |8 , 3] 
			arr[j + 1] = temp; // WE ARE SHIFTING THE only temp with J less than so  [1, 2, 4, |8 , 3] WE SAVE TIME 
		   // System.out.println("Sorted array: " + Arrays.toString(arr));
		}
		long endTime = System.nanoTime();
		System.out.println("Time Taken is " + (endTime - startTime) + " nano seconds"); // Time Taken is 709 nano seconds
		System.out.println("\nArray before Sorting: " + Arrays.toString(arr));
	}

	public static void insertionSort(int[] arr) {
		int n = arr.length;
		System.out.println("Array before Sorting: " + Arrays.toString(arr) + "\n");

		long startTime = System.nanoTime();

		// Loop through the array starting from the second element
		for (int i = 1; i < n; i++) {

			// Consider [1, 4, 8, 2, 3] after 3 iteration
			// i = 3, arr[i] = 2
			int temp = arr[i]; // We pick the element to be sorted i.e '2' place it in temp
			int j = i - 1; // We compare with one position back, i.e. i=3 mean j=2 => j = i-1, arr[2] = 8

			// Starts from the second element (index 1) and iterates through the array.
			// case 1:: j >=0 because. now our goal is to compare 2 with 8, and next 2 with
			// 4, next
			// with 1 so we go j-1, we need to make sure j>=0 so loop doesnt error out
			// Case 2:: we need to compare one back position with temp, 8 > 2, next 4 > 2,
			// next 1 > 2
			while (j >= 0 && arr[j] > temp) {
				arr[j + 1] = arr[j]; // Now, we store the jth value in next [1, 4, 8, 8, 3] and temp is 2
				j = j - 1; // we move to next part reduting one element i.e we compare 4 with 2
				arr[j + 1] = temp; // we made [1, 4, 2, 8, 3]
			}

			// System.out.println("Sorted array: " + Arrays.toString(arr));
		}
		long endTime = System.nanoTime();
		System.out.println("Time Taken is " + (endTime - startTime) + " nano seconds"); // Time Taken is 1792 nano
																						// seconds
		System.out.println("\nArray before Sorting: " + Arrays.toString(arr));
	}

}
