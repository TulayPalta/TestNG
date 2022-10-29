package tests.practice06;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.SauceDemoPAge;
import utilities.Driver;

public class Homework {
    @Test
    public void test01() {

        //   * Navigate to  https://www.saucedemo.com/
        Driver.getDriver().get("https://www.saucedemo.com/");

//     * Enter the username  as standard_user
        SauceDemoPAge sauceDemoPAge = new SauceDemoPAge();
        sauceDemoPAge.userName.sendKeys("standard_user");

//     * Enter the password as   secret_sauce
        sauceDemoPAge.password.sendKeys("secret_sauce");
//     * Click on login button
        sauceDemoPAge.loginButton.click();
//     * Choose price low to high
        Select select=new Select(sauceDemoPAge.dropDownMenu);
select.selectByValue("lohi");

//       and verify that PRICE (LOW TO HIGH) is visible
        Assert.assertTrue(sauceDemoPAge.lowToHigh.isEnabled());
Driver.quitDriver();
    }}

