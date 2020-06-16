package utils;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverInitializer {
    private static Properties properties = null;
    private static WebDriver driver = null;
 
    static {
        try {
            properties = new Properties();
            properties.load(
            		DriverInitializer.class.getClassLoader()
            		.getResourceAsStream("application.properties"));
            System.setProperty("webdriver.chrome.driver", properties.getProperty("chrome.path"));
            System.setProperty("webdriver.gecko.driver", properties.getProperty("gecko.path"));
 
            switch (getProperty("browser")) {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                default:
                    driver = new ChromeDriver();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public static WebDriver getDriver() {
        return driver;
    }
    
    public static String getProperty(String key) {
        return properties == null ? null : properties.getProperty(key, "");
    }
}
