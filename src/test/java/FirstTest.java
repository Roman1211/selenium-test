import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class FirstTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void start() throws MalformedURLException {
        driver = new RemoteWebDriver(new URL("http://192.168.1.67:4444/wd/hub"), new FirefoxOptions());
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void firstTest() {
        driver.get("https://software-testing.ru/");
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

