package tests;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
	public static WebDriver driver = null;
	 
    @BeforeClass
    public void setup () {
    	String driver_uri = (System.getProperty("user.dir") + "\\resources\\drivers\\chromedriver_83.exe");
    	System.setProperty("webdriver.chrome.driver", driver_uri);
		driver = new ChromeDriver();
		//page load timeout
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		//Implicit wait
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//To maximize browser
		driver.manage().window().maximize();
		//To delete all cookies
		driver.manage().deleteAllCookies();
    }
 
    @AfterClass
    public void teardown () {
    	driver.quit();
    }
}
