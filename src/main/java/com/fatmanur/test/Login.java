package com.fatmanur.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

    WebDriver driver;

    WebDriverWait webDriverWait;


    public Login(WebDriver _driver)
    {
        this.driver = _driver;
        this.webDriverWait = new WebDriverWait(driver, 30, 150);
    }

    public void  LoginProcess(String email, String password)
    {

        driver.findElement(
                By.cssSelector(".insider-opt-in-notification-button.insider-opt-in-disallow-button"))
                .click();

        WebElement mainLoginButton = driver.findElement(By.id("myAccount"));
        mainLoginButton.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(mainLoginButton).build().perform();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.id("login"))).click();


        WebElement fillEmail = driver.findElement(By.id("email"));
        fillEmail.sendKeys(email);

        WebElement fillPassword = driver.findElement(By.id("password"));
        fillPassword.sendKeys(password);

        WebElement btnLogin = driver.findElement(By.cssSelector(".btn.full.btn-login-submit"));
        btnLogin.click();


        //Eğer anasayfada hesabım butonu varsa giriş yapıldığı onaylanıyor.
        Boolean isPresent=driver.findElements(By.xpath("//*[@id=\"myAccount\"]/span")).size()>0;
        if(isPresent==false) System.out.println("User login is successful");
        else System.out.println("login is failed");
;

    }
}
