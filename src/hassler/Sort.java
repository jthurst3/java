/**
 * Sort.java
 * Implements basic sorting algorithms, such as 
 * merge sort, insertion sort, and quicksort
 * @author J. Hassler Thurston
 * December 24, 2014
 */

package hassler;

import java.util.Random;

public class Sort {

	/**
	 * Sort function
	 * Sorts an array of integers (currently using mergesort)
	 * @author J. Hassler Thurston
	 * @param arr The array of elements
	 * @return A sorted version of the array
	 */
	public static int[] sort(int[] arr) {
		return sort_quick(arr);
	}
	/**
	 * Mergesort function
	 * Sorts an array of integers using mergesort
	 * @author J. Hassler Thurston
	 * @param arr The array of elements
	 * @return A sorted version of the array, using mergesort
	 */
	public static int[] sort_merge(int[] arr) {
		// base case: check if the array has one element
		if (arr.length <= 1) {
			return arr;
		}
		// otherwise, recursively sort each half
		int[] left = sort(subarray(arr, 0, arr.length/2));
		int[] right = sort(subarray(arr, arr.length/2, arr.length));
		// and merge the two
		return merge(left, right);
	}

	/**
	 * merge function
	 * Merges two sorted arrays into one larger sorted array
	 * @author J. Hassler Thurston
	 * @param left The first array of elements (called the "left half")
	 * @param right The second array of elements (called the "right half")
	 * @return A new sorted array consisting of all elements from the left half and the right half
	 */
	private static int[] merge(int[] left, int[] right) {
		// create a larger array
		int[] return_arr = new int[left.length + right.length];
		// keep track of where we are in the left and right arrays
		int left_index = 0;
		int right_index = 0;
		// compare elements pairwise
		for (int i = 0; i < left.length + right.length; i++) {
			// first we need to check whether we've already put all elements from one array into
			// the bigger array
			// TODO: at this stage, we should just copy the rest of the array
			if (left_index >= left.length) {
				return_arr[i] = right[right_index++];
			}
			else if (right_index >= right.length) {
				return_arr[i] = left[left_index++];
			}
			// otherwise, we'll see whether the element at the left index
			// is smaller than the element at the right index
			else if (left[left_index] <= right[right_index]) {
				return_arr[i] = left[left_index++];
			}
			else {
				return_arr[i] = right[right_index++];
			}
		}
		// finally, we'll return the array
		return return_arr;
	}

	/**
	 * Subarray function
	 * returns a subarray of a given array, starting at the begin index and
	 * ending at the end index (exclusive)
	 * @author J. Hassler Thurston
	 * @param arr The array of elements
	 * @param begin The beginning index of the subarray in the original array
	 * @param end The ending index of the subarray in the original array
	 * @return A new array consisting of elements between the beginning and ending index of the original array
	 */
	public static int[] subarray(int[] arr, int begin, int end) {
		int[] return_arr = new int[end-begin];
		for (int i = begin; i < end; i++) {
			return_arr[i-begin] = arr[i];
		}
		return return_arr;
	}

	/**
	 * Quicksort function
	 * Sorts an array of integers using the Quicksort algorithm
	 * Pick a random pivot element
	 * Put everything less than or equal to the pivot on the left, and
	 * put everything greater than the pivot on the right
	 * Recursively sort the left and the right half
	 * @author J. Hassler Thurston
	 */
	public static int[] sort_quick(int[] arr) {
		// base case: if the array has 0 or 1 elements, return it
		if (arr.length <= 1) {
			return arr;
		}
		// pick a random pivot element
		Random rand = new Random();
		int pivot_index = rand.nextInt(arr.length);
		// put everything less than or equal to on the left
		// and everything greater on the right
		int new_index = Basic.pivot(arr, pivot_index);
		// recurse on left and right halves
		int[] left = sort_quick(subarray(arr, 0, new_index));
		int[] right = sort_quick(subarray(arr, new_index, arr.length));
		return Basic.combine(new int[][] {left, new int[] {arr[new_index]}, right});
	}
	
}