package by.bsu.mmf.belavia;

import by.bsu.mmf.belavia.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProfileTest {

    private static final String  USER_ID = "10011416192";
    private static final String PASSWORD = "123456789";
    private static final String PASSPORT_ID = "MC2099742";
    private static final String PLACE_OF_EMPLOYMENT = "NASHA NIVA";
    private Steps steps;
    private static final String COUNTRY = "Austria";

    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

        @Test(description = "change passport id")
    public void changePassportDataTest() {
        String username = steps.login(USER_ID,PASSWORD);
        Assert.assertEquals(steps.changePassportId(PASSPORT_ID),PASSPORT_ID);
    }

    @Test(description = "change country")
    public void changeCountry() {
        steps.login(USER_ID,PASSWORD);
        Assert.assertEquals(steps.changeCountry(COUNTRY),COUNTRY);
    }

    @Test(description = "change place of employment")
    public void changePlaceOfEmployment() {
        steps.login(USER_ID,PASSWORD);
        Assert.assertEquals(steps.changePlaceOfEmpl(PLACE_OF_EMPLOYMENT),PLACE_OF_EMPLOYMENT);
    }


    @AfterMethod(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }

}
