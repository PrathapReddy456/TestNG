package testNG_Topics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DataProvider {
	public class Parameterization {
		WebDriver driver;
		@Parameters({"Browser","url1", "url2"})
		@BeforeMethod
		public void setup(String Browser,String url1, String url2)
		{
			if(Browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
			driver = new ChromeDriver();
			}else if(Browser.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver", "E:\\geckodriver.exe");
			driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().setcookies();
			driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(url1);
			driver.navigate().to(url2);
		}
		
		
		@Test(dataProvider="testdata")
		public void Login(String Username, String Password)
		{
			driver.findElement(By.cssSelector("#loginForm > div > input:nth-child(1)")).sendKeys(Username);
			driver.findElement(By.cssSelector("#loginForm > div > input:nth-child(2)")).sendKeys(Password);
			WebElement loginbtn = driver.findElement(By.cssSelector("input[value='Login']"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", loginbtn);
			
			System.out.println(driver.getTitle());
		}
		
		@Test(dependsOnMethods={"Login"})
		public void HomePage() {
			driver.switchTo().frame("mainpanel");
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//*[@id=\'navmenu\']/ul/li[5]/a"))).build().perform();
			driver.findElement(By.xpath("//*[@id=\"navmenu\"]/ul/li[5]/ul/li[1]/a")).click();
		
		}
	
		
	@DataProvider

	public void testdata() {
		Object[][] data = new Object[3][2];
		data[0][0]= "Naveen45";
		data[0][1]="testingcheck";
		data[1][0]="naveenk";
		data[1][1]="test456";
		data[2][0]="naveenk";
		data[2][1]="test@123";
		
	}

		@AfterMethod
		public void closes()
		{
			driver.close();
			
		}
	}
}

