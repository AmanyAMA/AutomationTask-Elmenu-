package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Pagebase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	//facebook login modal elements locators
	@FindBy (id="email")
	WebElement FbEmailTxt;
	@FindBy(id="pass")
	WebElement FbPasswordTxt;
	@FindBy(id="u_0_0")
	WebElement FbLoginBtn;
	@FindBy(css="div[id=basket-login-tab]>form>div>:nth-child(4)")
	WebElement loginViaFbLink;
	@FindBy(css="button[name='__CONFIRM__']")
	WebElement confirmFbLoginBtn;

	//Login via fb function
	public void UserSwitchToFBToLogin(WebDriver driver,String fbemail, String fbpass) throws InterruptedException
	{
		WebDriverWait Wait ;
		String CurrentWindow = driver.getWindowHandle(); // store current  window
		clickElment(loginViaFbLink);
		Thread.sleep(3000);
		for (String WindowID : driver.getWindowHandles()) {
			String title = driver.switchTo().window(WindowID).getTitle();
			System.out.println(title);
			if(title.equals("Facebook")) {
				 Wait = new WebDriverWait(driver, 15);
				Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
				setText(FbEmailTxt, fbemail);
				setText(FbPasswordTxt, fbpass);
				clickElment(FbLoginBtn);
				driver.switchTo().window(WindowID).getTitle();
				Wait = new WebDriverWait(driver, 15);
				Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[name='__CONFIRM__']")));
				clickElment(confirmFbLoginBtn);
				Thread.sleep(3000);
				break;
			
			}
		}
		driver.switchTo().window(CurrentWindow);
	}

	
	//El Menu login modal locators
		@FindBy(css="input[name='email']")
		WebElement emailTxt;
		
		@FindBy(css="input[name='password']")
		WebElement passtxt;
		
		@FindBy(css="button.submit-btn.uppercase")
		WebElement loginBtn;
		
		@FindBy(css="span.text")
		public WebElement successlogintxt;
		
	//Login via el menu modal function
	public void UserNormalLogin(String mail ,String pass) 
	{
		setText(emailTxt, mail);
		setText(passtxt, pass);
		clickElment(loginBtn);
	}
}
