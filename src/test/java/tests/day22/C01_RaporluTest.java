package tests.day22;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.TestBaseRapor;
import utilities.Driver;

public class C01_RaporluTest extends TestBaseRapor {
    @Test
    public void test01() {
        extentTest=extentReports.createTest("Pozitif Test","Gecerli kullanıcı adı ve password ile giris yapildi");

    //    -https://www.bluerentalcars.com/ adresine git
        Driver.getDriver().get(ConfigReader.getProperty("brcUrl"));
        extentTest.info("Blue Rent A CAr Sitesine gidildi");
//    -login butonuna bas
        BrcPage brcPage = new BrcPage();
        brcPage.brclogin.click();
        extentTest.info("login butonuna basildi");

//    -test data user email: customer@bluerentalcars.com ,
        brcPage.userEmail.sendKeys(ConfigReader.getProperty("userEmail"));
        extentTest.info("maile giriş yapıldı");
//    -test data password : 12345 dataları girip login e basın -login butonuna tiklayin
        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.TAB).sendKeys(ConfigReader.getProperty("pass")).sendKeys(Keys.ENTER).perform();
        extentTest.info("Dogru kullanıcı email ve password girildi");
        extentTest.info("2. login butonuna basildi");


//
//    -Degerleri girildiginde sayfaya basarili sekilde girilebildigini test et
        String actualUserName = brcPage.basariliGiris.getText();
        String expectedUserName = "John Walker";
        Assert.assertEquals(expectedUserName,actualUserName);
        extentTest.pass("Sayfaya basarili sekilde girildi");


    }
}
