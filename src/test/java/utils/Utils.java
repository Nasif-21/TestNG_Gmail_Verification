package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {

    public static int randomNumber(int min, int max)
    {
        double randNum=Math.random()*(max-min)+min;
        return (int) randNum;

    }
    public static void scroll(WebDriver driver,int px)
    {
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,"+px+")");

    }

}
