package tests.practice07;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.WebUniversityPage;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P01 {
    @Test
    public void test01() throws InterruptedException {
        //  // http://webdriveruniversity.com/To-Do-List/index.html adresine gidin adresine gidin
        Driver.getDriver().get("http://webdriveruniversity.com/To-Do-List/index.html");

        // Todos ekle: (Kahvaltıyı hazırla, Bulaşıkları yıka, Bebekle ilgilen, Çocuğunun ödevine yardım et, Selenyum çalış, Uyu)
        WebUniversityPage webUniversityPage = new WebUniversityPage();

        //Buradaki listeyi yapılacaklar listesine tek tek manuel olarak eklemek yerine toplu olarak bir loop kullanarak gönderebilmek
        //amacı ile biz olusturduk
        List<String> worklist = new ArrayList<>(Arrays.asList("Kahvaltıyı hazırla", "Bulaşıkları yıka", "Bebekle ilgilen", "Çocuğunun ödevine yardım et", "Selenyum çalış", "Uyu"));
        Actions actions = new Actions(Driver.getDriver());
        for (String w : worklist) {
            actions.click(webUniversityPage.addNewTodo).sendKeys(w).sendKeys(Keys.ENTER).perform();
        }
        Thread.sleep(2000);

        //Tüm yapılacakların üzerini çiz.
        List<WebElement> todos = webUniversityPage.todosWebelement;
        for (WebElement w : todos) {
            w.click();
        }
        Thread.sleep(2000);

        //Tüm yapılacakları sil.
        List<WebElement> deleteButtons = webUniversityPage.deleteButtonWebelement;
        for (WebElement w : deleteButtons) {
            w.click();
        }
        Thread.sleep(2000);

        //Tüm yapılacakların silindiğini doğrulayın.
        List<WebElement> newtodos = webUniversityPage.newtodosWebelement;
        Assert.assertFalse(newtodos.isEmpty());

        /*
        Keşif Testi (Exploratory Testing) , test senaryolarının önceden oluşturulmadığı,
         testçilerin sistemi test anında kontrol ettiği bir tür yazılım testidir.
          Herhangi bir test senaryosuna bağlı kalmaksızın yazılımları serbestçe keşfederek buldukları bug’ları
          raporlamasına dayanır. Test uzmanlarının minimum planlama ve maksimum test uygulamasına
          katıldığı uygulamalı bir yaklaşımdır. Testin yürütülmesinden önce neyin test edileceğine
          dair fikirleri not edebilirler.
        Keşif Testi (Exploratory Testing), diğer test yaklaşımlarında kolayca kapsanmayan
        hataları ve eksiklikleri keşfetmeye, ortaya çıkarmaya dayanır. Özellikle yazılım test
         döngüsünün başlarında sıkça başvurulan bir test türüdür. Test uzmanı açısından ise istediği
         şekilde son kullanıcı senaryoları oluşturma imkanı olduğu için eğlencelidir.
         */

    }
}