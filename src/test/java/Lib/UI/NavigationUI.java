package Lib.UI;

import Lib.Platform;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject{

    protected static By
     element_open_reading_list_screen_btn,
     element_reading_lists_container,
            element_main_menu,
    element_main_menu_watchlist_btn;

    public NavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

    @Step("Opening list of saved articles")
    public void openReadingListsScreen(){
        if (Platform.getInstance().isIos() || Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(element_open_reading_list_screen_btn, "Cannot locate reading list button on main screen", 15);
            this.waitForElementPresent(element_reading_lists_container, "Cannot locate reading lists element", 15);
        } else {
            this.waitForElementToBeClickableAndClick(element_main_menu, "Cannot open main menu from article page in mobileweb", 5);
            this.waitForElementToBeClickableAndClick(element_main_menu_watchlist_btn, "Cannot open Watchlist in mobileweb", 5);
        }
    }

}
