package Lib.UI.ios;

import Lib.UI.SearchPageObject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class IosSearchPageObject extends SearchPageObject {
    static {
        element_search_open = By.id("Search Wikipedia");
        element_search_input = By.xpath("//XCUIElementTypeSearchField");
        element_search_results_list = By.xpath("//XCUIElementTypeCollectionView");
        element_close_search_btn = By.id("Close");
    }



    public IosSearchPageObject(AppiumDriver driver) {
        super(driver);
    }
}
