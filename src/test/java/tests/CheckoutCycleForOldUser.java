package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CheckOutPage;
import pages.HomePage;
import pages.Location;
import pages.LoginPage;
import pages.RestrauntDetailspage;
import pages.SearchPage;
import org.apache.log4j.Logger;


public class CheckoutCycleForOldUser extends Testbase {

	HomePage homeobj;
	LoginPage loginobj;
	SearchPage searchobj;
	RestrauntDetailspage restDetailsObj;
	Location loctionObj;
	CheckOutPage checkoutObj;

	Logger log = Logger.getLogger(CheckoutCycleForOldUser.class);	

	String fbEmail="amany_atef001@yahoo.com";
	String fbPass="amany24@#$";
	String restname="burger";


	@Test(priority=1)
	public void NavigateTOrestDetails() throws InterruptedException 
	{
		driver.navigate().to("https://elmenus.com/cairo/buffalo-burger-95gm");
		log.info("****************************** Open URl  *****************************************");
		//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);	
		log.info("****************************** Open URl  *****************************************");
	}
	
	@Test(priority=2)
	public void TestaddingitemstoCarts() throws InterruptedException 
	{
		log.info("********************** starting TestaddingitemstoCarts testcase  ******************");
		restDetailsObj =new RestrauntDetailspage(driver);
		restDetailsObj.TestnewOrderitem1();
		//Thread.sleep(30000);
		log.info("********************** Ending TestaddingitemstoCarts testcase  ******************");
	}

	// login through Fb account
	@Test (priority=3)
	public void LoginViaFB() throws InterruptedException  
	{
		log.info("********************** starting LoginViaFB testcase  ******************");
		loginobj= new LoginPage(driver);
		loginobj.UserSwitchToFBToLogin(driver, fbEmail, fbPass);
		log.info("********************** Ending LoginViaFB testcase  *******************");
	}

	//set delivery Location area
	@Test (dependsOnMethods="LoginViaFB",enabled= false,priority=4)
	public void SetDeliveryLocation() throws InterruptedException 
	{
		log.info("****************************** Starting SetDeliveryLocation  test case *****************************************");
		loctionObj.setDeliveryAreaText("maadi");
		Thread.sleep(5000);
		loctionObj.setDeliveryzone();
		log.info("****************************** Ending SetDeliveryLocation test case *****************************************");
	}

	@Test(priority=4)
	public void TestedititemsinCarts() throws InterruptedException 
	{
		log.info("********************** starting TestaddingitemstoCarts testcase  ******************");
		checkoutObj =new CheckOutPage(driver);
		checkoutObj.UserCLickoneditcartItem();
		restDetailsObj.UsereditlorderQuantity();
		Thread.sleep(30000);
		log.info("********************** Ending TestaddingitemstoCarts testcase  ******************");
	}

	//Delete all items from cart
	@Test (enabled= false,dependsOnMethods="SetDeliveryLocation")
	public void DeleteAllItemFromCart() throws InterruptedException 
	{
		log.info("****************************** Starting DeleteAllItemFromCart test case *****************************************");
		checkoutObj = new CheckOutPage(driver);
		checkoutObj.RemoveAllitemFromcart();
		log.info("****************************** Ending DeleteAllItemFromCart test case *****************************************");

	}




	/*	@Test
	public void MultipleWindow() throws InterruptedException {

		String CurrentWindow = driver.getWindowHandle(); // store current  window
		WebElement VisitusBtn = driver.findElement(By.id("visitbutton"));
		VisitusBtn.click();
		Thread.sleep(2000);
		for (String WindowID : driver.getWindowHandles()) {

			String title = driver.switchTo().window(WindowID).getTitle();
			System.out.println(title);
			if(title.equals("Visit Us")) {
				Assert.assertEquals("Visit Us", driver.getTitle());
				//write any code to handel elemnts in visit us page 
				driver.close();
				Thread.sleep(2000);
				break;

			}
		}
		driver.switchTo().window(CurrentWindow);
	}


/*	@DataProvider(name="testData")
	public static Object[][] userData()
	{
		return new Object[][] {{"amany_atef011@yahoo.com" , "amany30@@"}};

	}
	@Test (enabled=false ,priority=5)
	public void registerAndLoginViaFB(String email,String pass)  
	{
		homeobj =new HomePage(driver);
		homeobj.OpenSignUpLink();
		WebDriverWait Wait = new WebDriverWait(driver, 15);
		Wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[class^='facebook-login']")));
		loginobj= new LoginPage(driver);
		try {
			loginobj.UserSwitchToFBToLogin(driver, email, pass);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(loginobj.successlogintxt.getText().contains("Hello"));


	}


/*	
	@Test (enabled= true,dependsOnMethods="USerCanNormalLogin")
	public void UserCanSearchRest() throws InterruptedException 
	{
		searchobj=new SearchPage(driver);
		searchobj.SearchResturant(restname);
		WebDriverWait Wait = new WebDriverWait(driver, 15);
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class^='restaurant-card']>div>div:nth-child(2)>a")));
		searchobj.OpenResturantcard();
	}
	@Test (enabled= true,dependsOnMethods="UserCanSearchRest")
	public void UserChooseItemQuantity() throws InterruptedException 
	{
		restDetailsObj = new RestrauntDetailspage(driver);
		restDetailsObj.ChooseandSetorderDetails();
		loctionObj = new Location(driver);
		loctionObj.setDeliveryAreaText("maadi");
		Thread.sleep(10000);

		WebDriverWait Wait = new WebDriverWait(driver, 15);
		Wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("div[id='zones-list']>ul")));
		loctionObj.setDeliveryzone();
		Thread.sleep(10000);
	}


}*/


}
