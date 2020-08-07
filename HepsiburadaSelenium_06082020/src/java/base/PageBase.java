package base;

import org.apache.commons.exec.CommandLine;
import org.openqa.selenium.chrome.ChromeOptions;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.Configuration;
import org.junit.runners.model.Statement;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.Before;
import org.junit.Rule;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.io.FileHandler;

public class PageBase {
    public RemoteWebDriver driver;
    public static String browser;

    @Before
    public void initialize() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\thamzaoglu\\Downloads\\Automation için indirilenler\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver(chromeOptions);

        Configuration configuration = new Configuration();
        Thread.sleep(4000)
        driver.get(configuration.getBaseUrl());
    }
    @Rule
    public final TestRule watchman = new TestWatcher() {
     
        @Override
        protected void finished(Description description) {
            if (driver != null)
                driver.quit();
            System.out.println("Test is done");
        }
    };
}
