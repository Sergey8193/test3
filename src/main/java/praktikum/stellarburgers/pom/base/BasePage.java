package praktikum.stellarburgers.pom.base;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import praktikum.stellarburgers.pom.page.LoginPage;
import praktikum.stellarburgers.pom.page.MainPage;
import praktikum.stellarburgers.pom.page.ProfilePage;

import java.time.Duration;

public class BasePage extends BaseWait {
    protected static final String BASE_URL = "https://stellarburgers.nomoreparties.site";
    protected static final String ORDER_FEED_URL = BASE_URL + "/feed";
    protected static final String REGISTER_URL = BASE_URL + "/register";
    protected static final String LOGIN_URL = BASE_URL + "/login";
    protected static final String PROFILE_URL = BASE_URL + "/account/profile";
    protected static final String ORDER_HISTORY_URL = BASE_URL + "/order-history";
    protected static final String PASSWORD_RECOVERY_URL = BASE_URL + "/forgot-password";

    protected static final By LINK_CONSTRUCTOR = By.xpath(".//nav//li/a[@href='/']");
    protected static final By LINK_ORDERS_FEED = By.xpath(".//nav//li/a[@href='/feed']");
    protected static final By LINK_LOGO = By.xpath(".//nav/div/a[@href='/']");
    protected static final By LINK_PERSONAL_AREA = By.xpath(".//nav/a[@href='/account']");

    protected static final By IMAGE_LOADING_ANIMATION = By.xpath(".//img[@src='./static/media/loading.89540200.svg']");

    protected BasePage(WebDriver driver){ super(driver); }

    @Step("Click 'Personal area' link")
    public LoginPage clickPersonalAreaLink() {
        waitUntilPageElementToBeClickable(LINK_PERSONAL_AREA);
        driver.findElement(LINK_PERSONAL_AREA).click();
        return new LoginPage(driver);
    }

    @Step("Click logged in user 'Personal area' link")
    public ProfilePage clickLoggedInUserPersonalAreaLink() {
        waitUntilPageElementToBeClickable(LINK_PERSONAL_AREA);
        driver.findElement(LINK_PERSONAL_AREA).click();
        return new ProfilePage(driver);
    }

    @Step("Click 'Logo' link")
    public MainPage clickLogoLink() {
        waitUntilPageElementToBeClickable(LINK_LOGO);
        driver.findElement(LINK_LOGO).click();
        return new MainPage(driver);
    }

    @Step("Click 'Constructor' link")
    public MainPage clickConstructorLink() {
        waitUntilPageElementToBeClickable(LINK_CONSTRUCTOR);
        driver.findElement(LINK_CONSTRUCTOR).click();
        return new MainPage(driver);
    }

    @Step("Click 'Page element'")
    public void clickPageElement(By pageElement) {
        waitUntilPageElementToBeClickable(pageElement);
        driver.findElement(pageElement).click();
    }

    @Step("Wait until 'loading animation image' to be invisible")
    protected void waitUntilLoadingAnimationImageToBeInvisible() {
        waitUntilLoadingToBeFinished(IMAGE_LOADING_ANIMATION);
    }

    @Step("Scroll to 'Page element'")
    public void scrollToPageElement(By elementLocator) {
        WebElement element = driver.findElement(elementLocator);
        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView();", element);
        new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_WAIT_DURATION))
                .until(wd -> wd.findElement(elementLocator).isDisplayed());
    }
}
