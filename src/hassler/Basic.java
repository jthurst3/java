


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
	public static void print(String line) {
		System.out.print(line);
	}
	/**
	 * Simple print line function
	 * Prints out a string of characters, followed by a newline.
	 * @author J. Hassler Thurston
	 * December 23, 2014
	 * @param line The line to print
	 */
	public static void println(String line) {
		System.out.println(line);
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
			arr = sort(arr);
			// return the k-th smallest element
			return arr[k];
		}
		// pick an element randomly as the pivot
		Random rand = new Random();
		int pivot_index = rand.nextInt(arr.length);
		// put all the elements less than the pivot on the left,
		// and all the elements greater than the pivot on the right
		arr = pivot(arr, pivot_index);
		// finally, recurse on the correct half
		// TODO: stub
		return 0;
	}

	/**
	 * Sort function
	 * Sorts an array of integers (currently using mergesort)
	 * @author J. Hassler Thurston
	 * @param arr The array of elements
	 * @return A sorted version of the array
	 */
	public static int[] sort(int[] arr) {
		return sort_merge(arr);
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
	 * pivot function
	 * puts all elements in an array that are less than an element to the left,
	 * and all elements greater than an element to the right
	 * @param arr The array to pivot
	 * @param pivot_index The original index of the pivot element
	 * @author J. Hassler Thurston
	 * @return A new array with all elements less than the pivot on the left,
	 * and all elements greater than the pivot on the right
	 */
	private static int[] pivot(int[] arr, int pivot_index) {
		// swap the pivot element and the first element
		swap(arr, 0, pivot_index);
		// TODO: stub
		return arr;
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



}