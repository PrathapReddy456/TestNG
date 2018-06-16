package testNG_Topics;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Solutions {
	
	WebDriver driver;
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.google.com");
		driver.navigate().to("http://saibersys.com");
		Actions action = new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//*[@id='aspnetForm']/div[3]/div[1]/div[3]/ul/li[3]/a"));
		action.moveToElement(move).build().perform();
		System.out.println(driver.getTitle());	
	}
	
	@Test
	public void cloud()
	{
		driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[3]/div[1]/div[3]/ul/li[3]/ul/li[1]/a")).click();
		System.out.println(driver.getTitle());
	}
	
	@Test
	public void mobi() {
		
		driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[3]/div[1]/div[3]/ul/li[3]/ul/li[2]/a")).click();
		System.out.println(driver.getTitle());
	}
	
	@Test
	public void Supply() {
		driver.findElement(By.xpath("//*[@id=\"aspnetForm\"]/div[3]/div[1]/div[3]/ul/li[3]/ul/li[3]/a")).click();
		System.out.println(driver.getTitle());
	}

@AfterMethod
public void closes()
{
	driver.close();
	
}

}
