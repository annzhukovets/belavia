package by.bsu.mmf.belavia.listener;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;

public class EventHandler extends AbstractWebDriverEventListener {

    private final Logger logger = LogManager.getRootLogger();

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        logger.info("clicked on" + element.toString());

        if ("a".equals(element.getTagName() )) {
            logger.info("this is link to " + element.getAttribute("href"));
        }

        super.afterClickOn(element, driver);
    }
}
