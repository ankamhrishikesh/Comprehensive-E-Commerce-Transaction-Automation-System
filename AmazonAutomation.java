import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Scanner;

public class AmazonAutomation {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ankam\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");


        ChromeOptions options = new ChromeOptions();

        WebDriver driver = new ChromeDriver(options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.amazon.in/");

        System.out.println("Please manually search for 'mobile' and press Enter after selecting options.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        WebElement fourStarFilter = driver.findElement(By.xpath("//span[@aria-label='4 Stars & Up']/preceding-sibling::i"));
        fourStarFilter.click();

        WebElement minPrice = driver.findElement(By.id("low-price"));
        minPrice.sendKeys("10000");

        WebElement maxPrice = driver.findElement(By.id("high-price"));
        maxPrice.sendKeys("20000", Keys.ENTER);


        WebElement firstResult = driver.findElement(By.xpath("//div[@data-index='0']//h2/a"));
        firstResult.click();


        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-button"));
        addToCartButton.click();

        WebElement goToCartButton = driver.findElement(By.id("hlb-view-cart-announce"));
        goToCartButton.click();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser
        driver.quit();
    }
}
