package praktikum.stellarburgers.pom.base;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BaseWait {

    protected final static int ORDER_WAIT_DURATION = 20;
    private final static int LOADING_WAIT_DURATION = 20;
    protected final static int ELEMENT_WAIT_DURATION = 20;
    private final static int PAGE_WAIT_DURATION = 20;

    protected final WebDriver driver;
    protected final Actions actions;

    BaseWait(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
    }

    @Step("Wait until 'Loading animation image' to be invisible")
    protected void waitUntilLoadingToBeFinished(By loadingAnimationImage) {
        new WebDriverWait(driver, Duration.ofSeconds(LOADING_WAIT_DURATION))
                .until(ExpectedConditions.invisibilityOfElementLocated(loadingAnimationImage));
    }

    @Step("Wait until 'Page element' to be enabled")
    protected void waitUntilPageElementToBeEnabled(By waitElement) {
        WebDriverWait elementWait = new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_WAIT_DURATION));
        elementWait.until((ExpectedCondition<Boolean>) wd -> {
            assert wd != null;
            return wd.findElement(waitElement).isEnabled();
        });
    }

    @Step("Wait until 'Page element' to be displayed")
    protected void waitUntilPageElementToBeDisplayed(By waitElement) {
        WebDriverWait elementWait = new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_WAIT_DURATION));
        elementWait.until(ExpectedConditions.visibilityOfElementLocated(waitElement));
    }

    @Step("Wait until 'Page element' to be clickable")
    protected void waitUntilPageElementToBeClickable(By waitElement) {
        WebDriverWait elementWait = new WebDriverWait(driver, Duration.ofSeconds(ELEMENT_WAIT_DURATION));
        elementWait.until(ExpectedConditions.elementToBeClickable(waitElement));
    }

    @Step("Wait until 'Page' to be displayed")
    public void waitUntilPageToBeDisplayed(By pageElement) {
        waitUntilPageDocumentToBeReady();
        waitUntilPageElementToBeDisplayed(pageElement);
    }

    @Step("Wait until 'Page document' to be ready")
    protected void waitUntilPageDocumentToBeReady() {
        new WebDriverWait(driver, Duration.ofSeconds(PAGE_WAIT_DURATION))
                .until((ExpectedCondition<Boolean>) wd ->
                {
                    assert wd != null;
                    return ((JavascriptExecutor) wd)
                            .executeScript("return document.readyState")
                            .equals("complete");
                });
        final boolean UNLOCK_MODE = true;
        //makePageToBeClickable(UNLOCK_MODE);
    }

    public void makePageToBeClickable(boolean unlock) {
        if (1 == 2) {
            final By DIV_INPUT_LOCKER = By.xpath(".//div[@class ='input__container']/div[contains(@class, 'input pr-6 pl-6')]");
            final By INPUT_LOCKER_NAME = By.xpath(".//label[text()='Имя']/parent::div/input");
            final By INPUT_LOCKER_EMAIL = By.xpath(".//label[text()='Email']/parent::div/input");
            final By INPUT_LOCKER_PASSWORD = By.xpath(".//input[@type='password' and @name='Пароль']");

            List<WebElement> inputLockers = driver.findElements(DIV_INPUT_LOCKER);
            String[] inputLockerClass = {
                    "input pr-6 pl-6 input_type_text input_size_default input_status_active",
                    "input pr-6 pl-6 input_type_text input_size_default input_status_active",
                    "input pr-6 pl-6 input_type_password input_size_default input_status_active"
            };

            String oldInputClass = "text input__textfield text_type_main-default input__textfield-disabled";
            String newInputClass = "text input__textfield text_type_main-default input__textfield-enabled";

            int i = 0;
            for (WebElement locker : inputLockers) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].className = '" + inputLockerClass[i] + "';", locker);
                i += 1;
            }

            if(i == 3) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].disabled='false';", driver.findElements(INPUT_LOCKER_NAME));
                ((JavascriptExecutor) driver).executeScript("arguments[0].className = '" + newInputClass + "';", driver.findElements(INPUT_LOCKER_NAME));
                ((JavascriptExecutor) driver).executeScript("arguments[0].disabled='false';", driver.findElements(INPUT_LOCKER_EMAIL));
                ((JavascriptExecutor) driver).executeScript("arguments[0].className = '" + newInputClass + "';", driver.findElements(INPUT_LOCKER_EMAIL));
                ((JavascriptExecutor) driver).executeScript("arguments[0].disabled='false';", driver.findElements(INPUT_LOCKER_PASSWORD));
                ((JavascriptExecutor) driver).executeScript("arguments[0].className = '" + newInputClass + "';", driver.findElements(INPUT_LOCKER_PASSWORD));
            }
        }

        if (unlock) {
            final By DIV_MODAL_SECTION = By.xpath(".//div[@class='Modal_modal__P3_V5']");
            final By DIV_MODAL_CONTAINER = By.xpath(".//div[@class='Modal_modal__container__Wo2l_']");
            final By DIV_MODAL_CONTENT_BOX = By.xpath(".//div[@class='Modal_modal__contentBox__sCy8X pt-30 pb-30']");
            final By DIV_MODAL_OVERLAY = By.xpath(".//div[@class='Modal_modal_overlay__x2ZCr']");

            final By DIV_SECTION_BLOCKER = By.xpath(".//section[@class='BurgerIngredients_ingredients__1N8v2']/div[@style='display: flex;']");

            List<WebElement> lockers = new ArrayList<>();

            List<WebElement> sections = driver.findElements(DIV_MODAL_SECTION);
            List<WebElement> containers = driver.findElements(DIV_MODAL_CONTAINER);
            List<WebElement> contents = driver.findElements(DIV_MODAL_CONTENT_BOX);
            List<WebElement> overlays = driver.findElements(DIV_MODAL_OVERLAY);

            lockers.addAll(sections);
            lockers.addAll(containers);
            lockers.addAll(contents);
            lockers.addAll(overlays);

            for (WebElement locker : lockers) {
                ((JavascriptExecutor) driver).executeScript("arguments[0].className = '';", locker);
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.width = 0;", locker);
                ((JavascriptExecutor) driver).executeScript("arguments[0].style.height = 0;", locker);
            }
        }
    }
}
