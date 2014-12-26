/**
 * SortTest.java
 * Tests functionality of Sort.java
 * @author J. Hassler Thurston
 * December 24, 2014
 */

package test.hassler;

// JUnit imports
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.Ignore;

// Package import
import hassler.Sort;

public class SortTest {

	@Before
	public void initialize() {}

	@Test
	public void test_sort_empty() {
		test_sort_array(new int[0]);
	}

	@Test
	public void test_sort_sorted() {
		test_sort_array(new int[] {1,2,3});
	}
	@Test
	public void test_sort_reverse() {
		test_sort_array(new int[] {3,2,1});
	}
	@Test
	public void test_sort_duplicates() {
		test_sort_array(new int[] {1,2,3,2});
	}
	@Test
	public void test_sort_negatives() {
		test_sort_array(new int[] {1,2,3,-1,5,-2,1,1,0});
	}
	@Test
	public void test_sort_double() {
		int[] arr = new int[] {1,2,3,-1,5,-2,1,1,0};
		test_sort_array(arr);
		test_sort_array(Sort.sort(arr));
	}

	public void test_sort_array(int[] arr) {
		int[] sorted = Sort.sort(arr);
		for (int i = 0; i < sorted.length - 1; i++) {
			assertTrue(sorted[i+1] >= sorted[i]);
		}
	}
}