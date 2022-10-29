package tests.day16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class homework01 extends TestBaseBeforeMethodAfterMethod {
    @Test(priority = 0)
    public void test1() {
        //Priority
        //1) Bir class olusturun: YoutubeAssertions
        //2) https://www.youtube.com adresine gidin
        //3) Asagidaki adlari kullanarak 4 test metodu olusturun ve gerekli testleri yapin
        //titleTest> Sayfa basliginin "YouTube" oldugunu test edin
        //imageTest> YouTube resminin goruntulendigini (isDisplayed()) test edin
        //Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        //wrongTitleTest => Sayfa basliginin "youtube" olmadigini dogrulayin
        driver.get("https://www.youtube.com");
    }

    @Test(priority = 1)
    public void titleTest() {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains("YouTube"));
    }

    @Test(priority = 2)
    public void imageTest() {
        WebElement logo = driver.findElement(By.xpath("//*[@id='logo-icon']"));
        Assert.assertTrue(logo.isDisplayed());
    }

    @Test(priority = 3)
    public void SearchBox() {
        WebElement searchBox = driver.findElement(By.xpath("(//*[@id='search'])[3]"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test(priority = 4)
    public void wrongTitleTest() {
        String tittle = driver.getTitle();
        Assert.assertNotEquals(tittle, "youTube");

    }
}