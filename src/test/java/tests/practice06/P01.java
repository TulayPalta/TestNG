package tests.practice06;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import pages.DhtmlgoodiesPage;
import utilities.Driver;

public class P01 {
    // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
// Fill in capitals by country.

    @Test
    public void test01() {
        // Go to URL : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
        Driver.getDriver().get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        DhtmlgoodiesPage dhtmlgoodiesPage = new DhtmlgoodiesPage();
        Actions actions = new Actions(Driver.getDriver());
        actions.dragAndDrop(dhtmlgoodiesPage.oslo, dhtmlgoodiesPage.norway).
                dragAndDrop(dhtmlgoodiesPage.stockholm, dhtmlgoodiesPage.sweden).
                dragAndDrop(dhtmlgoodiesPage.washington, dhtmlgoodiesPage.unitedStates).
                dragAndDrop(dhtmlgoodiesPage.copenhagen, dhtmlgoodiesPage.denmark).
                dragAndDrop(dhtmlgoodiesPage.seoul, dhtmlgoodiesPage.southKorea).
                dragAndDrop(dhtmlgoodiesPage.rome, dhtmlgoodiesPage.ıtaly).
                dragAndDrop(dhtmlgoodiesPage.madrid, dhtmlgoodiesPage.spain).perform();
    }
    /*
        frameworkle rbüyüdükce yeni webelementler yeni classlar yebni methodlar olusturdukca içinden cıkılmaz
        anlasılmakz tekrar bakımı yapılamaz , güncellemesi cok zor hatta ımkansız bır hal alır
        uzmanlar reusable maintaınable rahat manipula edilebilir bir framework ıcın bir design pattern olarak POM page object
        model de karar vermişler
        olmazsa olmazlar
        driver class
        page class
        test class
        utilities class;
        aradıgımız bir metodu veya bir metodu kolaylıkla bulabilmek ve güncelleyebilmek için javadan ögrenmiş oldugumuz oop concept selenium ile page object model de
        birlestirilmiştir
        */
}
