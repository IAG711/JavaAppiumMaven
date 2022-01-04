package Lib.UI.android;

import Lib.UI.SearchPageObject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class AndroidSearchPageObject extends SearchPageObject {
static {
    element_search_open = By.id("org.wikipedia:id/search_container");
    element_search_input = By.id("org.wikipedia:id/search_src_text");
    element_search_results_list = By.id("org.wikipedia:id/search_results_list");
    element_close_search_btn = By.id("org.wikipedia:id/search_close_btn");
}

    public AndroidSearchPageObject(AppiumDriver driver) {
        super(driver);
    }






}
