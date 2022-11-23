package com.maxarraytest;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.maxarray.MaxArrayJunit;

public class MaxArrayTest {

	private MaxArrayJunit maxArray;

	@Before
	public void setUp() throws Exception {
		maxArray = new MaxArrayJunit();
	}

	@After
	public void tearDown() throws Exception {
		maxArray = null;
	}

	@Test
	public void testMaxArray() {
		assertEquals(125, maxArray.getLargest(new int[] { 10, 15, 35, 65, 125 }));
	}

}
