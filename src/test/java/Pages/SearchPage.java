package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
	WebDriver driver;

	public SearchPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "gh-ac")
	WebElement searchbox;
	@FindBy(css = "span.gh-search-button__label")
	WebElement searchbutton;
	@FindBy(css = "button[class='fake-menu-button__button btn btn--small btn--secondary'][aria-label='Sort selector. Best Match selected.']")
	WebElement btn1;
	@FindBy(css = "a[class='fake-menu-button__item'][href='https://www.ebay.com/sch/i.html?_nkw=samsung+galaxy+m21&_sacat=0&_from=R40&_sop=1']")
	WebElement sortcond1;
	@FindBy(css = "div.s-card__title")
	WebElement elements1;
	@FindBy(css = "a#atcBtn_btn_1")
	WebElement addbtn;

}
