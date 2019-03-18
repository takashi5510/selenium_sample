package selenium_sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumSample {

  public static void main(String[] args) throws InterruptedException {

    System.setProperty("webdriver.chrome.driver", "/tmp/chromedriver");

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless", "--disable-gpu");

    WebDriver driver = new ChromeDriver(options);

    driver.get("https://www.google.com");
    System.out.println("Page title is: " + driver.getTitle());

    Thread.sleep(1000);

    WebElement searchElement = driver.findElement(By.name("q"));
    searchElement.sendKeys("Cheese!");

    Thread.sleep(1000);

    searchElement.submit();

    new WebDriverWait(driver, 10).until((ExpectedCondition<Boolean>) webDriver -> webDriver.getTitle().toLowerCase().startsWith("cheese!"));

    System.out.println("Page title is: " + driver.getTitle());

    Thread.sleep(1000);

    driver.quit();

  }

}

