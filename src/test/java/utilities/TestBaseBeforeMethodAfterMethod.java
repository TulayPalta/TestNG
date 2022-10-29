package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class TestBaseBeforeMethodAfterMethod {
    protected static WebDriver driver;
    protected String tarih;
    protected Actions actions;


    @BeforeMethod(groups = "gp1")
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        actions=new Actions(driver);


        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter formater= DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String tarih=date.format(formater);
        System.out.println(date);
        System.out.println(tarih);

    }

    @AfterMethod(groups = "gp1")
    public void tearDown() {
        // driver.close();
    }



}
