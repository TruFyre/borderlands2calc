package cmd.borderLands2Calc;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {

	private Calculator calculator;
	private float damage_Test;
	private float fireRate_Test;
	
	private float reloadTime_Test;
	private float clipSize_Test;
	private float ammoPerShot_Test;


	@Before
	public void setUp() throws Exception {
		
		damage_Test = 140f;
		fireRate_Test = 7.8f;
		reloadTime_Test = 3.8f;
		clipSize_Test = 23;
		ammoPerShot_Test = 1;
		
		calculator = new Calculator();
		
	}

	@Test
	public void testRunDps() {
		
		float result = calculator.dps(damage_Test, fireRate_Test);
		
		System.out.println("DPS is: " + result);
		
		assertTrue(result > -1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testRunDpsThrowsIllegalArguementExceptionOnZeroInput(){
		
		float negativeFireRate = -1f;
		calculator.dps(damage_Test, negativeFireRate);
		
	}

	@Test
	public void testRunTrueDps() {
		
		float result = calculator.trueDps(damage_Test, fireRate_Test, reloadTime_Test, clipSize_Test, ammoPerShot_Test);
		
		System.out.println("True DPS is: " + result);
		
		assertTrue(result > -1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testTrueDPSThrowsIllegalArguementExceptionOnNegativeInput(){
		
		float negativeReloadTime = -1f;
		calculator.trueDps(damage_Test, fireRate_Test, negativeReloadTime, clipSize_Test, ammoPerShot_Test);
		
	}

	@Test(expected=IllegalArgumentException.class)
	public void testTrueDPSThrowsIllegalArguementExceptionOnZeroInput(){
		
		float zeroAmmoPerShot = 0;
		calculator.trueDps(damage_Test, fireRate_Test, reloadTime_Test, clipSize_Test, zeroAmmoPerShot);
		
	}
	
}
