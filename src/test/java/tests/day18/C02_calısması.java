package tests.day18;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_calısması {
    @Test
    public void test01() {
        // https://www.hotelmycamp.com/ adresine git
       Driver.getDriver().get(ConfigReader.getProperty("hmcUrl"));










    }

}
