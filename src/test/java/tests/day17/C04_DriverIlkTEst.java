package tests.day17;

import org.testng.annotations.Test;
import utilities.Driver;

public class C04_DriverIlkTEst {
    @Test
    public void test01() {
        /*
TestBase class'ına extend ederek kullandığımız driver yerine artık Driver class'ından kullanacağımız
getDriver() static method'unu kullanırız
 */
        Driver.getDriver().get("https://www.amazon.com");
        Driver.getDriver().get("https://www.bestbuy.com");
        Driver.closeDriver();
        Driver.getDriver().get("https://www.hepsiburada.com");
        Driver.closeDriver();
    }
}
