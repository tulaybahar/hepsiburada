package test;

import base.PageBase;
import org.junit.Test;
import main.LoginPage;
import main.RateYesOnComment;

public class CoreTest extends PageBase {

    @Test
    public void selectProductComment() throws Exception {
        LoginPage loginPage = new LoginPage(driver);
        RateYesOnComment rateYesOnComment = new RateYesOnComment(driver);

        loginPage
                .assertLoginPageIsLoaded()
                .assertSearch();
        rateYesOnComment
                .FirstProductDetail()
                .Comments()
                .YesForFirstComment()
                .Verification();
    }


}
