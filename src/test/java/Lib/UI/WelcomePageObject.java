package Lib.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class WelcomePageObject extends MainPageObject{
    public WelcomePageObject(AppiumDriver driver) {
        super(driver);
    }

    By learn_more_link = By.id("Learn more about Wikipedia");
    By new_way_to_explore_text = By.id("New ways to explore");
    By add_or_edit_lng_text = By.id("Add or edit preferred languages");
    By learn_about_data_collection_text = By.id("Learn more about data collected");
    By nextBtn = By.id("Next");
    By getStartedBtn = By.id("Get started");
    By SkipBtn = By.id("Skip");




    public void waitForLearningMoreLink(){
        this.waitForElementPresent(learn_more_link, "Cannot locate Learn more about Wiki link", 10);
    }

    public void waitForNewWayToExploreText(){
        this.waitForElementPresent(new_way_to_explore_text, "Cannot locate New ways to explore text", 10);
    }

    public void waitForAddOrEditPrefLang(){
        this.waitForElementPresent(add_or_edit_lng_text, "Cannot locate Add or edit preferred languages text", 10);
    }

    public void waitForLearnAboutDataCollection(){
        this.waitForElementPresent(learn_about_data_collection_text, "Cannot locate Learn more about data collected text", 10);
    }

    public void nextButtonClick(){
        this.waitForElementAndClick(nextBtn, "Cannot locate Next button", 10);
    }

    public void getStartedButtonClick(){
        this.waitForElementAndClick(getStartedBtn, "Cannot locate Get started button", 10);
    }

    public void clickSkip(){
        this.waitForElementAndClick(SkipBtn, "Cannot locate Skip button", 10);
    }

}
