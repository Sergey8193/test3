package praktikum.stellarburgers.pom.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Objects;

import static praktikum.stellarburgers.constants.Urls.MAIN_PAGE_URL;
import static praktikum.stellarburgers.constants.WebBrowsers.FIREFOX;
import static praktikum.stellarburgers.constants.WebBrowsers.GOOGLE_CHROME;

class BaseWeb {
    protected WebDriver driver;
    private static String BROWSER = GOOGLE_CHROME;
    private static String URL = MAIN_PAGE_URL;

    BaseWeb(String browser, String url) {
        BaseWeb.BROWSER = browser;
        BaseWeb.URL = url;
    }

    private static WebDriver getWebDriver(String browserName, String Url) {
        WebDriver driver;
        if (Objects.equals(browserName, GOOGLE_CHROME)) { driver = new ChromeDriver(); }
        else if (Objects.equals(browserName, FIREFOX)) { driver = new FirefoxDriver(); }
        else { driver = null; }

        if (driver != null){
            driver.manage().window().maximize();
            driver.get(Url);
            //((JavascriptExecutor) driver).executeScript("document.getElementById('rcc-confirm-button').click();");
        }
        return driver;
    }

    private static void closeWebBrowser(WebDriver driver) {
        driver.quit();
    }

    // @Before
    public void setUpDriver(){
        driver = getWebDriver(BROWSER, URL);
    }

    // @After
    public void cleanUpDriver() {
        closeWebBrowser(driver);
    }
}
