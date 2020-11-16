import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.util.List;

public class ThirdTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        FirefoxOptions options = new FirefoxOptions().setBinary(new FirefoxBinary(new File("c:\\Program Files\\Firefox Nightly\\firefox.exe")));
        driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void thirdTest() {
        driver.get("http://localhost/litecart");
        List<WebElement> items = driver.findElements(By.xpath(".//div[@id = 'box-most-popular']/div/ul/li/a[1]"));
        for (WebElement i : items) {
            List<WebElement> labels = i.findElements(By.xpath(".//div[contains (@class, 'sticker')]"));
            assertEquals(1, labels.size());
        }
        List<WebElement> items2 = driver.findElements(By.xpath(".//div[@id = 'box-campaigns']/div/ul/li/a[1]"));
        for (WebElement i : items2) {
            List<WebElement> labels = i.findElements(By.xpath(".//div[contains (@class, 'sticker')]"));
            assertEquals(1, labels.size());
        }
        List<WebElement> items3 = driver.findElements(By.xpath(".//div[@id = 'box-latest-products']/div/ul/li/a[1]"));
        for (WebElement i : items3) {
            List<WebElement> labels = i.findElements(By.xpath(".//div[contains (@class, 'sticker')]"));
            assertEquals(1, labels.size());
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

