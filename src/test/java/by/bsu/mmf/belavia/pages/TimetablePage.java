package by.bsu.mmf.belavia.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimetablePage extends AbstractPage {

    private static final Logger logger = LogManager.getRootLogger();
    public final String BASE_URL = "https://belavia.by/time-table/";

    @FindBy(xpath = "//*[@id=\"OriginLocation_Combobox\"]")
    private WebElement openTagCheck;
    @FindBy(xpath = "//*[@id=\"OriginLocation_Combobox\"]")
    private WebElement fromInp;
    @FindBy(xpath = "/html/body/div[4]/div[1]/div/div/div[2]/form/div[1]/div[2]/div/label")
    private WebElement toInp;
    @FindBy(css = "div.col-mb-6:nth-child(1) > div:nth-child(1) > a:nth-child(3)")
    private WebElement departureDataInp;
    @FindBy(css = "div.col-mb-6:nth-child(2) > div:nth-child(1) > a:nth-child(3)")
    private WebElement returnDataInp;
    @FindBy(xpath = "/html/body/div[4]/div[1]/div/div/div[2]/form/div[2]/div[4]/div/button")
    private WebElement searchBtn;
    @FindBy(xpath = "/html/body/div[4]/div[3]/div/div[1]/h1")
    private WebElement checkBookingTag;
    @FindBy(xpath = "/html/body/div[4]/div[1]/div/ul/li[3]/a")
    private WebElement bookingStatusTag;
    @FindBy(xpath = "/html/body/div[4]/div[1]/div/div/div[6]/form/div[1]/div[2]/div/label")
    private WebElement reservationCodeInp;


    public TimetablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    public void openPage() {
        logger.info("timetable");
        driver.navigate().to(BASE_URL);
    }


    public boolean isPageOpened() {
        return openTagCheck.isDisplayed();
    }

    public void book(String flyFrom, String flyTo) {

        Actions actions = new Actions(driver);
        actions
                .sendKeys(fromInp,flyFrom)
                .sendKeys(toInp,flyTo)
                .pause(2000)
                .click(departureDataInp)
                .pause(1000)
                .click(returnDataInp)
                .pause(2000)
                .click(searchBtn)
                .pause(2000)
                .build()
                .perform();
    }


    public boolean isFlightsBooked() {
        return checkBookingTag.isDisplayed();
    }

    public boolean bookingCheck() {
        bookingStatusTag.click();

        return reservationCodeInp.isDisplayed();
    }
}
