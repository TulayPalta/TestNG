package tests.practice05;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class P02 extends TestBaseBeforeMethodAfterMethod {
    @Test
    public void test01() {
        // 1. "http://webdriveruniversity.com/Popup-Alerts/index.html" adresine gidin
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

        // 2. JavaScript alertin "CLICK ME!" seçeneğine tıklayın
        driver.findElement(By.xpath(" //span[@id='button1']")).click();

        // 3. Açılır metni alın
        String actualText=  driver.switchTo().alert().getText();

        // 4. Mesajın "I am an alert box!" olduğunu doğrulayın.
        String expectedTExt="I am an alert box!";

        //Assert.assertTrue(actualText.contains(expectedTExt));
        Assert.assertEquals(expectedTExt,actualText);

        //Assert.assertEquals("I am an alert box!", driver.switchTo().alert().getText());
        // 5. Açılır pencereyi kabul edin
        driver.switchTo().alert().accept();




    }
}
