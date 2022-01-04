package Lib.UI;

import Lib.Platform;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class MyListsPageObject extends MainPageObject {

    protected static By
        element_delete_article_after_swipe;

    public MyListsPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void openReadingList(String list_name) {
        this.waitForElementAndClick(By.xpath("//*[@text='" + list_name + "']"), "Cannot locate reading list with the name " + list_name, 15);
    }

    public void openArticleFromTheList(String article_name){
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(By.xpath("//*[@text='" + article_name + "']"), "Cannot locate article " + article_name, 5);
        } else this.waitForElementAndClick(By.xpath("//XCUIElementTypeStaticText[@name='"+ article_name +"']"), "Cannot locate article " + article_name, 5);
    }

    public void deleteArticleFromReadingList(String article_name){
        if (Platform.getInstance().isIos()){
            this.swipeElementToLeft(By.xpath("//XCUIElementTypeStaticText[@name='"+ article_name +"']"), "Cannot locate article with title " + article_name + " to delete it");
            this.waitForElementAndClick(element_delete_article_after_swipe, "Cannot locate delete element in Ios", 10);
        } else this.swipeElementToLeft(By.xpath("//*[@text='"+ article_name +"']"), "Cannot locate article with title " + article_name + " to delete it");
        this.waitForElementNotPresent(By.xpath("//*[@text='"+ article_name +"']"), "Deleted article is still present after swipe", 5);
    }
}

