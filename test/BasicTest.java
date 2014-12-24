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

import org.junit.Before;
import org.junit.Test;

// Package import
import hassler.Basic;

public class BasicTest {

	@Before
	public void initialize() {}

	@Test
	public void test_hello_world() {}

	@Test
	public void test_print() {}

	@Test
	public void test_println() {}

	@Test
	public void test_sum() {
		int[] arr = new int[] {1,2,3};
		assertEquals("Sum of [1,2,3] must be 6", 6, Basic.sum(arr));
	}

	@Test
	public void test_max() {

	}

	@Test
	public void test_min() {

	}

	@Test
	public void test_k_select() {

	}
}