package example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoExplicitWait {
    public static void main(String[] args) {
        //        //Start chrome browser
        ChromeOptions options = new ChromeOptions();
//        options.setBrowserVersion("149");
        //Tat hien thi automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        ChromeDriver chromeDriver = new ChromeDriver(options);

        //Khai bao explit wait (wait tuong minh 1 thuoc tinh nao do)
//        WebDriverWait wait = new WebDriverWait(chromeDriver, Duration.ofSeconds(10));
        FluentWait<WebDriver> wait = new FluentWait<>(chromeDriver);
        wait.withTimeout(Duration.ofSeconds(30));
        wait.pollingEvery(Duration.ofSeconds(1));
        wait.ignoring(NotFoundException.class);
        wait.withMessage("Not Found");

        // Mo full man hinh
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        By byBtnStart = By.xpath("//div[@id='start']/button");
        WebElement btnStart = wait.until(ExpectedConditions.elementToBeClickable(byBtnStart));
        btnStart.click();

        By byLblResult = By.xpath("//div[@id='finish']/h4");
        WebElement lblResult = wait.until(ExpectedConditions.visibilityOfElementLocated(byLblResult));
        System.out.println(lblResult.isDisplayed()); // kiem cho result Hello world co display hay khong ?

        chromeDriver.quit();
    }
}
