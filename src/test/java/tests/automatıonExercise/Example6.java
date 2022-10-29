package tests.automatıonExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class Example6 extends TestBaseBeforeMethodAfterMethod {
    @Test
    public void test01() {
        //2. 'http://automationexercise.com' url'sine gidin
        driver.get("http://automationexercise.com");

//3. Ana sayfanın başarıyla görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//html")).isDisplayed());
//4. 'Bize Ulaşın' düğmesine tıklayın
        driver.findElement(By.xpath("//*[@class='fa fa-envelope']")).click();


//5. 'GET IN TOUCH'un görünür olduğunu doğrulayın
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Get In Touch']")).isDisplayed());
//6. Adı, e-posta adresini, konuyu ve mesajı girin
        WebElement name = driver.findElement(By.xpath("//*[@data-qa='name']"));
        Actions actions = new Actions(driver);
        actions.sendKeys(name, "Habibe").sendKeys(Keys.TAB, "hsoysal2023@gmail.com").sendKeys(Keys.TAB, "Hesap Sil").
                sendKeys(Keys.TAB, "Hesabınızı silin").perform();
//7. Dosya yükle
        driver.findElement(By.xpath("//*[@name='upload_file']")).sendKeys("C:\\Users\\Habibe\\Desktop\\hesapsilfotograf.png");
//8. 'Gönder' düğmesini tıklayın
        driver.findElement(By.xpath("//*[@data-qa='submit-button']")).click();

//9. Tamam düğmesine tıklayın
        driver.switchTo().alert().accept();
//10. Başarı mesajını doğrulayın 'Success! Bilgileriniz başarıyla gönderildi.' görünür
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='status alert alert-success']")).isDisplayed());
//11. 'Ana Sayfa' düğmesini tıklayın ve ana sayfaya başarıyla indiğini doğrulayın
        driver.findElement(By.xpath("//*[@class='fa fa-angle-double-left']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='fa fa-home']")).isEnabled());


    }
}