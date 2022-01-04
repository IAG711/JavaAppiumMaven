package Lib.UI;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class NavigationUI extends MainPageObject{

    protected static By
     element_open_reading_list_screen_btn,
     element_reading_lists_container;

    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void openReadingListsScreen(){
        this.waitForElementAndClick(element_open_reading_list_screen_btn, "Cannot locate reading list button on main screen", 15);
        this.waitForElementPresent(element_reading_lists_container, "Cannot locate reading lists element", 15);
    }

}
