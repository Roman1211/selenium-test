import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class EighthTest {
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
        Calendar today = new GregorianCalendar();
        Calendar expday = new GregorianCalendar();
        expday.add(Calendar.MONTH,1);
        SimpleDateFormat formatDate = new SimpleDateFormat("dd.MM.yyyy");
        String fromdate = formatDate.format(today.getTime());
        String todate = formatDate.format(expday.getTime());
        driver.get("http://localhost/litecart/admin/");
        WebElement log = driver.findElement(By.name("username"));
        log.sendKeys("admin");
        WebElement pass = driver.findElement(By.name("password"));
        pass.sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.xpath(".//span[contains(.,'Catalog')]/..")).click();
        driver.findElement(By.xpath(".//a[contains(., ' Add New Product')]")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath(".//label[contains(., 'Enabled')]")).click();
        driver.findElement(By.xpath(".//input[@name= 'name[en]']")).sendKeys("Ghost Duck");
        driver.findElement(By.xpath(".//input[@name= 'code']")).sendKeys("09956");
        driver.findElement(By.xpath(".//input[@data-name= 'Rubber Ducks']")).click();
        driver.findElement(By.xpath(".//input[@value =  '1-3']")).click();
        WebElement quantity = driver.findElement(By.xpath(".//input[@name =  'quantity']"));
        quantity.clear();
        quantity.sendKeys("99");
        File b = new File("./src/main/resources/duck.jpg");
        String absolute;
        absolute = b.getCanonicalPath();
        driver.findElement(By.xpath(".//input[@name =  'new_images[]']")).sendKeys(absolute);
        driver.findElement(By.xpath(".//input[@name =  'date_valid_from']")).sendKeys(fromdate);
        driver.findElement(By.xpath(".//input[@name =  'date_valid_to']")).sendKeys(todate);
        driver.findElement(By.xpath(".//a[contains(.,'Information')]")).click();
        Thread.sleep(500);
        WebElement manufacter = driver.findElement(By.xpath(".//select[@name = 'manufacturer_id']"));
        Select manufac = new Select(manufacter);
        manufac.selectByValue("1");
        driver.findElement(By.xpath(".//input[@name = 'keywords']")).sendKeys("description");
        driver.findElement(By.xpath(".//input[@name = 'short_description[en]']")).sendKeys("Short description");
        driver.findElement(By.xpath(".//div[@class = 'trumbowyg-editor']")).sendKeys("detailed description");
        driver.findElement(By.xpath(".//input[@name = 'head_title[en]']")).sendKeys("Ghost Duck");
        driver.findElement(By.xpath(".//input[@name = 'meta_description[en]']")).sendKeys("Duck");
        driver.findElement(By.xpath(".//a[contains(.,'Prices')]")).click();
        Thread.sleep(500);
        WebElement price = driver.findElement(By.xpath(".//input[@name = 'purchase_price']"));
        price.clear();
        price.sendKeys("99,99");
        WebElement valute = driver.findElement(By.xpath(".//select[@name =  'purchase_price_currency_code']"));
        Select valutes = new Select(valute);
        valutes.selectByValue("USD");
        WebElement priceUSD = driver.findElement(By.xpath(".//input[@name =  'prices[USD]']"));
        priceUSD.clear();
        priceUSD.sendKeys("99,99");
        WebElement eurTax = driver.findElement(By.xpath(".//input[@name = 'gross_prices[EUR]']"));
        eurTax.clear();
        eurTax.sendKeys("80,99");
        driver.findElement(By.xpath(".//button[@name = 'save']")).click();
        driver.findElement(By.xpath(".//span[contains(.,'Catalog')]/..")).click();
        driver.findElement(By.xpath(".//a[contains(.,'Rubber Ducks')]")).click();
        driver.findElement(By.xpath(".//a[contains(.,'Ghost Duck')]")).click();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

