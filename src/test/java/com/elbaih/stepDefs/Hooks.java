package com.elbaih.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.concurrent.TimeUnit;

public class Hooks {

public static WebDriver driver;
    @Before
public  static void start()
    {
        WebDriverManager.firefoxdriver().setup();
driver  = new FirefoxDriver(new FirefoxOptions());
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//driver.get( "http://www.demo.guru99.com/V4/");
    }







    @After
    public static void end(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        driver.close();
        driver.quit();
    }

    }

