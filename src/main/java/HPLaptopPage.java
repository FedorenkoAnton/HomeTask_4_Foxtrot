import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HPLaptopPage extends BasePage{

    public HPLaptopPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='button product-box__main-buy__button buy-button product-buy-button']")
    private WebElement buyButton;

    @FindBy(xpath = "//span[@id='cartItemsCount']")
    private WebElement cartIcon;

    @FindBy(xpath = "//div[@class='header-tooltip-footer__col']//a[@href='/ru/cart/checkout']")
    private WebElement checkOutButton;

    public void clickOnBuyButton() {
        buyButton.click();
    }

    public void clickOnCartIcon() {
        cartIcon.click();
    }

    public void clickOnCheckOutButton() {
        checkOutButton.click();
    }

    public WebElement getCheckOutButton() {
        return checkOutButton;
    }
}
