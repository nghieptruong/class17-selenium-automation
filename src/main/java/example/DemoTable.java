package example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class DemoTable {
    public static void main(String[] args) {
        //        //Start chrome browser
        ChromeOptions options = new ChromeOptions();
//        options.setBrowserVersion("149");
        //Tat hien thi automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        ChromeDriver chromeDriver = new ChromeDriver(options);

        chromeDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Mo full man hinh
        chromeDriver.manage().window().maximize();
        chromeDriver.get("https://www.letskodeit.com/practice");

//        By byRow = By.xpath("//table[@id='product']/tbody/tr[2]/td[2]");
//        WebElement rowElement = chromeDriver.findElement(byRow);
//        System.out.println(rowElement.getText());

//        String s = "//table[@id='product']/tbody/tr[%s]/td[%s]";
//        String newStr = String.format(s, "1", "2");

//        String s = "//table[@id='product']/tbody/tr[%d]/td[%d]";
//        String newStr = String.format(s, 1, 2);
//        System.out.println(newStr);

//        //        Table Exercise
//        System.out.println("\n// =========================\n" +
//                "// Table Exercise\n" +
//                "// =========================");
//        By byTable = By.xpath("//table[@id='product']");
//        WebElement eleTable = chromeDriver.findElement(byTable);

//         String cellVale = getTableCellValue(chromeDriver, "//table[@id='product']", 1, 2);
//        System.out.println(cellVale);
//
//        // Get Table Cells
//        System.out.println("Table Cells:");
//        getTableCellValue(eleTable);


//        // Get Table Headers
//        System.out.println("\nTable Headers:");
//        getHeaderValue(eleTable);

//        // is Row Value Exist
//        System.out.println("\nIs Row Value Exist:");
//        System.out.println("Value exists: "
//                + isRowValueExist(eleTable,
//                "Python Programming Language"));
//
//        System.out.println("Value exists: "
//                + isRowValueExist(eleTable,
//                "ABCXYZ"));

        System.out.println(isRowValueExist(chromeDriver, "Python Programming Language")); // true
//        List<WebElement> list = chromeDriver.findElements(By.xpath(String.format("//table[@id='product']//tr[contains(., '%s')]", "Python Programming Language")));
//        System.out.println(list.isEmpty());

        chromeDriver.quit();
    }

    /**
     * Get Table Cell Value
     * Lay gia tri cua cell tai row index va column index
     * getTableCellValue(locator, 1, 2) ==> lay gia tri cell tai hang 1 cot 2
     * @param locatorTable
     * @param row
     * @param col
     * @return
     */
    public static String getTableCellValue(WebDriver driver, String locatorTable, int row, int col) {
        String template = locatorTable + "//tr[%d]/*[%d]";
        String cellXpath = String.format(template, row, col);
        By byCellLocator = By.xpath(cellXpath);
        WebElement cellElement = driver.findElement(byCellLocator);
        return cellElement.getText();
    }

    public static void getTableCellValue(WebElement eleTable) {
        for (int row = 2; row <= 4; row++) {
            for (int col = 1; col <= 3; col++) {
                By byTableCell = By.xpath("//tr[" + row + "]//td[" + col + "]");
                WebElement eleTableCell = eleTable.findElement(byTableCell);
                System.out.println("Row " + row + " - Col " + col + ": "
                        + eleTableCell.getText().trim());
            }
        }
    }

    /**
     * Get Header Value
     * getHeaderValue(locator, 1) ==> lay header name : Author
     * @param locatorTable
     * @param col
     * @return
     */
    public static String getHeaderValue(By locatorTable, int col) {
        return "";
    }

    public static void getHeaderValue(WebElement eleTable) {
        for (int i = 1; i <= 3; i++) {
            By byTableCell = By.xpath("//tr[1]/th[" + i + "]");
            WebElement eleTableCell = eleTable.findElement(byTableCell);
            System.out.println("Header " + i + ": "
                    + eleTableCell.getText().trim());
        }
    }

    /**
     * Is Row Value Exist: Match exact (chính xác)
     * isRowValueExist("Python Programming Language") ==> true
     * isRowValueExist("ABCXYZ") ==> false
     * @param value
     * @return
     */
    public static boolean isRowValueExist(String value) {
        //TO-DO
        return true;
    }

    public static boolean isRowValueExist(WebElement eleTable, String value) {
        By byTableRow = By.xpath("//tr[position()>1]/td");
        List<WebElement> tableCells =
                eleTable.findElements(byTableRow);


        for (WebElement cell : tableCells) {
            if (cell.getText().equals(value)) return true;
        }
        return false;
    }

    public static boolean isRowValueExist(ChromeDriver driver, String value){
        boolean notExist = driver.findElements(By.xpath(String.format("//table[@id='product']//tr[contains(., '%s')]", value))).isEmpty();
//        if(notExist == true) {
//            return false;
//        } else {
//            return true;
//        }
        return !notExist;
    }
}
