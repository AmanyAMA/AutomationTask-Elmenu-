package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends Pagebase {

	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css=".not-loggedin .signup-btn")
	WebElement signUpLink;
	 public void OpenSignUpLink() 
	 {
		 clickElment(signUpLink);
	 } 
	 
	
	 
	
	

}
