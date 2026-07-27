package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class DemoSelectbox {
    public static void main(String[] args) {
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

        By bySelectCar = By.id("carselect");
        WebElement elementSelectCar = chromeDriver.findElement(bySelectCar);
        Select selCar = new Select(elementSelectCar);

        //1. Select option bang value
        selCar.selectByValue("benz");
        System.out.println(selCar.getFirstSelectedOption().getText());

        System.out.println("---------------");
        //2. Select option bang index
        selCar.selectByIndex(0);
        System.out.println(selCar.getFirstSelectedOption().getText());

        System.out.println("---------------");
        //3. Select option by text
        selCar.selectByVisibleText("Honda");
        System.out.println(elementSelectCar.getAttribute("value"));

        chromeDriver.quit();
    }
}
