package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends Pagebase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}
	
	 @FindBy(css=".input-holder>:nth-child(2)")
	 WebElement searchTxtBox;
	 @FindBy(css="ul.autocomplete-list")
	 WebElement SearchAutoCompleteList;
	 
	 @FindBy(css=".search-form .submit-btn")
	 WebElement serachBtn;
	 
	 @FindBy (css="h3.card-title")
	public WebElement searchResutCard;
	 
	 @FindBy(css="div[class^='restaurant-card']>div>div:nth-child(2)>a")
	 public WebElement clickableCard;
	 
	 @FindBy(css="ul[class='autocomplete-list']>li")
	 List<WebElement> restAutoSearch;

	 
	 public void SearchResturant(String resturant) throws InterruptedException 
	 {
		 setText(searchTxtBox, resturant);
		 clickElment(serachBtn); 
		 //Assert.assertTrue(searchobj.searchResutCard.getText().contains("McDonald")); 
	 } 
	 public void UseAutoCompleteSearchRest(String resturant) throws InterruptedException 
	 {
		 setText(searchTxtBox, resturant);
		 Thread.sleep(50000);
		 WebElement option=	(restAutoSearch.get(2).findElement(By.tagName("button")));
		 Thread.sleep(10000);
		 option.getText();
		 //Assert.assertTrue(searchobj.searchResutCard.getText().contains("McDonald")); 
	 } 
	
	 
	 
	 public void OpenResturantcard()
	 {
		 clickElment(clickableCard);

	 }

}
