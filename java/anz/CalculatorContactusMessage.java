package anz;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;


public class CalculatorContactusMessage {


int nod = 0;  //variable for No. of Dependents
By applicationtypelocator=By.xpath("//label[@for='application_type_single']");
By noofdependentslocator=By.xpath("//*[@title='Number of dependants']");
By optionslocator = By.tagName("option");
WebDriver browser;

public CalculatorContactusMessage()
{
	
//	System.setProperty("webdriver.chrome.driver", "D:\\drivers\\chromedriver.exe");
//	System.setProperty("webdriver.chrome.driver",  "\\src\\main\\resources\\driver\\chromedriver.exe");
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\driver\\chromedriver.exe");

	
	// open browser
	browser = new ChromeDriver();
	// open url
	browser.get("https://www.anz.com.au/personal/home-loans/calculators-tools/much-borrow/");
	browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	browser.manage().window().maximize();
	
	
}

public boolean verifyLoanEligibility2() throws InterruptedException, IOException
{
	
boolean flag=false;	
	// identify Application Type button link
WebElement applicationtype = browser.findElement((By) applicationtypelocator);
applicationtype.click();

//identify options from No. Of Dependents dropdown 

WebElement noofdependents = browser.findElement((By) noofdependentslocator);

List<WebElement> options = noofdependents.findElements((By) optionslocator);

for(WebElement option : options)
{
	if ("nod".contentEquals(option.getText()))
	{
			option.click();
	}
}

	WebElement propertytype = browser.findElement(By.xpath("//label[@for='borrow_type_home']"));
	propertytype.click();
		 
	// WebElement income = browser.findElement(By.id("q2q1"));  
	
	//Enter income
	WebElement income = browser.findElement(By.xpath("//*[@aria-labelledby='q2q1']"));
     income.sendKeys("0");
			
			
			
   //Enter Other income
   WebElement otherincome = browser.findElement(By.xpath("//*[@aria-labelledby='q2q2']"));
   otherincome.sendKeys("0");
				
   //Enter Living expense
   WebElement livexpense = browser.findElement(By.xpath("//*[@id=\"expenses\"]"));
   livexpense.sendKeys("1");
		     
	//Enter Current Loan Repayment Amount
	WebElement currentrepayments = browser.findElement(By.xpath("//*[@id=\"homeloans\"]"));
	currentrepayments.sendKeys("0");
				
	//Enter Other Loan Repayment Amount				
	WebElement otherrepayments = browser.findElement(By.id("otherloans"));
	// WebElement otherrepayments = browser.findElement(By.xpath("//*[@id=\"otherloans\"]"));
	otherrepayments.sendKeys("0");
				
	//Enter Other Commitments
	WebElement othercommitments = browser.findElement(By.xpath("//*[@aria-labelledby='q3q4']"));
	othercommitments.sendKeys("0");
				
	//Enter Credit Card Limits				
	WebElement CreditCardLimit = browser.findElement(By.id("credit"));
	CreditCardLimit.sendKeys("0");
			    
	// wait for 5 sec, we can apply explicit wait to enhance code
	Thread.sleep(5000);
				
	//Click button
				
	//	By.xpath("//*[contains(@class, 'btn--borrow__calculate')]");
	WebElement workoutBttn = browser.findElement(By.xpath("//*[contains(@class, 'btn--borrow__calculate')]"));
	workoutBttn.click();
			    

	// wait for 5 sec, we can apply explicit wait to enhance code
    Thread.sleep(5000);
				
	// find text message
				
						
	WebElement systemmsg = browser.findElement(By.className("borrow__error__text"));
	// System.out.println(systemmsg.getText());
				  
	if (systemmsg.getText().equals("Based on the details you've entered, we're unable to give you an estimate of your borrowing power with this calculator. For questions, call us on 1800 035 500.")) 
				  		
	{
	 flag=true;
	 System.out.println("Test passed");
				
	}
					
	else
	{
	 System.out.println("Test Failed");
	 return flag=false;
	}
				  
    return flag;
}
				

	   
			
	 public void quitdriver(){
					
	browser.quit();
	}
					
}
		



