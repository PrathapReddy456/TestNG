package testNG_Topics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url1);
		driver.navigate().to(url2);
	}
	
	
	@Test
	public void Admissions()
	{
		Actions action = new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//*[@id=\"menu-item-57502\"]/a"));
		action.moveToElement(move).build().perform();
		driver.findElement(By.xpath("//*[@id=\"menu-item-57506\"]/a")).click();
		System.out.println(driver.getTitle());
	}
	
	@Test
	public void Graduate() {
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/aside/section[1]/div/div/div[1]/ul/li[5]/a")).click();
		System.out.println(driver.getTitle());
	}
	
	@Test(dependsOnMethods= {"Graduate"})
	public void OnCampus() {
		driver.findElement(By.xpath("//*[@id=\"post-633\"]/div/p[3]/strong/a")).click();
		System.out.println(driver.getTitle());
}
	@Test(dependsOnMethods= {"Graduate","OnCampus"})
	public void CarrerDevelopment() {
		driver.findElement(By.xpath("//*[@id=\"post-633\"]/div/p[3]/strong/a")).click();
		System.out.println(driver.getTitle());
	}
	
	@AfterMethod
	public void closes()
	{
		driver.close();
		
	}
	
}

