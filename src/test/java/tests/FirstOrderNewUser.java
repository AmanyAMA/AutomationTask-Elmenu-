package tests;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.ExcelReader;
import pages.CheckOutPage;
import pages.HomePage;
import pages.Location;
import pages.LoginPage;
import pages.RestrauntDetailspage;
import pages.SearchPage;
import org.apache.log4j.Logger;

// you need to clear user cart every time your run this script as it's anew user

public class FirstOrderNewUser extends Testbase  {

	HomePage homeobj;
	LoginPage loginobj;
	SearchPage searchobj;
	RestrauntDetailspage restDetailsObj;
	Location loctionObj;
	CheckOutPage ckoutObj;
	Logger log = Logger.getLogger(FirstOrderNewUser.class);	
	String restname="mcdonalds";
	boolean LocationMsg;
	boolean cartmsg;

//Login through excel sheet data 
	
	@DataProvider(name="Excel")
	public Object[][] userLogindata() throws IOException
	{
		ExcelReader fileread = new ExcelReader();
		return fileread.getExcelData();
	}

	@Test (enabled= true ,priority=1 ,dataProvider="Excel")
	public void USerCanNormalLogin( String email,String password) 
	{
		log.info("****************************** Starting USerCanNormalLogin test case *****************************************");
		homeobj =new HomePage(driver);
		homeobj.OpenSignUpLink();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		loginobj=new LoginPage(driver);
		loginobj.UserNormalLogin(email, password);

		Assert.assertTrue(loginobj.successlogintxt.getText().contains("Hello"));
		log.info("****************************** Ending USerCanNormalLogin test case *****************************************");

	}


//Search for resturant , click go button and Open card details

	@Test (enabled= true,dependsOnMethods="USerCanNormalLogin")
	public void UserCanSearchRest() throws InterruptedException 
	{
		log.info("****************************** Starting USerSearchResturant(MAc) test case *****************************************");
		searchobj=new SearchPage(driver);

		searchobj.SearchResturant(restname);
		WebDriverWait Wait = new WebDriverWait(driver, 15);
		Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class^='restaurant-card']>div>div:nth-child(2)>a")));
		searchobj.OpenResturantcard();
		loctionObj = new Location(driver);
		LocationMsg=loctionObj.LocationMessage.getText().contains("Choose");
		System.out.println(LocationMsg);
		restDetailsObj= new RestrauntDetailspage(driver);
		Assert.assertTrue(restDetailsObj.RestTitle.getText().contains("McDon"));
		log.info("****************************** Ending USerSearchResturant(MAc) test case *****************************************");

	}



//Adding item to the cart
	@Test (enabled= true,dependsOnMethods="UserCanSearchRest")
	public void UserChooseItemAddToCart() throws InterruptedException 
	{
		log.info("****************************** Starting UserChooseItemAddToCart(Chicken-bigtesy) test case *****************************************");
		restDetailsObj = new RestrauntDetailspage(driver);
		loctionObj = new Location(driver);
		ckoutObj = new CheckOutPage(driver);
		restDetailsObj.ChooseeorderDetails();		
		log.info("****************************** Ending UserChooseItemAddToCart(Chicken-bigteasty) test case *****************************************");
		log.info("******************************  SetLocation testcase *****************************************");
		Thread.sleep(5000);
		System.out.println(LocationMsg);

		if (LocationMsg== true )
		{
			loctionObj.setDeliveryAreaText("maadi");
			Thread.sleep(5000);
			loctionObj.setDeliveryzone();
		}
		else 
			System.out.println("not the first order for user");
		
		Assert.assertTrue(ckoutObj.AddtoCartMsg.getText().contains("Your Order from"));
		log.info("******************************  SetLocation testcase *****************************************");
	}

// Click on checkout and compelete the process
	@Test (enabled= true,dependsOnMethods="UserChooseItemAddToCart")
	public void UserCanCheckout() throws InterruptedException 
	{
		log.info("****************************** Starting UserCanCheckout test case *****************************************");
		ckoutObj = new CheckOutPage(driver);
		ckoutObj.UserClickonCartCheckout();
		Thread.sleep(30000);
		System.out.println(ckoutObj.ChekouttMsg.getText());
		Assert.assertTrue(ckoutObj.ChekouttMsg.getText().contains("Summary"));
		log.info("****************************** Starting UserCanCheckout test case *****************************************");
	}





}
