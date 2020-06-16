package page_factories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePageFactory {
	 
    //*********Constructor*********
    public HomePageFactory (WebDriver driver) {
    	this.driver = driver;
        //This initElements method will create all WebElements
        //PageFactory.initElements(driver, this);
        //lazy loading
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 100);
        PageFactory.initElements(factory, this);
    }
 
    //*********Page Variables*********
    String baseURL = "http://www.n11.com/";
 
    //*********Web Driver*********
    WebDriver driver;
    
    //*********Web Elements*********
    @FindBy(className = "btnSignIn")
    WebElement signInButtonBy;
    
    @FindBy(className = "txtTitle")
    WebElement txtTitle;
    
    //*********Page Methods*********
    //Go to Homepage
    public HomePageFactory goToN11 (){
        driver.get(baseURL);
        return this;
    }
 
    //Get the title
	public String getTitle(){
		return txtTitle.getText();
	}
    
    //Go to LoginPage
    public LoginPageFactory goToLoginPage (){
        signInButtonBy.click();
        return new LoginPageFactory(driver);
    }
}

