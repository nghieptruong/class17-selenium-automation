package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalUnit;

public class DemoImplicitWait {
    public static void main(String[] args) {
        //        //Start chrome browser
        ChromeOptions options = new ChromeOptions();
//        options.setBrowserVersion("149");
        //Tat hien thi automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        ChromeDriver chromeDriver = new ChromeDriver(options);

        //Khai bao implicit wait (ngam dinh doi trong 10s)
        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Mo full man hinh
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.letskodeit.com/practice");

        ZonedDateTime startTime = null;
        try {
            By byChkBmw = By.id("bmwcheck");

            startTime = ZonedDateTime.now();
            WebElement chkBmw = chromeDriver.findElement(byChkBmw); // ko đợi
            chkBmw.click();
        } catch (Exception e) {
            throw e;
        } finally {
            ZonedDateTime endTime = ZonedDateTime.now();
            long duration = ChronoUnit.SECONDS.between(startTime, endTime);
            System.out.println("Duration: " + duration);

            chromeDriver.quit();
        }
    }
}
