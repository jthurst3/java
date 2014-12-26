/**
 * Basic.java
 * 
 * Implements basic printing, sum, max, min, and k-select algorithms
 * @author J. Hassler Thurston
 * December 24, 2014
 */

package hassler;

import java.util.Random;

public class Basic {

	/**
	 * Hello World function
	 * Prints the string "Hello, world!" and returns
	 * @author J. Hassler Thurston
	*/
	public static void hello_world() {
		println("Hello, world!");
	}

	/**
	 * Simple print function
	 * Prints out a string of characters and returns.
	 * @author J. Hassler Thurston
	 * December 23, 2014
	 * @param line The line to print
	 */
	public static void print(Object line) {
		System.out.print(line.toString());
	}
	public static void print() {}
	/**
	 * Simple print line function
	 * Prints out a string of characters, followed by a newline.
	 * @author J. Hassler Thurston
	 * December 23, 2014
	 * @param line The line to print
	 */
	public static void println(Object line) {
		System.out.println(line.toString());
	}
	public static void println() {
		println("");
	}
	/**
	 * Print array function
	 * Prints the contents of an integer array
	 * @param message An initial message to print before the array gets printed
	 * @param arr The array of elements to print
	 * @author J. Hassler Thurston
	 */
	public static void printarr(String message, int[] arr) {
		// treat the empty array separately
		if(arr.length == 0) {
			println(message + ": []");
			return;
		}
		print(message + ": [");
		for (int i = 0; i < arr.length-1; i++) {
			print(arr[i] + ", ");
		}
		println(arr[arr.length-1] + "]");
	}
	/**
	 * Print array function
	 * Prints the contents of an integer array, with initial message of "Array contents"
	 * @param arr The array of elements to print
	 * @author J. Hassler Thurston
	 */
	public static void printarr(int[] arr) {
		printarr("Array contents", arr);
	}
	/**
	 * Sum function
	 * Returns the sum of an integer array
	 * @author J. Hassler Thurston
	 * December 23, 2014
	 * @param arr The array of elements
	 * @return The sum of the array
	 */
	public static int sum(int[] arr) {
		int total = 0;
		for (int i = 0; i < arr.length; i++) {
			total += arr[i];
		}
		return total;
	}
	/**
	 * Max function
	 * Returns the maximum value of an element in an array
	 * @author J. Hassler Thurston
	 * December 23, 2014
	 * @param arr The array of elements
	 * @return The maximum element of the array
	 */
	public static int max(int[] arr) {
		int currentMax = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] > currentMax) {
				currentMax = arr[i];
			}
		}
		return currentMax;
	}
	/**
	 * Min function
	 * Returns the minimum value of an element in an array
	 * @author J. Hassler Thurston
	 * December 23, 2014
	 * @param arr The array of elements
	 * @return The minimum element of the array
	 */
	public static int min(int[] arr) {
		int currentMin = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < currentMin) {
				currentMin = arr[i];
			}
		}
		return currentMin;
	}
	/**
	 * k-select function
	 * Returns the k-th smallest element in an array
	 * Runs in linear time, variant of Quicksort
	 * @param arr The input array
	 * @param k The index of the element in the sorted array to return
	 * k starts at 0, so k_select(arr, 0) will return the minimum element.
	 * @author J. Hassler Thurston
	 * December 23, 2014
	 * @return The k-th smallest element of the input array
	 */
	public static int k_select(int[] arr, int k) {
		// base case: check if the array has one or two elements
		if (arr.length <= 2) {
			// sort the two-element array
			arr = Sort.sort(arr);
			// return the k-th smallest element
			return arr[k];
		}
		// pick an element randomly as the pivot
		Random rand = new Random();
		int pivot_index = rand.nextInt(arr.length);
		// put all the elements less than the pivot on the left,
		// and all the elements greater than the pivot on the right
		int new_index = pivot(arr, pivot_index);
		// finally, recurse on the correct half
		// TODO: stub
		return 0;
	}

	/**
	 * pivot function
	 * puts all elements in an array that are less than an element to the left,
	 * and all elements greater than an element to the right
	 * @param arr The array to pivot
	 * @param pivot_index The original index of the pivot element
	 * @author J. Hassler Thurston
	 * @return The index of the pivot element in the new array
	 */
	public static int pivot(int[] arr, int pivot_index) {
		// printarr(arr);
		// throw an exception if the pivot_index is out of bounds
		if (pivot_index < 0 || pivot_index >= arr.length) {
			System.err.println("Pivot index " + pivot_index + " is out of bounds for an array of length " + arr.length + ".");
			return -1;
		}
		// otherwise, swap the pivot element and the first element
		swap(arr, 0, pivot_index);
		// printarr("After first swap", arr);
		// keep two pointers, that each traverse through the list from left to right
		// the first pointer will be the "swap pointer", which will be advanced
		// only when we want to swap an element into its position
		// the second pointer will be the "explore pointer", which will scout out elements
		// to swap earlier
		int swap_p = 1;
		int explore_p = 1;
		while(explore_p < arr.length) {
			// see if we should swap elements between the pointers
			if (arr[explore_p] <= arr[0]) {
				// println("swapping indices " + swap_p + " " + explore_p);
				swap(arr, swap_p++, explore_p++);
				// printarr(arr);
			}
			// otherwise, just advance the explore pointer
			else {
				explore_p++;
			}
		}
		// finally, swap the pivot element with the element just before the explore pointer
		swap(arr, 0, swap_p - 1);
		// printarr("After pivoting completed", arr);
		// and the pivot element will now be at position swap_p
		return swap_p - 1;
	}

	/**
	 * swap function
	 * swaps two elements in an array in-place
	 * @author J. Hassler Thurston
	 * @param arr The array of elements
	 * @param a The first index of an element to swap
	 * @param b The second index of an element to swap
	 */
	public static void swap(int[] arr, int a, int b) {
		int c = arr[a];
		arr[a] = arr[b];
		arr[b] = c;
	}

	/**
	 * Combine function
	 * Combines a list of integer arrays into one long integer array
	 * @param arrays The list of integer arrays to combine
	 * @return A large int[] full of elements from the arrays
	 * @author J. Hassler Thurston
	 */
	public static int[] combine(int[][] arrays) {
		// find the lengths of the smaller arrays
		int[] lengths = new int[arrays.length];
		for (int i = 0; i < arrays.length; i++) {
			lengths[i] = arrays[i].length;
		}
		// sum them up to get the length of the larger (overall) array
		int[] result = new int[sum(lengths)];
		// copy elements
		int counter = 0;
		for (int row = 0; row < arrays.length; row++) {
			for (int col = 0; col < lengths[row]; col++) {
				result[counter++] = arrays[row][col];
			}
		}
		// return the resulting array
		return result;
	}



}