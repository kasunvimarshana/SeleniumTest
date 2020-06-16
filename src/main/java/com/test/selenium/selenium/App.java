package com.test.selenium.selenium;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

/**
 * Hello world!
 *
 */
public class App 
{
	WebDriver driver;
	
    @Test
    public void test() {
    	String driver_uri = (System.getProperty("user.dir") + "\\resources\\drivers\\chromedriver_83.exe");
    	System.setProperty("webdriver.chrome.driver", driver_uri);
    	WebDriver driver = new ChromeDriver();
    	
    	//Applied wait time
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    	//maximize window
    	driver.manage().window().maximize();
    	//open browser with desried URL
    	driver.get("https://www.google.com");
    	//closing the browser
    	driver.close();
    }
}
