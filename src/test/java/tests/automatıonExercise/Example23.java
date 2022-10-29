package tests.automatıonExercise;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class Example23 {
    @Test
    public void test01() {

        //2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("aeUrl"));
        //3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        AutomationExercisePage automationExercise = new AutomationExercisePage();
        Assert.assertTrue(automationExercise.automationExerciseAnaSayfa.isDisplayed());

        //4. 'Kayıt Ol / Giriş Yap' düğmesini tıklayın
        automationExercise.kayitOlGirisYap.click();
        //5. Kaydolma bölümündeki tüm ayrıntıları doldurun ve hesap oluşturun
        Actions  actions = new Actions(Driver.getDriver());
        automationExercise.kayitOlName.sendKeys("Tarık");
        automationExercise.kayitOlEmail.sendKeys("hyhjgk@gmail.com", Keys.ENTER);
        automationExercise.cinsiyetMrs.click();
        actions.sendKeys(Keys.TAB, Keys.TAB, "12345").sendKeys(Keys.TAB, "25").sendKeys(Keys.TAB, "April").sendKeys(Keys.TAB, "2000").
                sendKeys(Keys.TAB, Keys.SPACE).sendKeys(Keys.TAB, Keys.SPACE).sendKeys(Keys.TAB, "Tarık").sendKeys(Keys.TAB, "KILIÇKAYA").
                sendKeys(Keys.TAB, Keys.TAB, "Kayseri").sendKeys(Keys.TAB, Keys.TAB, "Canada").sendKeys(Keys.TAB, "Student").
                sendKeys(Keys.TAB, "Toronto").sendKeys(Keys.TAB, "38400").sendKeys(Keys.TAB, "123").sendKeys(Keys.TAB, Keys.ENTER).perform();
        //6. 'HESAP OLUŞTURULDU!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın
Assert.assertTrue(automationExercise.hesapOlusturuldu.isDisplayed());
automationExercise.continueButton.click();

        //7. En üstte 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
        Assert.assertTrue(automationExercise.oturumAcıldı.isDisplayed());
        //8. Sepete ürün ekleyin
        automationExercise.elbisEkle.click();

        //9. 'Sepet' düğmesini tıklayın
        automationExercise.sepetiGoruntule.click();

        //10. Sepet sayfasının görüntülendiğini doğrulayın
        Assert.assertTrue(automationExercise.sepetSayfasi.isDisplayed());

        //11. Ödemeye Devam Et'e tıklayın
        automationExercise.odemeyeDevamEt.click();
        //12. Teslimat adresinin, hesap kaydı sırasında girilen adresle aynı olduğunu doğrulayın.
        //13. Fatura adresinin, hesap kaydı sırasında girilen adresle aynı olduğunu doğrulayın.
        Assert.assertNotEquals(automationExercise.teslimatAdresi.getText(),automationExercise.faturaAdresi.getText());

        //14. 'Hesabı Sil' düğmesini tıklayın
        automationExercise.hesapSil.click();

        //15. 'HESAP SİLİNDİ!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın
Driver.closeDriver();


    }
}