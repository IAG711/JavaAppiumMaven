package Lib.UI;

import Lib.Platform;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject {

    protected static By
        element_delete_article_after_swipe;

    public MyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    @Step("Opening existing reading list with the name '{list_name}'")
    public void openReadingList(String list_name) {
        this.waitForElementAndClick(By.xpath("//*[@text='" + list_name + "']"), "Cannot locate reading list with the name " + list_name, 15);
    }

    @Step("Opening article from reading list. Article name is '{article_name}'")
    public void openArticleFromTheList(String article_name){
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(By.xpath("//*[@text='" + article_name + "']"), "Cannot locate article " + article_name, 5);
        } else if (Platform.getInstance().isIos()){
            this.waitForElementAndClick(By.xpath("//XCUIElementTypeStaticText[@name='"+ article_name +"']"), "Cannot locate article " + article_name, 5);
        } else {
            this.waitForElementAndClick(By.xpath("//ul[contains(@class,'watchlist')]//h3[contains(text(),'"+ article_name +"')]"), "Cannot locate article " + article_name, 5);
        }
    }

    @Step("Deleting article from reading list. Article to delete is '{article_name}'")
    public void deleteArticleFromReadingList(String article_name){
        if (Platform.getInstance().isIos()){
            this.swipeElementToLeft(By.xpath("//XCUIElementTypeStaticText[@name='"+ article_name +"']"), "Cannot locate article with title " + article_name + " to delete it");
            this.waitForElementAndClick(element_delete_article_after_swipe, "Cannot locate delete element in Ios", 10);
        } else if (Platform.getInstance().isAndroid()) {
            this.swipeElementToLeft(By.xpath("//*[@text='"+ article_name +"']"), "Cannot locate article with title " + article_name + " to delete it");
            this.waitForElementNotPresent(By.xpath("//*[@text='"+ article_name +"']"), "Deleted article is still present after swipe", 5);
        } else {
            this.waitForElementToBeClickableAndClick(By.xpath("//ul[contains(@class,'watchlist')]//h3[contains(text(),'"+ article_name +"')]/../../a[contains(@class,'watched')]"),
                    "Cannot locate article with title " + article_name + " to delete it",
                    5);
            driver.navigate().refresh();
            this.waitForElementNotPresent(By.xpath("//ul[contains(@class,'watchlist')]//h3[contains(text(),'"+ article_name +"')]\""),
                    "Deleted article is still present after swipe",
                    5);
        }
    }
}

