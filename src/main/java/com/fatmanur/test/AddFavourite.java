package com.fatmanur.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Thread.sleep;

public class AddFavourite {

    WebDriver driver;
    WebDriverWait webDriverWait;


    public AddFavourite(WebDriver _driver) {

        this.driver = _driver;
        this.webDriverWait = new WebDriverWait(driver, 30, 150);
    }


    public void TestStepsFavourite(String email, String password, String productName) {
        WebsiteUrl();
        LoginMenu(email, password);
        SearchProduct(productName);
    }

    public void WebsiteUrl() {

        ConnectUrl _connectURL = new ConnectUrl(driver);
        _connectURL.UrlAddress();

    }

    public void LoginMenu(String email, String password) {

        Login _login = new Login(driver);
        _login.LoginProcess(email, password);

    }

    public void SearchProduct(String productName) {


        SearchProduct _search = new SearchProduct(driver);
        _search.SearchProcess(productName);

        WebElement favouriteButton = driver.findElement(By.className("favorite"));
        favouriteButton.click();

        WebElement goFavouriteList = driver.findElement(By.linkText("Favori Listeme Git"));
        goFavouriteList.click();

        WebElement chkSelect = driver.findElement(By.id("ctl00_ContentPlaceHolder1_rptShoppingList_ctl01_chkSelect"));
        chkSelect.click();

        List<WebElement> btnDelete = driver.findElements(By.cssSelector(".link-button-trans.sprite"));
        btnDelete.get(0).click();
        driver.switchTo().alert().accept();


    }

    public WebElement findElement(By by) {
        WebElement webElement = driver.findElement(by);
        new Actions(driver).moveToElement(webElement).build().perform();
        scroll(webElement);
        return webElement;
    }

    public void scroll(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView({behavior: 'smooth', block: 'center', inline: 'center'})",
                webElement);
    }

    public void scrollPage() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,400)", "");


    }


}
