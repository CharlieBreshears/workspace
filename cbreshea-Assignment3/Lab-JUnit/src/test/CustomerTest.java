package test;

import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {

	@Test
	public void testDisplayAddress() {
		String street = "bob st";
		String zip = "85202";
		String x = street + " " + zip;
		CustomerTest class5 = new CustomerTest();
		class5.testDisplayAddressLabel(x);
		
	}

	@Test
	public void testDisplayAddressLabel(String x) {
		String name = "bob";
		String AddressLabel = name + " " + x;
	}

}
