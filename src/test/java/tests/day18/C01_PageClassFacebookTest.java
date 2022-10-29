package tests.day18;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.Driver;

public class C01_PageClassFacebookTest {
    @Test
    public void test01() {
        Driver.getDriver().get("https://www.facebook.com");

        FacebookPage facebookPage = new FacebookPage();
        Faker faker= new Faker();

        facebookPage.email.sendKeys(faker.internet().emailAddress());
        facebookPage.password.sendKeys(faker.internet().password());

        facebookPage.girişYap.click();
        Assert.assertTrue(facebookPage.hatalıGirişYap.isDisplayed());








    }
}
