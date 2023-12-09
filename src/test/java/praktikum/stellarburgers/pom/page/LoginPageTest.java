package praktikum.stellarburgers.pom.page;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import praktikum.stellarburgers.pom.base.BaseTest;

import static praktikum.stellarburgers.browser.BrowserType.BY_BROWSER_SYSTEM_PROPERTY;
import static praktikum.stellarburgers.constants.UserState.NO_NAME_USER;
import static praktikum.stellarburgers.constants.UserStatus.AUTHORIZED_USER;

public class LoginPageTest extends BaseTest {
    public LoginPageTest() { super(BY_BROWSER_SYSTEM_PROPERTY, AUTHORIZED_USER, NO_NAME_USER); }

    @Before
    public void startUp() { getBrowserAndPrepareUserData(); }

    @After
    public void cleanUp() { closeBrowserAndCleanUpUserData(); }

    @Test
    @DisplayName("Login user")
    @Description("Login user using 'Personal area' Link on 'Main' Page")
    public void loginUsingPersonalAreaLinkOnMainPage() {
        mainPage = mainPage
                .clickPersonalAreaLink()
                .waitUntilLoginPageToBeDisplayed()
                .fillOutSignInForm(email, password)
                .clickLoginButton()
                .waitUntilMainPageToBeDisplayed()
                .waitUntilOrderBurgerButtonToBeDisplayed();
    }

    @Test
    @DisplayName("Login user")
    @Description("Login user using 'Login to account' Button on 'Main' Page")
    public void loginUsingLoginToAccountButtonOnMainPage() {
        mainPage = mainPage
                .clickLoginToAccountButton()
                .waitUntilLoginPageToBeDisplayed()
                .fillOutSignInForm(email, password)
                .clickLoginButton()
                .waitUntilMainPageToBeDisplayed()
                .waitUntilOrderBurgerButtonToBeDisplayed();
    }

    @Test
    @DisplayName("Login user")
    @Description("Login user using Sign in Link on 'Register' Page")
    public void loginUsingLoginLinkOnRegisterPage() {
        mainPage = mainPage
                .clickPersonalAreaLink()
                .waitUntilLoginPageToBeDisplayed()
                .clickRegisterPageLink()
                .waitUntilRegisterPageToBeDisplayed()
                .clickSignInLink()
                .fillOutSignInForm(email, password)
                .clickLoginButton()
                .waitUntilMainPageToBeDisplayed()
                .waitUntilOrderBurgerButtonToBeDisplayed();
    }

    @Test
    @DisplayName("Login user")
    @Description("Login user using 'Sign in' Link on 'Password recovery' Page")
    public void loginUsingLoginLinkONPasswordRecoveryPage() {
        mainPage = mainPage
                .clickPersonalAreaLink()
                .waitUntilLoginPageToBeDisplayed()
                .clickPasswordRecoveryPageLink()
                .waitUntilPasswordRecoveryPageToBeDisplayed()
                .clickSignInLink()
                .fillOutSignInForm(email, password)
                .clickLoginButton()
                .waitUntilMainPageToBeDisplayed()
                .waitUntilOrderBurgerButtonToBeDisplayed();
    }
}
