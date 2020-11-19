package tests;

import org.testng.annotations.Test;
import pages.CheckOutPage;
import pages.HomePage;
import pages.Location;
import pages.LoginPage;
import pages.RestrauntDetailspage;
import pages.SearchPage;
import org.apache.log4j.Logger;

public class secondEditOrderQuantity extends Testbase {

	HomePage homeobj;
	LoginPage loginobj;
	SearchPage searchobj;
	RestrauntDetailspage restDetailsObj;
	Location loctionObj;
	CheckOutPage checkoutObj;

	Logger log = Logger.getLogger(secondEditOrderQuantity.class);	

	String fbEmail="amanymmm07@gmail.com";
	String fbPass="Aa@123456";
	String restname="burger";


	@Test(priority=1)
	public void NavigateTOrestDetails() throws InterruptedException 
	{
		driver.navigate().to("https://elmenus.com/cairo/buffalo-burger-95gm");
		log.info("****************************** Open URl  *****************************************");
		//driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);	
	}
	
	@Test(priority=2)
	public void TestaddingitemstoCarts() throws InterruptedException 
	{
		log.info("********************** starting TestaddingitemstoCarts testcase  ******************");
		restDetailsObj =new RestrauntDetailspage(driver);
		restDetailsObj.TestnewOrderitem1();
		Thread.sleep(10000);
		log.info("********************** Ending TestaddingitemstoCarts testcase  ******************");
	}

	// login through Fb account
	@Test (priority=3)
	public void LoginViaFB() throws InterruptedException  
	{
		log.info("********************** starting LoginViaFB testcase  ******************");
		loginobj= new LoginPage(driver);
		loginobj.UserSwitchToFBToLogin(driver, fbEmail, fbPass);
		Thread.sleep(5000);
		log.info("********************** Ending LoginViaFB testcase  *******************");
	}

	//set delivery Location area
	@Test (dependsOnMethods="LoginViaFB")
	public void SetDeliveryLocation() throws InterruptedException 
	{
		
		log.info("****************************** Starting SetDeliveryLocation  test case *****************************************");
		loctionObj.setDeliveryAreaText("maadi");
		Thread.sleep(5000);
		loctionObj.setDeliveryzone();
		log.info("****************************** Ending SetDeliveryLocation test case *****************************************");
	}

	@Test(dependsOnMethods= "SetDeliveryLocation",priority=5)
	public void TestedititemsinCarts() throws InterruptedException 
	{
		log.info("********************** starting TestedititemsinCarts testcase  ******************");
		checkoutObj =new CheckOutPage(driver);
		checkoutObj.UserCLickoneditcartItem();
		restDetailsObj.UsereditlorderQuantity();
		Thread.sleep(30000);
		log.info("********************** Ending TestedititemsinCarts testcase  ******************");
	}

	//Delete all items from cart
	@Test (priority=6)
	public void DeleteAllItemFromCart() throws InterruptedException 
	{
		log.info("****************************** Starting DeleteAllItemFromCart test case *****************************************");
		checkoutObj = new CheckOutPage(driver);
		checkoutObj.RemoveAllitemFromcart();
		log.info("****************************** Ending DeleteAllItemFromCart test case *****************************************");

	}






}
