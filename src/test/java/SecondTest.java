import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

public class SecondTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() {
        //driver = new FirefoxDriver();
        // = new ChromeDriver();
        //driver = new InternetExplorerDriver();
        FirefoxOptions options = new FirefoxOptions().setBinary(new FirefoxBinary(new File("c:\\Program Files\\Firefox Nightly\\firefox.exe")));
        driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void secondTest() {
        driver.get("http://localhost/litecart/admin/");
        WebElement log = driver.findElement(By.name("username"));
        log.sendKeys("admin");
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> items = driver.findElements(By.xpath(".//ul[@id = 'box-apps-menu']/li/a")); //Список всех пунктов
        int s = items.size();
        for (int i = 1; i <= s ; i++) {                                                          //Проходит по каждому пункту меню
            driver.findElement(By.xpath(".//ul[@id = 'box-apps-menu']/li["+i+"]/a")).click();
            driver.findElement(By.xpath(".//h1"));
            List<WebElement> subitems = driver.findElements(By.xpath(".//ul[@id = 'box-apps-menu']/li/ul/li")); //Список подпунктов
            int sub = subitems.size();
            if (sub > 0 ) {                                                                                     // Провека на наличие подпунктов
                for (int j = 1; j <= sub ; j++) {                                                               // Проходит по каждому подпункту
                    driver.findElement(By.xpath(".//ul[@id = 'box-apps-menu']/li/ul/li[" + j + "]/a")).click();
                    driver.findElement(By.xpath(".//h1"));
                }
            }
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

