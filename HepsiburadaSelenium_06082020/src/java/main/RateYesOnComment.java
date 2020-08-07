package main;

import base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import junit.framework.AssertionFailedError;
import org.junit.Assert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import java.util.List;
import java.util.Random;



public class RateYesonComment extends TestBase {

    RemoteWebDriver driver;
    public RateYesonComment(RemoteWebDriver driver) {
        this.driver = driver;
        Thread.sleep(4000)
    }

    @FindBy(css = "div#productresults li:nth-child(2) > div > a > div > h3 > div > p > span")
    public WebElement firstProductName;

    @FindBy(css = "a#productReviewsTab")
    public WebElement navigateToComments;

    @FindBy(css = ".ReviewCard-module-34AJ_:nth-child(1) .ReviewCard-module-1MoiF > span")
    public WebElement YesForFirstComment;

    @FindBy(css = "div#hermes-voltran-comments div.ReviewCard-module-uH6Em > span.ReviewCard-module-1ZiTv")
    public WebElement Verification;

    public RateYesonComment FirstProductDetail() {
        firstProductName.click();
        System.out.println("Ürün detayları açıldı.);
        return this;
    }
    public RateYesonComment Comments()  {
        Assert.assertTrue(navigateToComments.getText().contains("Yorum"));
        isElementPresent(driver , By.cssSelector("a#productReviewsTab"));
        navigateToComments.click();
        Assert.assertFalse(navigateToComments.getText().contains("Yorumlar (0)"));
        System.out.println("Hiç yorum olmadığı için işlem sonlandırıldı.");
        return this;
    }
    public RateYesonComment YesForFirstComment()  {
        isElementPresent(driver , By.cssSelector(".ReviewCard-module-34AJ_:nth-child(1) .ReviewCard-module-1MoiF > span"));
        Assert.assertTrue(YesForFirstComment.isDisplayed());
        YesForFirstComment.click();
        System.out.println("İlk yorum seçildi.");
        return this;
    }
    public RateYesonComment Verification()  {
        scrollToElement(driver , Verification);
        isElementPresent(driver , By.cssSelector("div#hermes-voltran-comments div.ReviewCard-module-uH6Em > span.ReviewCard-module-1ZiTv"));
        Assert.assertTrue(Verification.isDisplayed());
        Assert.assertTrue(Verification.getText().equals("Teşekkür Ederiz."));
        System.out.println("Teşekkürler mesajı doğrulandı.");
        return this;
    }
}
