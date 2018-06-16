package example1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Practc1 {

	@BeforeSuite

	public void Setup()
	{
		System.out.println("Set Property");
	}

	


	@BeforeClass
	public void Enter_Url()
	{

		System.out.println("Enter Url");
	}

	@BeforeMethod

	public void login()
	{
		System.out.println("login Feature");
	}

	@BeforeTest

	public void ClearCoockie()
	{
		System.out.println("Before Test");
	}

	@Test

	public void google_title_test()
	{
		System.out.println("google title test");
	}
	
	@Test
	public void googleCycle() {
		System.out.println("Test 2");
	}

	@AfterMethod

	public void Logout()
	{
		System.out.println("Logout");
	}


	@AfterTest

	public void Clear_Coockie()
	{
		System.out.println("Clear Coockie");
	}

	@AfterClass

	public void Close_Broeswr()

	{
		System.out.println("Close Browser");

	}

	@AfterSuite

	public void Test_Reports()
	{
		System.out.println("Test Reports Generated");

	}



}



