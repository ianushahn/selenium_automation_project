package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import generic.AllVerifications;

public class Homepage extends AllVerifications
{
	public WebDriver driver =null; 
	SoftAssert sa = new SoftAssert();
	
	// finding your weblements 
	@FindBy(css = "nav>div.flex:first-child>a:first-child")
   private WebElement logo;
	
	@FindBy(css = "div.animate__fadeInUp>a.inline-block")
	private WebElement shopAllLink;
	
	@FindBy(css="div.hidden.items-center.gap-6>a:first-child")
	private WebElement wishListIcon;
	
	@FindBy(css="a.flex:last-child>span")
	private WebElement signInLink;
	
	@FindBy(css="input.flex-grow")
	private WebElement searchField;
	
	@FindBy(css="button.px-4")
	private WebElement searchIcon;
	
	
	// initializing all the elements in this page. using the constructor of this class. 
	public Homepage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	// utilization (create fucntions to perform operations on elements ) 
	public void clickOnLogo()
	{
		AllVerifications.clickIfVisibleAndEnabled(logo, driver, sa);
	}
	
	
	public void clickOnshopAllLink()
	{
		AllVerifications.clickIfVisibleAndEnabled(shopAllLink, driver, sa);
	}
	
	public void clickOnSignInLink()
	{
		AllVerifications.clickIfVisibleAndEnabled(signInLink, driver, sa);
	}
	public void EnterValueInSearchField(String keys)
	{
		AllVerifications.clickIfVisibleAndEnabled(searchField, driver, sa);
		searchField.clear();
		searchField.sendKeys(keys);
	}
	
	
	public void clickOnSearchButton()
	{
		AllVerifications.clickIfVisibleAndEnabled(searchIcon, driver, sa);
	}
	
	
	public void clickOnwishListIcon() throws InterruptedException
	{
		Thread.sleep(1000);
		AllVerifications.clickIfVisibleAndEnabled(wishListIcon, driver, sa);
		Thread.sleep(1000);
	}
	
	
}
