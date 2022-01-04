package Lib.UI;

import Lib.Platform;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

abstract public class SearchPageObject extends MainPageObject {

   protected static By
            element_search_open,
            element_search_input,
            element_search_results_list,
            element_close_search_btn;
    public SearchPageObject(AppiumDriver driver) {
        super(driver);
    }

    static String element_search_result_string_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']";

    private static String getResultSearchElement(String substring){
        return element_search_result_string_TPL.replace("{SUBSTRING}", substring);
    }

    public void initSearchInput(){
        this.waitForElementAndClick(element_search_open, "Cannot click on element to init search", 10);
    }

    public void insertSearchQuery(String query_text){
        this.waitForElementAndSendKeys(element_search_input, query_text, "Cannot locate element to send keys to", 5);
        this.waitForElementPresent(element_search_results_list, "Cannot locate search results list", 20);
    }

    public void waitForSearchResult(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot locate search result with substring" + substring, 10);
    }

    public void openArticle(String article_name){
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='" + article_name + "']"), "Cannot locate search result with title " + article_name, 5);
        } else{
            this.waitForElementAndClick(By.xpath("//XCUIElementTypeStaticText[@name='" + article_name + "']"), "Cannot locate search result with title " + article_name, 5);
        }
    }

    public void closeSearchResults() {
        this.waitForElementAndClick(element_close_search_btn, "Cannot locate Close search button", 5);
        this.waitForElementNotPresent(element_search_results_list, "Search results are still shown", 15);
    }

    public void assertSearchResultsAreShown(){
        List get_elements = driver.findElements(element_search_results_list);
        int element_count = get_elements.size();
        Assert.assertTrue("Search list is empty",element_count > 0);
    }

}
