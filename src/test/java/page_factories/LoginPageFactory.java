package page_factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class LoginPageFactory {
	 
    //*********Constructor*********
    public LoginPageFactory(WebDriver driver) {
    	this.driver = driver;
        //This initElements method will create all WebElements
        //PageFactory.initElements(driver, this);
        //lazy loading
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
        PageFactory.initElements(factory, this);
    }
 
    //*********Web Driver*********
    WebDriver driver;
    
    //*********Web Elements*********
    @FindBy(id = "email")
    WebElement usernameBy;
    
    @FindBy(id = "password")
    WebElement passwordBy;
    
    @FindBy(id = "loginButton")
    WebElement loginButtonBy;
    
    @FindBy(xpath = "//*[@id=\\\"loginForm\\\"]/div[1]/div/div")
    WebElement errorMessageUsernameBy;
    
    @FindBy(xpath = "//*[@id=\\\"loginForm\\\"]/div[2]/div/div")
    WebElement errorMessagePasswordBy;
    
    @FindBy(className = "txtTitle")
    WebElement txtTitle;
    
    //*********Page Methods*********
 
    public LoginPageFactory loginToN11 (String username, String password){
        //Enter Username(Email)
        usernameBy.sendKeys(username);
        //Enter Password
        passwordBy.sendKeys(password);
        //Click Login Button
        loginButtonBy.click();
        return this;
    }
 
    //Get the title
  	public String getTitle(){
  		return txtTitle.getText();
  	}
    
    //Verify Username Condition
    public LoginPageFactory verifyLoginUserName (String expectedText) {
        Assert.assertEquals(errorMessageUsernameBy.getText(), expectedText);
        return this;
    }
 
    //Verify Password Condition
    public LoginPageFactory verifyLoginPassword (String expectedText) {
        Assert.assertEquals(errorMessagePasswordBy.getText(), expectedText);
        return this;
    }
}

