package tests.automatıonExercise;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SauceDemo;
import utilities.ConfigReader;
import utilities.Driver;

public class example01 {
    SauceDemo sauceDemo = new SauceDemo();
    Actions  actions = new Actions(Driver.getDriver());

    @Test
    public void test01() {

        // https://www.saucedemo.com/ adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("saucedemoUrl"));

// Username ve password kullanarak giriş yapın
       sauceDemo.usernameKutusu.sendKeys(ConfigReader.getProperty("saudecemoUserName"));
       sauceDemo.passwordKutusu.sendKeys(ConfigReader.getProperty("saudecemePassword"));
       sauceDemo.login.click();
// İlk ürün olarak görünen çantaya tıklayın
        sauceDemo.ilkUrunCanta.click();
// Çantanın sayfasında çantayı sepete ekleyin
        sauceDemo.sepeteEkle.click();

// Sepet sayfasına gidin
        sauceDemo.sepetiGoruntule.click();

// Çantanın sepette olduğunu test edin
        Assert.assertTrue(sauceDemo.sepettekiCanta.isDisplayed());

// Checkout butonuna tıklayın
        sauceDemo.checkout.click();

// İsim, soyisim ve posta kodunu girin
        sauceDemo.firstName.sendKeys("Habibe");
        actions.sendKeys(Keys.TAB,"Soysal").sendKeys(Keys.TAB,"12345").perform();

// Continue butonuna tıklayın
        sauceDemo.continueButton.click();

// Açılan sayfada finish butonuna tıklayın
        sauceDemo.finishButton.click();

// THANK YOU FOR YOUR ORDER yazısının çıktığını test edip tarayıcıyı kapatın
        Assert.assertTrue(sauceDemo.thankYouYazisi.isDisplayed());
        Driver.closeDriver();
    }

}