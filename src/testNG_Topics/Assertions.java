package testNG_Topics;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Assertions {
	public void test() {
	
		SoftAssert softAssert = new SoftAssert();
	
		System.out.println("Launch Browser");
	
	Assert.assertEquals(false, true); // Hard assertion
	System.out.println("enter UserName");
	System.out.println("enter Password");
	System.out.println("Click Login");
	System.out.println("Validadte Home Page");
	
	softAssert.assertEquals(true, false,"Test case failed"); // Soft assert
	
	System.out.println("go to deal Page");
	System.out.println("create new deal");
	System.out.println("go to contact Page");
	System.out.println("create contact");
	
	softAssert.assertAll();
}
}
