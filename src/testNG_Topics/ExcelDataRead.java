package testNG_Topics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utilities.Utilies;
import utilities2.DataFromExcel;

public class ExcelDataRead {
	WebDriver driver;

	@Parameters({ "Browser", "url1", "url2" })

	@BeforeMethod
	public void setup(String Browser, String url1, String url3) {
		if (Browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (Browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url1);
		driver.navigate().to(url3);
	}

	@Test(dataProvider = "testdata")
	
	public void register(String firstName, String lastName, String emailaddress, String password) {
		driver.findElement(By.xpath("//*[@id='firstname']")).clear();
		driver.findElement(By.xpath("//*[@id='firstname']")).sendKeys(firstName);
		driver.findElement(By.xpath("//*[@id=\"lastname\"]")).sendKeys(lastName);
		driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys(emailaddress);
		driver.findElement(By.xpath("//*[@id=\"PASSWORD\"]")).sendKeys(password);
	}

	@AfterMethod
	public void closes() {
		driver.close();

	}

	@DataProvider
	
	public Iterator<Object[]> testdata() {

		ArrayList<Object[]> data2 = DataFromExcel.getdata(); // Arraylist Store the values
return data2.iterator(); // Iterator pick the values one by one from arraylist
	}

}
