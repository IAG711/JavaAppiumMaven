package Tests;

import Lib.CoreTestCase;
import Lib.UI.Factories.SearchPageObjectFactory;
import Lib.UI.SearchPageObject;
import org.junit.Test;

public class SearchTests extends CoreTestCase {


    //Ex.3
    @Test
    public void testCheckIfSearchResultsPresent(){
        SearchPageObject SearchPageObject = SearchPageObjectFactory.get(driver);
        SearchPageObject.initSearchInput();
        SearchPageObject.insertSearchQuery("Russia");
        SearchPageObject.assertSearchResultsAreShown();
        SearchPageObject.closeSearchResults();
    }





}
