package Lib.UI.ios;

import Lib.UI.ArticlePageObject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class IosArticlePageObject extends ArticlePageObject {
    static {
        element_article_title = By.id("Russia");
        element_add_to_reading_list = By.id("Save for later");
        element_article_screen_search_btn = By.id("Search Wikipedia");
        element_cross_btn = By.xpath("*//android.widget.ImageButton[@content-desc='Navigate up']");
        element_return_to_explore_btn = By.xpath("//XCUIElementTypeButton[@name='Wikipedia, return to Explore']");
        element_authorization_popup_close = By.id("places auth close");
        element_remove_from_reading_list = By.id("Saved. Activate to unsave.");
    }

    public IosArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
