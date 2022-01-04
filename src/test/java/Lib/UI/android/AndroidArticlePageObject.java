package Lib.UI.android;

import Lib.UI.ArticlePageObject;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class AndroidArticlePageObject extends ArticlePageObject {
    static {
        element_article_title = By.id("org.wikipedia:id/view_page_title_text");
        element_add_to_reading_list = By.xpath("//android.widget.ImageView[@content-desc='Add this article to a reading list']");
        element_reading_list_onboarding_btn = By.id("org.wikipedia:id/onboarding_button");
        element_reading_list_name_input = By.id("org.wikipedia:id/text_input");
        element_reading_list_ok_btn = By.xpath("//*[@text='OK']");
        element_article_screen_search_btn = By.id("org.wikipedia:id/menu_page_search");
        element_cross_btn = By.xpath("*//android.widget.ImageButton[@content-desc='Navigate up']");
    }

    public AndroidArticlePageObject(AppiumDriver driver) {
        super(driver);
    }
}
