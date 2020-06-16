package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
	 
    //*********Constructor*********
    public HomePage (WebDriver driver) {
        super(driver);
    }
 
    //*********Page Variables*********
    String baseURL = "http://www.n11.com/";
 
    //*********Web Elements*********
    By signInButtonBy = By.className("btnSignIn");
    By txtTitle = By.className("txtTitle");
    
    //*********Page Methods*********
    //Go to Homepage
    public HomePage goToN11 (){
        driver.get(baseURL);
        return this;
    }
 
    //Get the title
	public String getTitle(){
		return readText(txtTitle);
	}
    
    //Go to LoginPage
    public LoginPage goToLoginPage (){
        click(signInButtonBy);
        return new LoginPage(driver);
    }
}
