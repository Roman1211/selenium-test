import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;

public class FifthTest {
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
    public void fourthTest() {
        driver.get("http://localhost/litecart/admin/");
        WebElement log = driver.findElement(By.name("username"));
        log.sendKeys("admin");
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        List<WebElement> rows = driver.findElements(By.xpath(".//tr[@class = 'row']/td[5]/a")); // Получение списка элементов
        int r = rows.size();                                               // Получение количества элементов
        String countr[] = new String[r];
        int j = 0;
        boolean countrIsSorted = true;
        boolean gzIsSorted = true;
        List <Integer> cntr = new ArrayList<Integer>();
        for (WebElement  i: rows) {
            countr[j] = i.getText();
            if (j>0) {                                                    // Исключение первого элемента
                int comp = countr[j].compareTo(countr[j - 1]);            //Определение находится ли предыдуший элемент в алфавитном порядке по отношению к теущему
                if (comp < 0) countrIsSorted = false;
                assertEquals(true, countrIsSorted);

            }
            int k = j+2;                                                 // Коррекция Локатора(0-го элемента не существует, а 1й элемент по данному локатору - это вся страница)
            WebElement geoz = driver.findElement(By.xpath(".//tr[" + k + "]/td[6]")); // получения списка количества геозон у стран
            int geoz_cnt = Integer.parseInt(geoz.getText());
            if (geoz_cnt > 0) {                                                    // запись в список порядковых номеров стран с кол-вом геозон отличных от 0
                cntr.add(k);
            }
            j++;
        }
        for (Integer l: cntr) {
            driver.findElement(By.xpath(".//tr[" + l + "]/td[5]/a")).click();
            List<WebElement> zones = driver.findElements(By.xpath(".//table[@class = 'dataTable']/tbody/tr/td[3]"));  //Получение списка геозон
            int h = 0;
            int f = zones.size();
            String tzones[] = new String[f];
            for (WebElement i : zones) {
                tzones[h] = i.getText();
                if (h>0) {
                    int fm = tzones[h].length();
                    if (fm == 0) break;
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

