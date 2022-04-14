package Zadanie;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class TestZadanie2 {

    public static void main(String[] args) throws IOException {


        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication&back=addresses");

        WebElement loginEmail =
                driver.findElement(By.name("email"));
        loginEmail.sendKeys("testtest123@gmail.com");

        WebElement loginPassword =
                driver.findElement(By.name("password"));
        loginPassword.sendKeys("qwerty");


        driver.findElement(By.id("submit-login")).click();

        driver.get("https://mystore-testlab.coderslab.pl/index.php");

//        WebElement searchBar =
//                driver.findElement(By.id("index"));
//        searchBar.sendKeys("Hummingbird Printed Sweater");

        driver.findElement(By.xpath("//*[@id=\"content\"]/section/div/article[2]/div/div[1]/h3/a")).click();


        driver.findElement(By.xpath("//*[@id=\"group_1\"]/option[2]")).click();

        WebElement quantityButton =
                driver.findElement(By.name("qty"));
        quantityButton.clear();
        quantityButton.sendKeys("5");

        driver.findElement(By.xpath("//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")).click();
//
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")).click();

        driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")).click();

        driver.findElement(By.name("confirm-addresses")).click();

        driver.findElement(By.name("confirmDeliveryOption")).click();

        driver.findElement(By.name("payment-option")).click();

        driver.findElement(By.name("conditions_to_approve[terms-and-conditions]")).click();

        driver.findElement(By.xpath("//*[@id=\"payment-confirmation\"]/div[1]/button")).click();

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("C:\\projectScreenshots\\homePageScreenshot.png"));


    }


}


