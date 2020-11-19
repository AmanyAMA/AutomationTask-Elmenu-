package tests;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import data.LoadProperties;
import utilities.Helper;

public class Testbase {

		 
		public static  WebDriver driver;
		String ProductionURL=LoadProperties.envData.getProperty("URL");
		Logger log = Logger.getLogger(Testbase.class);	

		@BeforeSuite
		@Parameters({"browser"})
		public void StartDriver(@Optional("firefox") String browserName) 
		{
			
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
				driver = new ChromeDriver();
				log.info("****************************** start driver  open browser chrome *****************************************");

			}
			else if (browserName.equalsIgnoreCase("firefox")) {
				String FirefoxPath= System.getProperty("user.dir")+"/Drivers/geckodriver.exe";
				System.setProperty("webdriver.gecko.driver", FirefoxPath);
				driver=new FirefoxDriver();
				log.info("****************************** calling driver open browser firefox *****************************************");

			}
			else if (browserName.equalsIgnoreCase("ie")) {
				String EgdePath = System.getProperty("user.dir")+"/Drivers/msedgedriver.exe";
				System.setProperty("webdriver.edge.driver", EgdePath);
				 driver= new EdgeDriver();
					log.info("****************************** calling driver to open browser edge *****************************************");

			}
			
			driver.manage().window().maximize();
			driver.navigate().to(ProductionURL);
			log.info("****************************** Open URl  *****************************************");

			driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

			
		}
		
		
		@AfterSuite
		public void QuitDriver() 
		{
			driver.quit();
			log.info("****************************** Quit driver  *****************************************");

		}
		
		// take screen shout when test case fail and add it to screenshot folder
		@AfterMethod
		public void screanShotOnFaulier(ITestResult result) 
		{
			if (result.getStatus()==ITestResult.FAILURE)
			{
				System.out.println("Failed");
				System.out.println("Taking screenshot..");
				Helper.captureScreenShot(driver, result.getName());
				log.info("****************************** Taking screenshot on failuare  *****************************************");				
			}

		}
		
		
	}


