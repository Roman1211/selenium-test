import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.util.List;

public class TehthTest {
    private WebDriver driver;
    private WebDriverWait wait;



    @Before
    public void start() {
        //driver = new FirefoxDriver();
        driver = new ChromeDriver();
        //driver = new InternetExplorerDriver();
        //FirefoxOptions options = new FirefoxOptions().setBinary(new FirefoxBinary(new File("c:\\Program Files\\Firefox Nightly\\firefox.exe")));
        //driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void fifthTest() throws IOException, InterruptedException {
        driver.get("http://localhost/litecart/admin/");
        WebElement log = driver.findElement(By.name("username"));
        log.sendKeys("admin");
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath(".//span[contains(.,'Countries')]/..")).click();
        Thread.sleep(600);
        driver.findElement(By.xpath(".//a[contains(.,' Add New Country')]")).click();
        List<WebElement> links = driver.findElements(By.xpath(".//i[@class = 'fa fa-external-link']/..")); //Получение списка ссылок
        for (WebElement i: links) {
            String currWind = driver.getWindowHandle();                                 // заголовок текушего окна
            String[] oldWindList = driver.getWindowHandles().toArray(new String[0]);    // список окон до перехода по ссылке
            i.click();
            wait.until((WebDriver driver) -> driver.getWindowHandles().toArray(new String[0]).length > oldWindList.length); // ожидание открытия окна
            String[] newWindList = driver.getWindowHandles().toArray(new String[0]);    // список окон после перехода по ссылке

            for (int j = 0; j < newWindList.length; j++) {
                if (currWind.equals(newWindList[j]) == false) {
                    driver.switchTo().window(newWindList[j]);                             // переключение в новое окно
                    driver.close();
                    driver.switchTo().window(currWind);                                   // переключение в предыдушее окно
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

