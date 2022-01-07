package Lib.UI.mobile_web;

import Lib.UI.ArticlePageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {
    static {
        element_add_to_reading_list = By.cssSelector("#ca-watch");
        element_remove_from_reading_list = By.cssSelector("#page-actions li#page-actions-watch a.watched");
        element_article_screen_search_btn = By.cssSelector("button#searchIcon");
        element_article_title = By.cssSelector("#content h1");
    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
