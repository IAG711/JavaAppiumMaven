package Lib.UI;

import Lib.Platform;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

abstract public class SearchPageObject extends MainPageObject {

   protected static By
            element_search_open,
            element_search_input,
            element_search_results_list,
            element_close_search_btn;
    public SearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    static String element_search_result_string_TPL = "//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='{SUBSTRING}']";

    private static String getResultSearchElement(String substring){
        return element_search_result_string_TPL.replace("{SUBSTRING}", substring);
    }

    @Step("Initializing search input")
    public void initSearchInput(){
        this.waitForElementAndClick(element_search_open, "Cannot click on element to init search", 10);
    }

    @Step("Inserting search query ('{query_text}') into a search input")
    public void insertSearchQuery(String query_text){
        this.waitForElementAndSendKeys(element_search_input, query_text, "Cannot locate element to send keys to", 5);
        this.waitForElementPresent(element_search_results_list, "Cannot locate search results list", 20);
    }

    @Step("Waiting for search results")
    public void waitForSearchResult(String substring){
        String search_result_xpath = getResultSearchElement(substring);
        this.waitForElementPresent(By.xpath(search_result_xpath), "Cannot locate search result with substring" + substring, 10);
    }

    @Step("Opening article from search results. Article to open: '{article_name}'")
    public void openArticle(String article_name){
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(By.xpath("//*[@resource-id='org.wikipedia:id/page_list_item_container']//*[@text='" + article_name + "']"), "Cannot locate search result with title " + article_name, 5);
        } else if (Platform.getInstance().isIos()){
            this.waitForElementAndClick(By.xpath("//XCUIElementTypeStaticText[@name='" + article_name + "']"), "Cannot locate search result with title " + article_name, 5);
        } else this.waitForElementAndClick(By.cssSelector("li[title='" + article_name + "']"), "Cannot locate search result with title " + article_name, 5);

    }

    @Step("Closing search results")
    public void closeSearchResults() {
        this.waitForElementAndClick(element_close_search_btn, "Cannot locate Close search button", 5);
        this.waitForElementNotPresent(element_search_results_list, "Search results are still shown", 15);
    }

    @Step("Making sure that search results are shown")
    public void assertSearchResultsAreShown(){
        screenshot(this.takeScreenshot("Results of a search"));
        List get_elements = driver.findElements(element_search_results_list);
        int element_count = get_elements.size();
        Assert.assertTrue("Search list is empty",element_count > 0);
    }

}
