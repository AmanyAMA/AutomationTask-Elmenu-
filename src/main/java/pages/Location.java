package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Location extends Pagebase{

	public Location(WebDriver driver) {
		super(driver);
	}
	@FindBy(xpath="//*[@class='area-zone-search']/label/input")
	WebElement delveryAreatext;

	@FindBy(css=".area-btn")
	//"ul[id='areas-list']"
	List<WebElement> arealist;

	@FindBy(css=".zone-btn")
	//-div[id='zones-list']>ul>li:nth-child(2)>button
	List<WebElement>zonelist;

	@FindBy(css="div[class$='side-content']>div>div>div>div>a>h3")
	public WebElement LocationMessage;

	public void setDeliveryAreaText(String Area) throws InterruptedException 
	{
		setText(delveryAreatext, Area);
		Thread.sleep(3000);
		arealist.get(0).click();

	}
	public void setDeliveryzone() {
		zonelist.get(1).click();

	}

	public void LocationStatus() 
	{
		LocationMessage.getText();
	}
}
