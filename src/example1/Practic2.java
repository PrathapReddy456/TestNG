package example1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Practic2 {

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
	}

	@Test(priority=1)
	public void Google_Titile_Test()
	{
		String title=driver.getTitle();

		System.out.println(title);

	}

	@Test(priority =3)

	public void LogoTest()
	{
		boolean b = driver.findElement(By.xpath("//*[@id=\'hplogo\']")).isDisplayed();
	}
	
	@Test(priority = 2)
	public void maillinktext()
	{
		boolean b = driver.findElement(By.xpath("//a[@class='gb_P'][contains(text(),'Gmail')]")).isDisplayed();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}


}


