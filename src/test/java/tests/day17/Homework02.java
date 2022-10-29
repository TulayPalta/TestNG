package tests.day17;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.ZeroWebAppSecurityPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Homework02  {
    @Test
    public void test01() {
        //“http:zero.webappsecurity.com/” Adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("zeroWebAppUrl"));
        //        Sign in butonuna basin
        ZeroWebAppSecurityPage zeroWebAppSecurityPage=new ZeroWebAppSecurityPage();
        zeroWebAppSecurityPage.ilkSayfaSignIn.click();
//        Login kutusuna “username” yazin
        zeroWebAppSecurityPage.login.sendKeys("username");
//        Password kutusuna “password” yazin
        zeroWebAppSecurityPage.passwword.sendKeys("password");
//        Sign in tusuna basin
        zeroWebAppSecurityPage.signIn.click();
        Driver.getDriver().navigate().back();
//        Online banking menusu icinde Pay Bills sayfasina gidin
        zeroWebAppSecurityPage.onlineBankingMenu.click();
        zeroWebAppSecurityPage.payBills.click();
//        “Purchase Foreign Currency” tusuna basin
        zeroWebAppSecurityPage.purchaseForeign.click();
//        “Currency” drop down menusunden Eurozone’u secin
        Select select=new Select(zeroWebAppSecurityPage.currencyDropDown);
        select.selectByValue("EUR");
//        soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(zeroWebAppSecurityPage.currencyDropDown.getText().equals("Eurozone(Euro)"));
//        soft assert kullanarak DropDown listesinin su secenekleri oldugunu test edin  "Select One", "Australia (dollar)", "Canada (dollar)","Switzerland (franc)","China  (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain (pound)","Hong Kong  (dollar)","Japan (yen)","Mexico (peso)","Norway (krone)","New Zealand  (dollar)","Sweden (krona)","Singapore (dollar)","Thailand (baht)"
//11
        List<WebElement> dropDownMenuList = select.getOptions();
        List<String> expectedList = new ArrayList<>(Arrays.asList("Select One", "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)", "China (yuan)", "Denmark (krone)",
                "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)", "Norway (krone)", "New Zealand (dollar)",
                "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"));
        //    System.out.println(ddmList1.get(0).getText());   Ornek olsun ne veriyor diye
        for (int i = 0; i <dropDownMenuList.size() ; i++) {
            softAssert.assertEquals(dropDownMenuList.get(i).getText(),
                    expectedList.get(i) ,i+ ".elementler esit degil");
 }

        Driver.closeDriver();

    }
}
