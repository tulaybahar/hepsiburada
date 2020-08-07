package main;

import base.PageBase;
import base.TestBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import java.util.List;


public class LoginPage extends TestBase {
    private RemoteWebDriver driver;
    public LoginPage(RemoteWebDriver driver) {
        this.driver = driver;
        thread.sleep(4000)
    }
    @FindBy(css = ".logo-hepsiburada")
    public WebElement Hepsiburadalogo;

    @FindBy(css = "div#SearchBoxOld input")
    public WebElement searchBox;

    @FindBy(css = "#SearchBoxOld > div > div > div.SearchBoxOld-buttonContainer")
    public WebElement searchIcon;

    @FindBy(css = "#categorySuggestionList > div.category-suggestion-title > h1")
    public WebElement searchText;

    @FindBy(css = "body > div.wrapper > main > div.container.page-content > div > div.brands-area > a:nth-child(1011) > span.brand-name")
    public WebElement iphoneText;

    public LoginPage assertLoginPageIsLoaded() {
        System.out.println("Hepsiburada sayfası yüklendi");
        Assert.assertTrue("Açılış sayfasında logo yüklenmedi", Hepsiburadalogo.isDisplayed());
        Assert.assertEquals("https://www.hepsiburada.com/", driver.getCurrentUrl());
        return this;
    }
    public LoginPage assertKeywordSearch() {
        searchBox.click();
        searchBox.sendKeys("IPhone");
        searchIcon.click();
        Assert.assertEquals("IPhone", searchText.getText());
        System.out.println("IPhone kelimesi başarıyla aratıldı");
        return this;
    }

}
