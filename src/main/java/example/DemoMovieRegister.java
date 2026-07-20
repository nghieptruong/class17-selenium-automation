package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DemoMovieRegister {
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
        // Mo trang https://demo1.cybersoft.edu.vn/
        chromeDriver.get("https://demo1.cybersoft.edu.vn/sign-up");

        //Step 1: Enter account
        //By va WebElement --> tuong ung locator tren trang web html
        //Tim element Tai khoan textbox
        By byTxtAccount = By.id("taiKhoan");
        WebElement txtAccount = chromeDriver.findElement(byTxtAccount);
        //Go text vao Tai khoan textbox
        txtAccount.sendKeys("JohnJohn01");

        //Step 2: Enter password
        By byTxtPassword = By.name("matKhau");
        WebElement txtPassword = chromeDriver.findElement(byTxtPassword);
        txtPassword.sendKeys("123456");

        //Step 3: Re-enter password
        By byTxtConfirmPassword = By.xpath("//input[@id='confirmPassWord']");
        WebElement txtConfirmPassword = chromeDriver.findElement(byTxtConfirmPassword);
        txtConfirmPassword.sendKeys("123456");

        Thread.sleep(3000);

        //Quit driver: close browser & kill process chromedriver
        chromeDriver.quit();
    }
}
