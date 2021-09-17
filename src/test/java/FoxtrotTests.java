import org.testng.annotations.Test;

import java.util.stream.IntStream;

import static org.testng.AssertJUnit.assertTrue;

public class FoxtrotTests extends BaseTest{

    private static final String HP_LAPTOP_SEARCH_QUERY = "HP 15-dw2030ur Silver";
    private static final String PHONE_NUMBER = "1233456";
    private static final String FIRST_NAME = "Ivan";
    private static final String LAST_NAME = "Ivanov";
    private static final String NOKIA_SEARCH_QUERY = "nokia";

    @Test
    public void productCheckOutTest() {
        getHomePage().inputTextToSearchBAr(HP_LAPTOP_SEARCH_QUERY);
        getHomePage().clickOnFindButton();
        getSearchResultPage().clickFirstResult();
        getHPLaptopPage().clickOnBuyButton();
        getHPLaptopPage().waitPageToComplete(30);
        getHPLaptopPage().clickOnCartIcon();
        getHPLaptopPage().waitForVisibilityOfElement(30, getHPLaptopPage().getCheckOutButton());
        getHPLaptopPage().clickOnCheckOutButton();
        getOrderingPage().inputPhoneNumber(PHONE_NUMBER);
        getOrderingPage().inputFirstName(FIRST_NAME);
        getOrderingPage().inputLastName(LAST_NAME);
        getOrderingPage().clickTakeAwayPoint();
        getOrderingPage().chooseFirstTakeAwayPoint();
        assertTrue(getOrderingPage().getCheckOutButton() != null);
    }

    @Test
    public void checkPriceAscendSorting() {
        getHomePage().clickSearchBar();
        getHomePage().waitForVisibilityOfElement(30, getHomePage().getSmartPhonesFromSearchDropDownList());
        getHomePage().clickSmartPhonesFromSearchDropDownList();
        getSearchResultPage().waitForVisibilityOfElement(30, getSearchResultPage().getAscendingSortOrder());
        getSearchResultPage().clickAscendingSortOrder();
        getDriver().navigate().refresh();
        getSearchResultPage().waitPageToComplete(30);
        IntStream.range(0, 26)
                .forEach(i -> assertTrue(getSearchResultPage().getPricesAfterAscendingSearch().get(i)
                        .compareTo(getSearchResultPage().getPricesAfterAscendingSearch().get(i + 1)) <= 0));
    }

    @Test
    public void checkCorrectnessSearchForNokiaProducts() {
        getHomePage().inputTextToSearchBAr(NOKIA_SEARCH_QUERY);
        getHomePage().waitForVisibilityOfElement(30, getHomePage().getFirstResultFromSearchBarDropDown());
        getHomePage().clickFirstResultFromSearchBarDropDown();
        getSearchResultPage().waitPageToComplete(30);
        getSearchResultPage().getResultsForNokiaSearch()
                .forEach(r -> assertTrue(r.getText().contains("Nokia") || r.getText().contains("NOKIA")));
    }
}
