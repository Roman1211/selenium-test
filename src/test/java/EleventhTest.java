import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class EleventhTest {
    public static ThreadLocal<EventFiringWebDriver> t1Driver = new ThreadLocal<>();
    private EventFiringWebDriver driver;
    private WebDriverWait wait;


public static class Mylistener extends AbstractWebDriverEventListener {};

    @Before
    public void start() {
        //driver = new FirefoxDriver();
        driver = new EventFiringWebDriver(new ChromeDriver());
        driver.register(new Mylistener());
        t1Driver.set(driver);
        //driver = new InternetExplorerDriver();
        //FirefoxOptions options = new FirefoxOptions().setBinary(new FirefoxBinary(new File("c:\\Program Files\\Firefox Nightly\\firefox.exe")));
        //driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver,10);

    }


    @Test
    public void fifthTest() throws IOException, InterruptedException {
        //List<LogEntry> logs = driver.manage().logs().get("driver").getAll(); //запись логов в список
        driver.get("http://localhost/litecart/admin/");
        WebElement log = driver.findElement(By.name("username"));
        log.sendKeys("admin");
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("admin");
        driver.findElement(By.name("login")).click();
        Thread.sleep(700);
        driver.findElement(By.xpath(".//span[contains(.,'Catalog')]/..")).click();
        Thread.sleep(700);
        driver.findElement(By.xpath(".//td[3]/a")).click();
        for (int i = 5; i <= 9; i++) {
            Thread.sleep(700);
            driver.findElement(By.xpath(".//tr[" + i + "]/td[3]/a")).click();
            List<LogEntry> logs = driver.manage().logs().get("client").getAll();
            assertEquals(logs.size(), 0);            //проверка отсутствия сообшний в логе
            driver.navigate().back();
        }
        int y = 0;
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

