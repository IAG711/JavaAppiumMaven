package Lib.UI;

import Lib.Platform;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.By;

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

    public ArticlePageObject(AppiumDriver driver) {
        super(driver);
    }

    public void waitForArticleTitleToAppear(){
        this.waitForElementPresent(element_article_title, "Cannot locate article title element", 15);
    }

    public void articleAddToReadingListClick(){
        this.waitForElementAndClick(element_add_to_reading_list, "Cannot locate more options button", 15);
    }

    public void articleSkipOnboardingToAddToList(){
        this.waitForElementAndClick(element_reading_list_onboarding_btn, "Cannot locate onboarding button to create new reading list", 5);
    }

    public void articleEnterReadingListName(String folder_name){
        this.waitForElementAndClear(element_reading_list_name_input, "Cannot locate text input for reading folder to clear default name", 5);
        this.waitForElementAndSendKeys(element_reading_list_name_input, folder_name, "Cannot locate text input for reading folder name", 5);
    }

    public void selectExistingReadingList(String list_name){
        this.waitForElementAndClick(By.xpath("//*[@text='"+ list_name +"']"), "Cannot locate existing reading folder with the name " + list_name, 15);
    }

    public void articleReadingListModalOkBtnClick(){
        this.waitForElementAndClick(element_reading_list_ok_btn, "Cannot locate OK button to add to reading list", 5);
    }

    public void articleSearchBtnClick(){
        this.waitForElementAndClick(element_article_screen_search_btn, "Cannot locate Looking glass button to click", 5);
    }

    public void createReadingListAndAddArticle(String folder_name){
        articleAddToReadingListClick();
        articleSkipOnboardingToAddToList();
        articleEnterReadingListName(folder_name);
        articleReadingListModalOkBtnClick();
    }

    public void addArticleIntoReadingList (String list_name){
        articleAddToReadingListClick();
        selectExistingReadingList(list_name);
    }


    public void closeArticle(){
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(element_cross_btn, "Cannot locate cross button on article page", 5);
        } else this.waitForElementAndClick(element_return_to_explore_btn, "Cannot find Return to explore button", 5);
    }

    public void closeAuthorizationModal(){
        this.waitForElementAndClick(element_authorization_popup_close, "Cannot locate cross button", 5);
    }

    public void assertThatArticleHaveCorrectTitle(String expected_title){
        Assert.assertEquals("Article title is not equal to " + expected_title, expected_title, driver.findElement(element_article_title).getAttribute("text"));
    }

    public void assertTitleElementPresent(){
        Assert.assertFalse("Cannot locate presence of element", driver.findElements(element_article_title).isEmpty());
    }

    public void assertThatArticleIsSaved() {
        this.waitForElementPresent(element_remove_from_reading_list, "Article is not marked as saved", 5);
    }


}
