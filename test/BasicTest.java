/**
 * BasicTest.java
 * Tests functionality of Basic.java
 * Modified from example in http://cs.lmu.edu/~ray/notes/unittesting/
 * @author J. Hassler Thurston
 * December 24, 2014
 */

// package test;

// JUnit imports
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

// Package import
import hassler.Basic;

public class BasicTest {

	@Before
	public void initialize() {}

	@Test
	public void test_sum() {
		int[] arr = new int[] {1,2,3};
		assertEquals("Sum of [1,2,3] must be 6", 6, Basic.sum(arr));
	}

	@Test
	public void test_max() {
		// the max of the empty set should be -Infinity
		assertEquals("Max of the empty array should be -Infinity", Integer.MIN_VALUE, Basic.max(new int[0]));
		// the max of any one element list should be itself
		int[] arr = new int[] {1,3,-1,-3,2,6,-7,3,0,3};
		int max = 6;
		for (int i = 0; i < arr.length; i++) {
			assertEquals("Max of a one-element list should be itself", arr[i], Basic.max(new int[] {arr[i]}));
		}
		// the max of any list should be greater than all other elements
		for (int i = 0; i < arr.length; i++) {
			assertTrue(arr[i] <= max);
		}
	}

	@Test
	public void test_min() {
		// the min of the empty set should be +Infinity
		assertEquals("Min of the empty array should be +Infinity", Integer.MAX_VALUE, Basic.min(new int[0]));
		// the min of any one element list should be itself
		int[] arr = new int[] {1,3,-1,-3,2,6,-7,3,0,3};
		int min = -7;
		for (int i = 0; i < arr.length; i++) {
			assertEquals("min of a one-element list should be itself", arr[i], Basic.min(new int[] {arr[i]}));
		}
		// the min of any list should be less than all other elements
		for (int i = 0; i < arr.length; i++) {
			assertTrue(min <= arr[i]);
		}
	}

	@Test
	public void test_k_select() {

	}

	@Test
	public void test_combine() {
		// combining an empty 2D array should return the empty array
		int[][] arr1 = new int[][] {};
		assertArrayEquals(new int[] {}, Basic.combine(arr1));
		// combining a 2D array with one element should return a 1-element array
		int[][] arr2 = new int[][] {new int[] {5}};
		assertArrayEquals(new int[] {5}, Basic.combine(arr2));
		// combining a 2D array with one row should return that row
		int[][] arr3 = new int[][] {new int[] {1,3,2,4,-5,1,0}};
		assertArrayEquals(new int[] {1,3,2,4,-5,1,0}, Basic.combine(arr3));
		// combining a 2D array with one column should return an array of those elements
		int[][] arr4 = new int[][] {new int[] {1}, new int[] {2}, new int[] {-1}, new int[] {1}};
		assertArrayEquals(new int[] {1,2,-1,1}, Basic.combine(arr4));
		// combining a 2D array of empty rows should also return the empty array
		int[][] arr5 = new int[][] {new int[] {}, new int[] {}, new int[] {}, new int[] {}, new int[] {}};
		assertArrayEquals(new int[] {}, Basic.combine(arr5));
		// "regular" case
		int[][] arr6 = new int[][] {new int[] {1,2,3}, new int[] {4,1,-1}, new int[] {5,1,2,4,-6}, new int[] {1,0}, new int[] {}};
		assertArrayEquals(new int[] {1,2,3,4,1,-1,5,1,2,4,-6,1,0}, Basic.combine(arr6));
	}
}