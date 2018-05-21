package com.fatmanur.test;

        import org.junit.After;
        import org.junit.AfterClass;
        import org.junit.Before;
        import org.junit.BeforeClass;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.chrome.ChromeDriver;
        import org.openqa.selenium.remote.DesiredCapabilities;

        import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    WebDriver driver;

    @Before
    public void beforeCreateDriver(){ //Driver'i burada calistirdik her method icin tekrar calistirmak gerekmeyecek

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        System.setProperty("webdriver.chrome.driver",
                "D:\\testeğitimi\\TestDenemeleri\\driver\\chromedriver.exe"); // chromedriver.exe nin yolunu

        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(60,TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(60,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


    }

    @After
    public void afterQuitWebDriver(){

        //driver.quit();
    }




}
