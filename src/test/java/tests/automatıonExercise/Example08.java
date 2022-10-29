package tests.automatıonExercise;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AutomationExercisePage;
import utilities.ConfigReader;
import utilities.Driver;

public class Example08 {
    AutomationExercisePage automationexerciseObje = new AutomationExercisePage();

    @Test
    public void test01() {

//2. 'http://automationexercise.com' url'sine gidin

        Driver.getDriver().get(ConfigReader.getProperty("automationExerciseUrl"));

//3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        String istenilenUrL = "https://www.automationexercise.com/";
        String gercekUrL = Driver.getDriver().getCurrentUrl();
        Assert.assertEquals(istenilenUrL, gercekUrL);

//4. 'Ürünler' düğmesine tıklayın
        automationexerciseObje.products.click();

//5. Kullanıcının TÜM ÜRÜNLER sayfasına başarıyla gittiğini doğrulayın
        Assert.assertTrue(automationexerciseObje.allProducts.isDisplayed());
//6. Ürün listesi görünür
        Assert.assertTrue(automationexerciseObje.urunListesi.isDisplayed());


//7. İlk ürünün 'Ürünü Görüntüle'ye tıklayın
        automationexerciseObje.viewProduct.click();
//8. Kullanıcı, ürün detay sayfasına yönlendirilir
        Assert.assertTrue(automationexerciseObje.urunSayfası.isDisplayed());


//9. Ayrıntıların görünür olduğunu doğrulayın: ürün adı, kategori, fiyat, bulunabilirlik, durum, marka
        Assert.assertTrue(automationexerciseObje.urunAdi.isDisplayed() &&
                automationexerciseObje.urunKategorisi.isDisplayed() &&
                automationexerciseObje.fiyat.isDisplayed() && automationexerciseObje.bulunabilirlik.isDisplayed() &&
                automationexerciseObje.durum.isDisplayed() && automationexerciseObje.marka.isDisplayed());

    }
}