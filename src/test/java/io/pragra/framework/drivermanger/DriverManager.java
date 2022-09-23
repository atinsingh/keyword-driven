package io.pragra.framework.drivermanger;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static DriverManager instance;
    private WebDriver driver;
    private DriverManager(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    public synchronized static WebDriver getDriver(){
        if(instance==null){
            instance = new DriverManager();
        }
        return instance.driver;
    }

    public static void quitDriver(){
        if(instance!=null) {
            instance.driver.quit();
            instance=null;
        }
        return;
    }
}
