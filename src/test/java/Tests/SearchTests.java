package Tests;

import Lib.CoreTestCase;
import Lib.UI.Factories.SearchPageObjectFactory;
import Lib.UI.SearchPageObject;
import io.qameta.allure.*;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

@Epic("Tests for search")
public class SearchTests extends CoreTestCase {


    //Ex.3
    @Test
    @Features(value = {@Feature(value="Search")})
    @DisplayName("Check if search results are present")
    @Description("Assert that results of a search is displayed to the user")
    @Step("Starting test testCheckIfSearchResultsPresent")
    @Severity(value = SeverityLevel.CRITICAL)
    public void testCheckIfSearchResultsPresent(){
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.insertSearchQuery("Russia");
        SearchPageObject.assertSearchResultsAreShown();
        SearchPageObject.closeSearchResults();
    }





}
