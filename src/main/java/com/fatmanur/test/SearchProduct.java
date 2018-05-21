package com.fatmanur.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Thread.sleep;

public class SearchProduct {


    WebDriver driver;

    WebDriverWait webDriverWait;


    public SearchProduct(WebDriver _driver) {
        this.driver = _driver;
        this.webDriverWait = new WebDriverWait(driver, 30, 150);
    }

    public void SearchProcess(String productName) {

        //bazı zamanlar sayfada bir pop-up çıkıyor ve bu arama yapılmasını veya butona basılmasını engelleyebiliyor
        //bu nedenle eğer o pop-up varsa kapatılıyor ve 3 sn bekledikten sonra butona basılması sağlanıyor.
        Boolean popUpVarMi = driver.findElements(By.className("insider-opt-in-notification")).size() > 0;
        if (popUpVarMi) {
            WebElement popUpKapat = driver.findElement(By.cssSelector(".insider-opt-in-notification-button.insider-opt-in-disallow-button"));
            popUpKapat.click();
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


        WebElement fillSearch = driver.findElement(By.id("productSearch"));
        fillSearch.sendKeys(productName);

        WebElement searchBox = driver.findElement(By.id("buttonProductSearch"));
        searchBox.click();


        List<WebElement> webElements = driver.findElements(By.cssSelector(".price.product-price"));
        System.out.println("product price " + webElements.get(4).getText());
        webElements.get(4).click();


    }
}