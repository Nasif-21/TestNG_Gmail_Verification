package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Setup {
    public WebDriver driver;

    @BeforeTest
    public void setup()
    {
        driver=new ChromeDriver();                                           //Setting up web driver
        driver.manage().window().maximize();                                 //Commanding to make driver screensize full
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));   //Adding a implecit waiter
        driver.get("https://dailyfinance.roadtocareer.net/");                //Telling which site is needed to redirect

    }
    @AfterTest
    public void tearDown()
    {
        //driver.quit();                                            //Quit after all the tests are done

    }
}
