package by.bsu.mmf.belavia.steps;


import by.bsu.mmf.belavia.driver.DriverSingleton;
import by.bsu.mmf.belavia.pages.MainPage;
import by.bsu.mmf.belavia.pages.ProfilePage;
import by.bsu.mmf.belavia.pages.TimetablePage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


public class Steps {

    private WebDriver driver;

    private final Logger logger = LogManager.getRootLogger();

    public void initBrowser()
    {
        driver = DriverSingleton.getDriver();
    }

    public void closeDriver() {
        driver.quit();
    }


    public boolean accessToMainPage() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();

        return mainPage.isLogoAvailable();
    }

    public boolean checkMenu() {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();

        return mainPage.isMenuDisplayed();
    }

    public String login(String userId, String password) {
        MainPage mainPage = new MainPage(driver);
        mainPage.openPage();

        mainPage.login(userId,password);

        return mainPage.getUsername();
    }

    public String changePassportId(String passportId) {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openPage();

         profilePage.changePassportId(passportId);

         return profilePage.getPassportId();
    }

    public String changeCountry(String country) {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openPage();

        profilePage.changeCountry(country);

        return profilePage.getCountry();

    }

    public String changePlaceOfEmpl(String placeOfEmployment) {
        ProfilePage profilePage = new ProfilePage(driver);
        profilePage.openPage();

        profilePage.changePlaceOfEmpl(placeOfEmployment);

        return profilePage.getPlaceOfEmpl();
    }

    public boolean checkAccessToTte() {
        TimetablePage timetablePage = new TimetablePage(driver);
        timetablePage.openPage();

        return timetablePage.isPageOpened();
    }

    public boolean bookFlights(String flyFrom, String flyTo) {
        TimetablePage timetablePage = new TimetablePage(driver);
        timetablePage.openPage();

        timetablePage.book(flyFrom, flyTo);

        return timetablePage.isFlightsBooked();
    }

    public boolean canCheckBooking() {
        TimetablePage timetablePage = new TimetablePage(driver);
        timetablePage.openPage();

        return timetablePage.bookingCheck();

    }
}
