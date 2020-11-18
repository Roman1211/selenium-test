import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.util.List;

public class FourthTest {
    private WebDriver driver;
    private WebDriverWait wait;
    public boolean compare() {

        return false;
    }

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
    public void fifthTest() {
        driver.get("http://localhost/litecart/admin/");
        WebElement log = driver.findElement(By.name("username"));
        log.sendKeys("admin");
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        List<WebElement> rows = driver.findElements(By.xpath(".//tr[@class = 'row']/td[3]/a")); // Получение списка элементов
        int j = rows.size();
        boolean gzIsSorted = true;
        for (int i = 0; i<j ; i++) {
            int kr = i+2;
            driver.findElement(By.xpath(".//tr[" + kr + "]/td[3]/a")).click();
            List<WebElement> zones = driver.findElements(By.xpath(".//td/select[contains(@name , 'zone_code')]/option[@selected = 'selected']"));  //Получение списка геозон
            int h = 0;
            int f = zones.size();
            String tzones[] = new String[f];
            for (WebElement k : zones) {
                tzones[h] = k.getText();
                if (h>0) {
                    int comp = tzones[h].compareTo(tzones[h - 1]);                                                    //Определение находится ли предыдуший элемент в алфавитном порядке по отношению к теущему
                    if (comp < 0) gzIsSorted = false;
                    assertEquals(gzIsSorted, true);
                }
                h++;
            }
            driver.navigate().back();
        }
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

