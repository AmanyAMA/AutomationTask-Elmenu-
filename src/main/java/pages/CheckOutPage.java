package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends Pagebase {

	public CheckOutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css="div[class^='basket-actions']>button")
	WebElement chekoutBtn;
	
	@FindBy(css="div[class ='cost-row total']>:nth-child(2)")
	WebElement totalPrice;
	
	@FindBy(css="div[class^='basket-actions']>:nth-child(2)")
	WebElement removeAllBtn;
	
	@FindBy(css="div[class='cart-btn']")
	public WebElement CartIcon;
	
	@FindBy(css="ul[class='addresses-list']>li>div>button")
	WebElement addressDeliverBtn;
	
	@FindBy(css="div[class=order-summary]>div>button")
	WebElement PlaceOrderBtn;
	
	@FindBy(css="div[class^='basket-container']>div>:nth-child(2)")
	public WebElement AddtoCartMsg;
	
	@FindBy(css="div[class$='step-2-side-content']>div>:nth-child(2)>h4")
	public WebElement ChekouttMsg;
	
	@FindBy(css="div[class^='act-table-cell']>div>h5>a")
	public WebElement editCartItem;
		
	
//	@FindBy(css="span[class='btn-text visible-xs-inline-block']")
//	public WebElement CartIcontMsg;


	public void UserClickonCartCheckout()
	{
		clickElment(chekoutBtn);
		//clickElment(addressDeliverBtn);
	}

	public void UserCLickoneditcartItem()
	{
		clickElment(editCartItem);
	}
	
	public void EditCartItem()
	{
		clickElment(CartIcon);
		clickElment(removeAllBtn);
	}
	
	public void RemoveAllitemFromcart()
	{
		clickElment(removeAllBtn);
	}

}
