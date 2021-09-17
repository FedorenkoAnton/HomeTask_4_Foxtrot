import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SearchResultPage extends BasePage {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@class='card__title']")
    private List<WebElement> phonesSearchResultList;

    @FindBy(xpath = "//*[@id=\"products-listing\"]/ul[@class='listing__body-sort']/li[@data-sort-order='PriceAsc']/a")
    private WebElement ascendingSortOrder;

    @FindBy(xpath = "//div[@class='card-price']")
    private List<WebElement> ascendingSortedPhones;

    @FindBy(xpath = "//a[@class='card__title']")
    private List<WebElement> nokiaSearchResult;

    public void clickFirstResult() {
        phonesSearchResultList.get(0).click();
    }

    public void clickAscendingSortOrder() {
        ascendingSortOrder.click();
    }

    public List<Integer> getPricesAfterAscendingSearch() {
        return ascendingSortedPhones.stream()
                .map(p -> p.getText().replaceAll("[^0-9]+", "").trim())
                .filter(s -> s.length() > 0)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public WebElement getAscendingSortOrder() {
        return ascendingSortOrder;
    }

    public List<WebElement> getResultsForNokiaSearch() {
        return nokiaSearchResult; }
}
