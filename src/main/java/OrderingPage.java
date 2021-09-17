import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrderingPage extends BasePage{

    public OrderingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@class='callback-number text-box single-line save-in-cache-input']")
    private WebElement inputPhoneNumber;

    @FindBy(xpath = "//input[@id='Name']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//span[@id='select2-storeId-container']")
    private WebElement takeAwayPoints;

    @FindBy(xpath = "//li[@class='select2-results__option select2-results__option--highlighted']")
    private WebElement firstTakeAwayPoint;

    @FindBy(xpath = "//button[@class='button checkout-order-button']")
    private WebElement checkoutOrderButton;

    public void inputPhoneNumber(String text) {
        inputPhoneNumber.sendKeys(text);
    }

    public void inputFirstName(String text) {
        inputName.sendKeys(text);
    }

    public void inputLastName(String text) {
        lastNameInput.sendKeys(text);
    }

    public void clickTakeAwayPoint() {
        takeAwayPoints.click();
    }

    public void chooseFirstTakeAwayPoint() {
        firstTakeAwayPoint.click();
    }

    public WebElement getCheckOutButton() {
        return checkoutOrderButton;
    }
}
