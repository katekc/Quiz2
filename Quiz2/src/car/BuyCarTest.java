package car;

import static org.junit.Assert.*;

import org.junit.Test;

public class BuyCarTest {
	
	@Test
	public void carPaymentTest() {
		BuyCar c = new BuyCar(35000, 0, 60, 10);		
		double expectedVal = 743.65;
		double delta = 0.10; // value within which two doubles are considered to be equal
		
		assertEquals(expectedVal, c.carPayment(), delta);
	}
	
	@Test
	public void totalInterestTest() {
		BuyCar c = new BuyCar(35000, 0, 60, 10);
		double expectedVal = 9618.79;
		double delta = 0.10; // value within which two doubles are considered to be equal
		
		assertEquals(expectedVal, c.totalInterest(), delta);
	}
}
