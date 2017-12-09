package by.bsu.mmf.belavia;

import by.bsu.mmf.belavia.steps.Steps;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class MainPageTest {

    private static final String  USER_ID = "10011416192";
    private static final String PASSWORD = "123456789";
    public static final String EXPECTED_NAME = "IVAN ZHUK";
    private Steps steps;
    @BeforeMethod(description = "Init browser")
    public void setUp()
    {
        steps = new Steps();
        steps.initBrowser();
    }

    @Test
    public void accessToMainPageTest() {
        Assert.assertTrue(steps.accessToMainPage());
    }

    @Test
    public void menuTest() {
        Assert.assertTrue(steps.checkMenu());
    }

    @Test(description = "auth test")
    public void authTest() {

        String username = steps.login(USER_ID,PASSWORD);
        Assert.assertEquals(username, EXPECTED_NAME);
    }



    @AfterMethod(description = "Stop Browser")
    public void stopBrowser()
    {
        steps.closeDriver();
    }
}
