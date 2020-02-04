package anz;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import anz.CalculatorLoanEligiblityCheck;
import anz.CalculatorContactusMessage;

public class anzcalcTest {
	
	CalculatorLoanEligiblityCheck calc= new CalculatorLoanEligiblityCheck();
	CalculatorContactusMessage calc2= new CalculatorContactusMessage(); 
	
	@Test
	public void calcTest() throws InterruptedException, IOException{
		
		Assert.assertEquals(calc.verifyLoanEligibility(), true);
		
		
	}
	@Test
    public void calcTest2() throws InterruptedException, IOException{
		
		Assert.assertEquals(calc2.verifyLoanEligibility2(), true);
		
		
	}
/*	@AfterTest
	public void quitDriver(){
		
		calc.quitdriver(); 
	} */
	

}
