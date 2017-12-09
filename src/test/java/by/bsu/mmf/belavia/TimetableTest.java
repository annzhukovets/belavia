package by.bsu.mmf.belavia;

import by.bsu.mmf.belavia.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TimetableTest {

    private static final String FLY_FROM = "Baku";
    private static final String FLY_TO = "Minsk";
    private Steps steps;

    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }



    @Test(description = "timetable access test")
    public void timetableAccessTest() {
        Assert.assertTrue(steps.checkAccessToTte());
    }

    @Test(description = "booking flights test")
    public void bookingOfFlightsTest() {
        Assert.assertTrue(steps.bookFlights(FLY_FROM,FLY_TO));
    }

    @Test(description = "booking status checking test")
    public void bookingStatusCheckingTestt() {
        Assert.assertTrue(steps.canCheckBooking());
    }


    @AfterMethod(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
