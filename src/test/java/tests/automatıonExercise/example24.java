package tests.automatıonExercise;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.nio.file.Files;
import java.nio.file.Paths;

public class example24 {
    AutomationExercisePage automationExercise = new AutomationExercisePage();

    @Test
    public void test01() throws InterruptedException {
// 2. 'http://automationexercise.com' url'sine gidin
        Driver.getDriver().get(ConfigReader.getProperty("automationExerciseUrl"));

        //            3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(automationExercise.automationExerciseAnaSayfa.isDisplayed());
// 4. Sepete ürün ekleyin
        automationExercise.elbisEkle.click();
// 5. 'Sepet' düğmesini tıklayın
        automationExercise.sepetiGoruntule.click();
// 6. Sepet sayfasının görüntülendiğini doğrulayın
        Assert.assertTrue(automationExercise.sepetSayfasi.isDisplayed());
// 7. Ödemeye Devam Et'e tıklayın
        automationExercise.odemeyeDevamEt.click();
// 8. 'Kaydol / Giriş Yap' düğmesine tıklayın
        automationExercise.registerLogin.click();
// 9. Kayıt bölümündeki tüm ayrıntıları doldurun ve hesap oluşturun
        Actions actions = new Actions(Driver.getDriver());
        automationExercise.kayitOlName.sendKeys("Emel");
        automationExercise.kayitOlEmail.sendKeys("hlkjhakfgk@gmail.com", Keys.ENTER);
        automationExercise.cinsiyetMrs.click();
        actions.sendKeys(Keys.TAB, Keys.TAB, "12345").sendKeys(Keys.TAB, "25").sendKeys(Keys.TAB, "April").sendKeys(Keys.TAB, "2000").
                sendKeys(Keys.TAB, Keys.SPACE).sendKeys(Keys.TAB, Keys.SPACE).sendKeys(Keys.TAB, "Tarık").sendKeys(Keys.TAB, "KILIÇKAYA").
                sendKeys(Keys.TAB, Keys.TAB, "Kayseri").sendKeys(Keys.TAB, Keys.TAB, "Canada").sendKeys(Keys.TAB, "Student").
                sendKeys(Keys.TAB, "Toronto").sendKeys(Keys.TAB, "38400").sendKeys(Keys.TAB, "123").sendKeys(Keys.TAB, Keys.ENTER).perform();
// 10. 'HESAP OLUŞTURULDU!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın
        Assert.assertTrue(automationExercise.hesapOlusturuldu.isDisplayed());
        automationExercise.continueButton.click();
// 11. En üstte 'Kullanıcı adı olarak oturum açıldı' seçeneğini doğrulayın
        Assert.assertTrue(automationExercise.oturumAcıldı.isDisplayed());

// 12.'Sepet' düğmesini tıklayın
        automationExercise.sepetButonu.click();
// 13. 'Ödemeye Devam Et' düğmesini tıklayın
        automationExercise.odemeyeDevamEt.click();
// 14. Adres Ayrıntılarını Doğrulayın ve Siparişinizi İnceleyin
        Assert.assertTrue(automationExercise.teslimatAdresi.isDisplayed());

// 15. Yorum metni alanına açıklama girin ve 'Sipariş Ver'i tıklayın

automationExercise.yorumMetniAlani.sendKeys("tesekkürler");
automationExercise.odemeyeDevamEt.click();
// 16. Ödeme ayrıntılarını girin: Karttaki Ad, Kart Numarası, CVC, Son Kullanma tarihi
        automationExercise.kartUzerindekiIsim.sendKeys("Habibe");
               actions. sendKeys(Keys.TAB, "123445").sendKeys(Keys.TAB,"122").sendKeys(Keys.TAB,"12").sendKeys(Keys.TAB,"2035").perform();

// 17. 'Öde ve Siparişi Onayla' düğmesine tıklayın
        automationExercise.odeVeSiparisiOnayla.click();
// 18. Başarı mesajını doğrulayın 'Siparişiniz başarıyla verildi!'
        Thread.sleep(3000);

        Assert.assertFalse(automationExercise.siparisMEsajio.isDisplayed());

// 19. 'Faturayı İndir' düğmesine tıklayın ve faturanın başarıyla indirildiğini doğrulayın.
        automationExercise.faturaIndir.click();
        String dosyaYolu="C:\\Users\\Habibe\\Desktop\\invoice (2).txt";
        Thread.sleep(3000);
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

// 20. 'Devam' düğmesini tıklayın
        automationExercise.continueButton.click();
// 21. 'Hesabı Sil' düğmesini tıklayın
        automationExercise.hesapSil.click();
// 22. 'HESAP SİLİNDİ!' seçeneğini doğrulayın. ve 'Devam' düğmesini tıklayın
    }










}
