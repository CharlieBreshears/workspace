package test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import core.myMagicSquare;

public class myMagicSquareTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testMain() { // fails test when input values are not properly given
		myMagicSquare test1 = new myMagicSquare();
		String output = test1.main("123");
		assertEquals("false", output);
		
	}
	@Test
	public void testMain2(){ // fails because 1 is inputed more than once in the test
		myMagicSquare test2 = new myMagicSquare();
		String output2 = test2.main("111134678");
		assertEquals("false", output2);
		
	}
	@Test
	public void testMain3(){ // here it fails because the sums of the columns, rows, and diagonals don't add up
		myMagicSquare test3 = new myMagicSquare();
		String output3 = test3.main("123456789");
		assertEquals("false", output3);
	}
	@Test
	public void testMain4(){// here is the only test case that will pass
		myMagicSquare test4 = new myMagicSquare();
		String output4 = test4.main("816357429");
		assertEquals("true", output4);
	}

}
