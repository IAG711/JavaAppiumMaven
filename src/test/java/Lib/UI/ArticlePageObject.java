package Lib.UI;

import Lib.Platform;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject{
    protected static By
    element_article_title,
    element_add_to_reading_list,
    element_reading_list_onboarding_btn,
    element_reading_list_name_input,
    element_reading_list_ok_btn,
    element_article_screen_search_btn,
    element_cross_btn,
            element_return_to_explore_btn,
    element_authorization_popup_close,
    element_remove_from_reading_list;

    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    @Step("Waiting for article tittle to appear")
    public void waitForArticleTitleToAppear(){
        this.waitForElementPresent(element_article_title, "Cannot locate article title element", 15);
    }

    @Step("Adding article to reading list")
    public void articleAddToReadingListClick(){
        if (Platform.getInstance().isMW()){
           this.mwRemoveArticleFromSavedIfItThere();
        }
        this.waitForElementAndClick(element_add_to_reading_list, "Cannot locate more options button", 15);
    }

    @Step("Skipping onboarding during adding the article to reading list (only for Ios)")
    public void articleSkipOnboardingToAddToList(){
        this.waitForElementAndClick(element_reading_list_onboarding_btn, "Cannot locate onboarding button to create new reading list", 5);
    }

    @Step("Entering reading list name")
    public void articleEnterReadingListName(String folder_name){
        this.waitForElementAndClear(element_reading_list_name_input, "Cannot locate text input for reading folder to clear default name", 5);
        this.waitForElementAndSendKeys(element_reading_list_name_input, folder_name, "Cannot locate text input for reading folder name", 5);
    }

    @Step("Selecting existing reading list")
    public void selectExistingReadingList(String list_name){
        this.waitForElementAndClick(By.xpath("//*[@text='"+ list_name +"']"), "Cannot locate existing reading folder with the name " + list_name, 15);
    }

    @Step("Click OK in modal window")
    public void articleReadingListModalOkBtnClick(){
        this.waitForElementAndClick(element_reading_list_ok_btn, "Cannot locate OK button to add to reading list", 5);
    }

    @Step("Opening search from an article screen")
    public void articleSearchBtnClick(){
        this.waitForElementAndClick(element_article_screen_search_btn, "Cannot locate Looking glass button to click", 5);
    }

    @Step("Creating new reading list and adding article to it")
    public void createReadingListAndAddArticle(String folder_name){
        articleAddToReadingListClick();
        articleSkipOnboardingToAddToList();
        articleEnterReadingListName(folder_name);
        articleReadingListModalOkBtnClick();
    }

    @Step("Adding article to existing reading list")
    public void addArticleIntoReadingList (String list_name){
        articleAddToReadingListClick();
        selectExistingReadingList(list_name);
    }


    @Step("Closing article")
    public void closeArticle(){
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(element_cross_btn, "Cannot locate cross button on article page", 5);
        } else this.waitForElementAndClick(element_return_to_explore_btn, "Cannot find Return to explore button", 5);
    }

    @Step("Closing authorization modal (only in Ios)")
    public void closeAuthorizationModal(){
        this.waitForElementAndClick(element_authorization_popup_close, "Cannot locate cross button", 5);
    }

    @Step("Asserting that article have correct title. Expecting '{expected_title}'")
    public void assertThatArticleHaveCorrectTitle(String expected_title){
        screenshot(this.takeScreenshot("Article page with title"));
        if (Platform.getInstance().isAndroid()){
            Assert.assertEquals("Article title is not equal to " + expected_title, expected_title, driver.findElement(element_article_title).getAttribute("text"));
        } else if (Platform.getInstance().isIos()){
            Assert.assertEquals("Article title is not equal to " + expected_title, expected_title, driver.findElement(element_article_title).getAttribute("name"));
        } else {
            Assert.assertEquals("Article title is not equal to " + expected_title, expected_title, driver.findElement(element_article_title).getText());
        }
    }

    @Step("Asserting that title element is present in the article")
    public void assertTitleElementPresent(){
        Assert.assertFalse("Cannot locate presence of element", driver.findElements(element_article_title).isEmpty());
    }

    @Step("Asserting that article has been saved by checking 'Add to reading list' button")
    public void assertThatArticleIsSaved() {
        this.waitForElementPresent(element_remove_from_reading_list, "Article is not marked as saved", 5);
    }

    @Step("Article already in reading list. Removing it from there")
    public void mwRemoveArticleFromSavedIfItThere(){
       if (getAmountOfElements(element_remove_from_reading_list) > 0){
           this.waitForElementAndClick(element_remove_from_reading_list, "Cannot click remove from reading list button",3);
           this.waitForElementPresent(element_add_to_reading_list, "Cannot locate add to reading list button after article was deleted from it", 2);
       }
    }

    @Step("Checking article url to make sure we in expected one. URL is expected to have word '{expected_value}'")
    public void checkArticleUrl(String expected_value){
        String article_url = driver.getCurrentUrl();
        System.out.println(article_url);
        Assert.assertTrue("URL of the opened page seems to be different from what was expected: " + article_url, article_url.contains(expected_value));
    }


}
