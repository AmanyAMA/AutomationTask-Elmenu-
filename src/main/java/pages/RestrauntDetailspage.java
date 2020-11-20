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
		
	@FindBy(css=".add-basket")//class="btn-primary add-basket"
	WebElement addToCartBtn;
	
	@FindBy(css=".resturant-name .title")
	public WebElement RestTitle;

	@FindBy(css=".quantity-btn.add")
	WebElement addQuantity;	
	
	@FindBy(css=".quantity-btn.subtract")
	WebElement substractQuantity;
	
	@FindBy(css="#item-view-modal .add-basket")
	WebElement EditaddQuantity;
	
	@FindBy(css="#item-view-modal .subtract")
	WebElement EditsubstractQuantity;
	
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
		clickElment(EditaddQuantity);
		clickElment(EditaddQuantity);
		clickElment(EditaddQuantity);
		clickElment(EditsubstractQuantity);
		clickElment(addToCartBtn);


	}
}
