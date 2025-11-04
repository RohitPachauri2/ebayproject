package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
WebDriver driver;
public CartPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
@FindBy(css="span.gh-cart__icon") WebElement cartdiv;
@FindBy(css="div[class='gh-flyout is-right-aligned gh-flyout--icon-target']>a") WebElement cartbutton;
@FindBy(css="div.gh-minicart-body>div>a>div.gh-info>div>span") WebElement cartele;


}
