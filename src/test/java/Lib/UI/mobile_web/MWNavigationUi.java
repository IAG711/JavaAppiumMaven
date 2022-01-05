package Lib.UI.mobile_web;

import Lib.UI.NavigationUI;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWNavigationUi extends NavigationUI {
    static {
        element_main_menu = By.cssSelector("label[title='Open main menu']");
        element_main_menu_watchlist_btn = By.cssSelector("a[class='menu__item--unStar']");
}
    public MWNavigationUi(RemoteWebDriver driver) {
        super(driver);
    }
}

