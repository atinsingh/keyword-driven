package io.pragra.framework.keywords;

import io.pragra.framework.drivermanger.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KeyWordLoop {
    private static WebDriver driver;
    public static void runKeyWord(String keyWord) throws InterruptedException {
        if (keyWord.equals("OpenBrowser")) {
            driver = DriverManager.getDriver();
        }
        if (keyWord.equals("OpenAppUrl")) {
            driver.get("https://zoom.us");
        }
        if (keyWord.equals("ClickSales")) {
            driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul[1]/li[11]/a")).click();
        }
        if (keyWord.equals("PopulateSalesForm")) {
            System.out.println("Filling Form");
        }
        if (keyWord.equals("End")) {
            Thread.sleep(5000);
            DriverManager.quitDriver();
        }
    }
}
