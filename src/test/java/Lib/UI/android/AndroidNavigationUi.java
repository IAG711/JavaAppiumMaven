package Lib.UI.android;

import Lib.UI.NavigationUI;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class AndroidNavigationUi extends NavigationUI {
    static {
         element_open_reading_list_screen_btn = By.xpath("//android.widget.FrameLayout[@content-desc='My lists']");
         element_reading_lists_container = By.id("org.wikipedia:id/reading_list_list");
    }

    public AndroidNavigationUi(AppiumDriver driver) {
        super(driver);
    }
}
