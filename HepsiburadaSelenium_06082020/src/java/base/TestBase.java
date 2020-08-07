package base;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.MoveTargetOutOfBoundsException;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class TestBase {
    public void moveElement(RemoteWebDriver driver, WebElement webElement) throws InterruptedException {
        Actions actions = new Actions(driver);
        if (PageBase.browser.equalsIgnoreCase("chrome"))
            actions.moveToElement(webElement).build().perform();
           {
            int x = webElement.getLocation().getX() + (webElement.getSize().getWidth() / 2);
            int y = webElement.getLocation().getY() + (webElement.getSize().getHeight() / 2);

            try {
                actions.moveByOffset(x, y).build().perform();
            } catch (MoveTargetOutOfBoundsException e) {
                scrollToElement(driver, webElement);
                actions.moveToElement(webElement).build().perform();
            }

            Thread.sleep(500);
        }
    }
    public void scrollToElement(RemoteWebDriver driver, WebElement webElement) {
        javascriptExecutor(driver).executeScript("window.scrollTo(" + webElement.getLocation().x + "," + webElement.getLocation().y + ");");
    }
}
