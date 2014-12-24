


package hassler;

import java.util.Random;

public class Basic {

	/**
	 * Hello World function
	 * Prints the string "Hello, world!" and returns
	 * @author J. Hassler Thurston
	 * @date December 23, 2014
	*/
	public void hello_world() {
		println("Hello, world!");
	}


	/**
	 * Simple print function
	 * Prints out a string of characters and returns.
	 * @author J. Hassler Thurston
	 * December 23, 2014
	 */
	public void print(String line) {
		System.out.print(line);
	}
	/**
	 * Simple print line function
	 * Prints out a string of characters, followed by a newline.
	 * @author J. Hassler Thurston
	 * December 23, 2014
	 */
	public void println(String line) {
		System.out.println(line);
	}
	/**
	 * Sum function
	 * Returns the sum of an integer array
	 * @author J. Hassler Thurston
	 * December 23, 2014
	 */
	public int sum(int[] arr) {
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
	 */
	public int max(int[] arr) {
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
	 */
	public int min(int[] arr) {
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
	 * @author J. Hassler Thurston
	 * December 23, 2014
	 */
	public int k_select(int[] arr) {
		// pick an element randomly as the pivot
		// stub
		return 0;
	}



}