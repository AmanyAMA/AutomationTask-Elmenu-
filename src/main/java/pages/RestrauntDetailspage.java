package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RestrauntDetailspage extends Pagebase {

	public RestrauntDetailspage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(linkText="Chicken")
	WebElement sideMenuItem;
	@FindBy(xpath="//*[@id='cat-3-0']/div[1]/div[2]")
	WebElement CardItem;
	
	@FindBy(linkText="Burger Sandwiches")
	WebElement sideMenuItem1;
	@FindBy(css="div[id='cat-0-0']>div>:nth-child(2)")
	WebElement CardItem1;	
		
	@FindBy(css="button.btn-primary.add-basket")
	WebElement addToCartBtn;
	
	@FindBy(css="div[class='resturant-name']>h1")
	public WebElement RestTitle;

	@FindBy(css="button[class$='add']")
	WebElement addQuantity;	
	@FindBy(css="button[class$=subtract']")
	WebElement substractQuantity;
	
	public void ChooseeorderDetails() 
	{
		clickElment(sideMenuItem);
		clickElment(CardItem);
		clickElment(addToCartBtn);
	}

	public void TestnewOrderitem1() 
	{
		clickElment(sideMenuItem1);
		clickElment(CardItem);
		clickElment(addQuantity);
		clickElment(addToCartBtn);


	}
	public void UsereditlorderQuantity()
	{
		clickElment(addQuantity);
		clickElment(addQuantity);
		clickElment(addQuantity);
		clickElment(substractQuantity);
		clickElment(addToCartBtn);


	}
}
