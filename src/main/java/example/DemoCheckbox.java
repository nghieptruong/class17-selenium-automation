package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DemoCheckbox {
    public static void main(String[] args) throws InterruptedException {
        //        //Start chrome browser
        ChromeOptions options = new ChromeOptions();
//        options.setBrowserVersion("149");
        //Tat hien thi automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        ChromeDriver chromeDriver = new ChromeDriver(options);
        // Mo full man hinh
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.letskodeit.com/practice");

        By byChkBmw = By.id("bmwcheck");
//        WebElement chkBmw = chromeDriver.findElement(byChkBmw);
//        //Set checkbox on
//        chkBmw.click();
//
//        String status = chkBmw.getAttribute("checked");
//        System.out.println(status);

        //Set bmw checkbox On
        setCheckbox(chromeDriver, byChkBmw, true);

        Thread.sleep(3000);
        //Set bmw checkbox On
        setCheckbox(chromeDriver, byChkBmw, false);

        Thread.sleep(3000);
        setCheckbox(chromeDriver, byChkBmw, false);

        Thread.sleep(3000);

        chromeDriver.quit();
    }
    public static void setCheckbox(WebDriver driver, By locator, boolean status ){
        WebElement checkbox = driver.findElement(locator);
        if (status != checkbox.isSelected()) {
            checkbox.click();
        }
    }
}
