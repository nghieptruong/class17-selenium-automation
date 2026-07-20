package example;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FirstScript {
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
        chromeDriver.get("https://demo1.cybersoft.edu.vn/");

        Thread.sleep(3000);

        //Quit driver: close browser & kill process chromedriver
        chromeDriver.quit();

//        //Start firefox browser
//        FirefoxDriver firefoxDriver = new FirefoxDriver();
//        firefoxDriver.get("https://demo1.cybersoft.edu.vn/");
//        //Quit driver: close browser & kill process geckodriver
//        firefoxDriver.quit();

//        SafariDriver safariDriver = new SafariDriver();
//        safariDriver.get("https://demo1.cybersoft.edu.vn/");
//        Thread.sleep(3000);
//        safariDriver.quit();


        Path filePath = Path.of("/Users/nghieptruong/Data/TrainingMac/AutomationTraining/class19/class19-selenium-automation/src/main/java/example/example.txt"); // Or Paths.get("example.txt")

        try {
            // Reads the file using UTF-8 character encoding by default
            String content = Files.readString(filePath);
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
