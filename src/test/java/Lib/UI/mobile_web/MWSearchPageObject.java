package Lib.UI.mobile_web;

import Lib.UI.SearchPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWSearchPageObject extends SearchPageObject {
    static {
        element_search_open = By.cssSelector("button#searchIcon");
        element_search_input = By.cssSelector("form>input[type='search'");
        element_search_results_list = By.cssSelector("div.results");
        element_close_search_btn = By.cssSelector("div>button.cancel");
    }

    public MWSearchPageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
