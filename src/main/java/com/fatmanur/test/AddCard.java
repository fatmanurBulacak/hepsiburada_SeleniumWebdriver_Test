package com.fatmanur.test;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

import static java.lang.Thread.sleep;

public class AddCard {

    WebDriver driver;
    WebDriverWait webDriverWait;


    public AddCard(WebDriver _driver) {

        this.driver = _driver;
        this.webDriverWait = new WebDriverWait(driver, 30, 150);
    }

    public void TestStepsAddCard(String email, String password, String productName) {
        WebsiteUrl();
        UserLogin(email, password);
        SearchProduct(productName);
        OrderProduct();


    }

    public void WebsiteUrl() {

        ConnectUrl _connectURL = new ConnectUrl(driver);
        _connectURL.UrlAddress();

    }

    public void UserLogin(String email, String password) {


        Login _login = new Login(driver);
        _login.LoginProcess(email, password);

    }

    public void SearchProduct(String productName) {

        SearchProduct _search = new SearchProduct(driver);
        _search.SearchProcess(productName);


        WebElement addCard = driver.findElement(By.id("addToCart"));
        addCard.click();

        System.out.println(driver.findElement(By.xpath("//div[@class='price']")).getText());


        if ((driver.getClass().equals("price product-price")) == (driver.getClass().equals("//div[@class='price']")))
            System.out.println("the prices are the same");
        else System.out.println("prices are not the same");


    }

    public void AddAddress(String firstName, String lastName) {

        WebElement fillFirstName = driver.findElement(By.id("first-name"));
        fillFirstName.sendKeys(firstName);

        WebElement fillLastName = driver.findElement(By.id("last-name"));
        fillLastName.sendKeys(lastName);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,700)", "");


        //Ülke dropdown listin xpath yolu
        WebElement getCountry = driver.findElement(By.xpath("\n" +
                " //*[@id=\"form-address\"]/div/div/section[2]/div[1]/div/div/button/span[2]"));
        getCountry.click();

        //Türkiye'nin xpath yolu
        WebElement fillCountry = driver.findElement(By.xpath("//*[@id=\"form-address\"]/div/div/section[2]/div[1]/div/div[1]/div/ul/li[153]/a/span"));
        fillCountry.click();

        //Sehir dropdown listinin xpath yolu
        WebElement getCity = driver.findElement(By.xpath("//*[@id=\"form-address\"]/div/div/section[2]/div[2]/div/div/button"));
        getCity.click();

        //Balıkesir'in Xpath yolu
        WebElement fillCity = driver.findElement(By.xpath("//*[@id=\"form-address\"]/div/div/section[2]/div[2]/div/div[1]/div/ul/li[13]/a/span"));
        fillCity.click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

            e.printStackTrace();
        }
        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("window.scrollBy(0,400)", "");

        //İlce dropdown listin Xpath yolu
        WebElement getTown = driver.findElement(By.xpath("//*[@id=\"form-address\"]/div/div/section[2]/div[3]/div/div/button"));
        getTown.click();

        // Balıkesir Altıeylül ilçesinin xpath yolu
        WebElement fillTown = driver.findElement(By.xpath("//*[@id=\"form-address\"]/div/div/section[2]/div[3]/div/div/div/ul/li[2]/a/span"));
        fillTown.click();

        WebElement fillAddress = driver.findElement(By.id("address"));
        fillAddress.sendKeys("Bahçelievler mah.");

        WebElement fillAddressName = driver.findElement(By.id("address-name"));
        fillAddressName.sendKeys("evimmm");

        WebElement fillPhone = driver.findElement(By.id("phone"));
        fillPhone.sendKeys("5221000000");

        WebElement btnContinue = driver.findElement(By.cssSelector(".btn.btn-primary.full"));
        btnContinue.click();

    }

    public void AddPaymentInformation(){

        WebElement  cardNo = driver.findElement(By.id("card-no"));
        cardNo.sendKeys("5205 2052 0583 4267");

        WebElement  holderName = driver.findElement(By.id("holder-Name"));
        holderName.sendKeys("fatmanur");

        WebElement btnMounth = driver.findElement(By.xpath("//*[@id=\"form-credit-card\"]/fieldset/div[3]/div/div[1]/div/button/span[2]"));
        btnMounth.click();

        WebElement fillMounth = driver.findElement(By.xpath("//*[@id=\"form-credit-card\"]/fieldset/div[3]/div/div[1]/div/div/ul/li[10]/a/span"));
        fillMounth.click();

        WebElement btnYear = driver.findElement(By.xpath("\n" +
                "        //*[@id=\"form-credit-card\"]/fieldset/div[3]/div/div[2]/div/button/span[2]"));
        btnYear.click();


        WebElement fillYear = driver.findElement(By.xpath("//*[@id=\"form-credit-card\"]/fieldset/div[3]/div/div[2]/div/div/ul/li[10]/a/span"));
        fillYear.click();

        WebElement  fillCvc = driver.findElement(By.id("cvc"));
        fillCvc.sendKeys("852");


        WebElement btnContinue = driver.findElement(By.xpath("//*[@id=\"short-summary\"]/div[1]/div[2]/button[1]"));
        btnContinue.click();

        WebElement btnOrderConfirmation = driver.findElement(By.xpath("//*[@id=\"frm-save-order\"]/button/span"));
        btnOrderConfirmation.click();


    }

    public void OrderProduct() {


        WebElement ContinueCheckout = driver.findElement(By.cssSelector(".btn.btn-primary.full"));
        ContinueCheckout.click();

        // Adres bilgisi varsa adresi sec yoksa adres bilgileri gir
        List<WebElement> addressControl = driver.findElements(By.cssSelector(".box-header-desc"));

        String addressNotRegistered = "Lütfen teslimat adres bilgilerinizi ve teslimat seçeneğini belirtin.";
        String addressSaving = "Standart Teslimat dışındaki seçimleriniz için kargo ücreti yeniden hesaplanır.";

         if (addressSaving.equals(addressControl.get(0).getText())) // Adres bilgisi kayıtlı değilse adres ekleme
         {
             AddAddress("fatmanur", "bulacak");
         }
        else if (addressNotRegistered.equals(addressControl.get(0).getText()))// Adres bilgisi kayıtlıysa seçerek devam etme
         {
            List<WebElement> addressSelect = driver.findElements(By.cssSelector(".selectbox-choice"));
            addressSelect.get(0).click();
            driver.findElement(By.cssSelector(".invoice-with-order")).click();
         }

        driver.findElement(By.cssSelector(".proceed-container")).click();

       AddPaymentInformation();


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

}
