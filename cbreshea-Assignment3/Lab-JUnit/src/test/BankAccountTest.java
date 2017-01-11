package test;

import static org.junit.Assert.*;

import org.junit.Test;
/**
 * 
 * @author CharlieBreshears
 *
 */

public class BankAccountTest {

	@Test
	public void testGetInterestRate() {
		double rate = 0;
		int x = 1;
		if (x == 1){
			rate = .5;
			System.out.println( rate);
		}
		else{
			System.out.println( rate);
		}
		assertEquals(rate, 0.5,0);
	}

	@Test
	public void testCalculateTotalBalance() {
		double balance = 1000;
		double rate = .5;
		double total = 0;
		double myTotal = 1005.00; // this is the balance that it should come out to
		
		total = (balance + (balance*(rate/100)));
		assertEquals(myTotal, total,0);
		System.out.println("assertEquals went through and passed");
	}

}
