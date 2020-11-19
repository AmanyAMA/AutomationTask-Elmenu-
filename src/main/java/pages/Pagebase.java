package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Pagebase {
	
	public Pagebase(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	protected static void clickElment(WebElement link) 
	{
		link.click();
	}
	
	protected static void setText(WebElement txt , String value) 
	{
		txt.sendKeys(value);
	}
	
	protected static void selectFromMenuByValue(WebElement element , String value) 
	{
		Select option= new Select (element);
		option.selectByValue(value);
	}
	
	protected static void selectFromMenuByIndex(WebElement element , int value) 
	{
		Select option= new Select (element);
		option.selectByIndex(value);
	}


}
