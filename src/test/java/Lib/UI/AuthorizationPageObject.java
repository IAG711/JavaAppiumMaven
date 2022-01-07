package Lib.UI;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class AuthorizationPageObject extends MainPageObject{
    private static final By
    element_article_screen_auth_login_btn = By.xpath("//body//div/a[text()='Log in']"),
    element_aut_login_input = By.cssSelector("input[name='wpName']"),
    element_aut_password_input = By.cssSelector("input[name='wpPassword']"),
    element_aut_login_btn = By.cssSelector("button#wpLoginAttempt");
    public AuthorizationPageObject(RemoteWebDriver driver) {
        super(driver);
    }

    @Step("Authorizing from an article page. Step is used only on mobile web")
    public void mwAuthorizationFromArticlePage(String login, String password){
        this.waitForElementToBeClickableAndClick(element_article_screen_auth_login_btn, "Cannot click login button on article page",5);
        this.insertLogin(login);
        this.insertPassword(password);
        this.loginBtnClick();
    }

    @Step("Inserting login. Value: {login}")
    public void insertLogin(String login){
        this.waitForElementAndSendKeys(element_aut_login_input, login, "Cannot insert login",5);
    }

    @Step("Inserting password")
    public void insertPassword(String password){
        this.waitForElementAndSendKeys(element_aut_password_input,password, "Cannot insert password",5);
    }

    @Step("Clicking on 'Log in' button")
    public void loginBtnClick(){
        this.waitForElementAndClick(element_aut_login_btn,"Cannot click to login button",5);
    }

}
