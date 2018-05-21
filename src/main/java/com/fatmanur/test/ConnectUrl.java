package com.fatmanur.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConnectUrl {


    WebDriver driver;



    public ConnectUrl(WebDriver _driver)
    {
        this.driver = _driver;
    }

    public void UrlAddress(){


        driver.get("https://www.hepsiburada.com/");

    }

}
