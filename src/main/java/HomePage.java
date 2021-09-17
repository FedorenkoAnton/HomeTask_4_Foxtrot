import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@class='header-search__field evinent-search-input']")
    private WebElement searchBar;

    @FindBy(xpath = "//input[@class='header-search__button evinent-search-button']")
    private WebElement findButton;

    @FindBy(xpath = "//a[@href='/ru/shop/mobilnye_telefony.html']//span[text()='Смартфоны и мобильные телефоны']")
    private WebElement smartPhonesFromSearchDropDownList;

    @FindBy(xpath = "//a[@href='/ru/search?query=nokia']")
    private WebElement firstResultFromSearchBarDropDown;

    public void inputTextToSearchBAr(String text) {
        searchBar.sendKeys(text);
    }

    public void clickOnFindButton() {
        findButton.click();
    }

    public void clickSearchBar() {
        searchBar.click();
    }

    public void clickSmartPhonesFromSearchDropDownList() {
        smartPhonesFromSearchDropDownList.click();
    }

    public WebElement getSmartPhonesFromSearchDropDownList() {
        return smartPhonesFromSearchDropDownList;
    }

    public void clickFirstResultFromSearchBarDropDown() {
        firstResultFromSearchBarDropDown.click();
    }

    public WebElement getFirstResultFromSearchBarDropDown() {
        return firstResultFromSearchBarDropDown;
    }
}
