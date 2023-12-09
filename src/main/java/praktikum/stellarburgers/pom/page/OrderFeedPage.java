package praktikum.stellarburgers.pom.page;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import praktikum.stellarburgers.pom.base.BasePage;

public class OrderFeedPage extends BasePage {
    public static final By TEXT_ORDER_FEED = By.xpath(".//h1[text()='Лента заказов]");

    public static final By DIV_FEED_CONTAINER = By.xpath(".//div[@class='OrderFeed_contentBox__3-tWb']");
    public static final By UL_FEED_LIST = By.xpath(".//ul[@class='OrderFeed_list__OLh59']");
    public static final By LI_FEED_LIST_ITEM_CONTAINER = By.xpath(".//li[@class='OrderHistory_listItem__2x95r mb-6']");
    public static final By A_FEED_LIST_ITEM = By.xpath(".//a[@class='OrderHistory_link__1iNby']");

    public static final By P_HISTORY_LIST_ITEM_TRACK = By.xpath(".//div[@class='OrderHistory_textBox__3lgbs mb-6']/p[@class='text text_type_digits-default']");
    public static final By P_HISTORY_LIST_ITEM_TIME = By.xpath(".//div[@class='OrderHistory_textBox__3lgbs mb-6']/p[@class='text text_type_main-default text_color_inactive']");
    public static final By H2_HISTORY_LIST_ITEM_NAME = By.xpath(".//h2[@class='text text_type_main-medium mb-2']");
    public static final By P_HISTORY_LIST_ITEM_STATUS = By.xpath(".//p[@class='OrderHistory_visible__19YMB text text_type_main-small mb-7']");
    public static final By P_HISTORY_LIST_ITEM_PRICE = By.xpath(".//div[@class='OrderHistory_dataBox__1mkxK']/div/p");

    public static final By DIV_ORDERS_DATA_CONTAINER = By.xpath(".//div[@class='OrderFeed_ordersData__1L6Iv']");
    public static final By DIV_FEED_ORDER_STATUS_DATA_CONTAINER = By.xpath(".//ul[@class='OrderFeed_orderStatusBox__1d4q2 mb-15']");

    public static final By UL_FEED_READY_STATUS_LIST = By.xpath(".//ul[@class='OrderFeed_orderList__cBvyi']");
    public static final By LI_FEED_READY_STATUS_LIST_ITEM = By.xpath(".//li[@class='text text_type_digits-default mb-2']");

    public static final By UL_FEED_IN_WORK_STATUS_LIST =       By.xpath(".//ul[@class='OrderFeed_orderListReady__1YFem OrderFeed_orderList__cBvyi']");
    public static final By UL_FEED_IN_WORK_STATUS_EMPTY_LIST = By.xpath(".//ul[@class='OrderFeed_orderListReady__1YFem OrderFeed_orderList__cBvyi']");

    public static final By LI_FEED_IN_WORK_STATUS_LIST_ITEM =       By.xpath(".//li[@class='text text_type_digits-default mb-2']");
    public static final By LI_FEED_IN_WORK_STATUS_EMPTY_LIST_ITEM = By.xpath(".//li[@class='text text_type_main-small']");
    public static final By LI_FEED_IN_WORK_STATUS_EMPTY_LIST_ITEM_2 = By.xpath(".//li[@class='text text_type_main-small' and text()='Все текущие заказы готовы!']");

    public static final By P_FEED_TOTAL_ORDER_NUMBER = By.xpath(".//div/p[text()='Выполнено за все время:']/parent::div/p[@class='OrderFeed_number__2MbrQ text text_type_digits-large']");
    public static final By P_FEED_TODAY_ORDER_NUMBER = By.xpath(".//div/p[text()='Выполнено за сегодня:']/parent::div/p[@class='OrderFeed_number__2MbrQ text text_type_digits-large']");

    public OrderFeedPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open 'Order feed' Page")
    public OrderFeedPage openOrderFeedPage() {
        driver.get(ORDER_FEED_URL);
        return this;
    }

    @Step("Wait until 'Order feed' Page to be displayed")
    public OrderFeedPage waitUntilOrderFeedPageToBeDisplayed() {
        waitUntilPageDocumentToBeReady();
        waitUntilPageElementToBeDisplayed(TEXT_ORDER_FEED);
        return this;
    }

    @Step("Wait until 'Order feed' List to be displayed")
    public OrderFeedPage waitUntilOrderFeedListToBeDisplayed() {
        waitUntilPageElementToBeDisplayed(DIV_FEED_CONTAINER);
        waitUntilPageElementToBeDisplayed(UL_FEED_LIST);
        return this;
    }


}
