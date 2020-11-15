import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.File;
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
        driver.findElement(By.xpath(".//span[contains (.,'Appearence')]/..")).click(); //Appearence
        driver.findElement(By.xpath(".//h1[text() = ' Template']"));
        driver.findElement(By.xpath(".//li[@id ='doc-logotype']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Logotype']"));

        driver.findElement(By.xpath(".//span[contains (.,'Catalog')]/..")).click(); //Catalog
        driver.findElement(By.xpath(".//h1[text() = ' Catalog']"));
        driver.findElement(By.xpath(".//li[@id ='doc-product_groups']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Product Groups']"));
        driver.findElement(By.xpath(".//li[@id ='doc-option_groups']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Option Groups']"));
        driver.findElement(By.xpath(".//li[@id ='doc-manufacturers']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Manufacturers']"));
        driver.findElement(By.xpath(".//li[@id ='doc-suppliers']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Suppliers']"));
        driver.findElement(By.xpath(".//li[@id ='doc-delivery_statuses']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Delivery Statuses']"));
        driver.findElement(By.xpath(".//li[@id ='doc-sold_out_statuses']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Sold Out Statuses']"));
        driver.findElement(By.xpath(".//li[@id ='doc-quantity_units']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Quantity Units']"));
        driver.findElement(By.xpath(".//li[@id ='doc-csv']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' CSV Import/Export']"));

        driver.findElement(By.xpath(".//span[contains (.,'Countries')]/..")).click(); //Countries
        driver.findElement(By.xpath(".//h1[text() = ' Countries']"));

        driver.findElement(By.xpath(".//span[contains (.,'Currencies')]/..")).click(); //Currencies
        driver.findElement(By.xpath(".//h1[text() = ' Currencies']"));

        driver.findElement(By.xpath(".//span[contains (.,'Customers')]/..")).click(); //Customers
        driver.findElement(By.xpath(".//h1[text() = ' Customers']"));
        driver.findElement(By.xpath(".//li[@id ='doc-csv']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' CSV Import/Export']"));
        driver.findElement(By.xpath(".//li[@id ='doc-newsletter']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Newsletter']"));

        driver.findElement(By.xpath(".//span[contains (.,'Geo Zones')]/..")).click();  //Geo Zones
        driver.findElement(By.xpath(".//h1[text() = ' Geo Zones']"));

        driver.findElement(By.xpath(".//span[contains (.,'Languages')]/..")).click();  //Languages
        driver.findElement(By.xpath(".//h1[text() = ' Languages']"));
        driver.findElement(By.xpath(".//li[@id ='doc-storage_encoding']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Storage Encoding']"));

        driver.findElement(By.xpath(".//span[contains (.,'Modules')]/..")).click(); //Modules
        driver.findElement(By.xpath(".//h1[text() = ' Job Modules']"));
        driver.findElement(By.xpath(".//li[@id ='doc-customer']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Customer Modules']"));
        driver.findElement(By.xpath(".//li[@id ='doc-shipping']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Shipping Modules']"));
        driver.findElement(By.xpath(".//li[@id ='doc-payment']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Payment Modules']"));
        driver.findElement(By.xpath(".//li[@id ='doc-order_total']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Order Total Modules']"));
        driver.findElement(By.xpath(".//li[@id ='doc-order_success']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Order Success Modules']"));
        driver.findElement(By.xpath(".//li[@id ='doc-order_action']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Order Action Modules']"));

        driver.findElement(By.xpath(".//span[contains (.,'Orders')]/..")).click(); //Orders
        driver.findElement(By.xpath(".//h1[text() = ' Orders']"));
        driver.findElement(By.xpath(".//li[@id ='doc-order_statuses']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Order Statuses']"));

        driver.findElement(By.xpath(".//span[contains (.,'Pages')]/..")).click(); //Pages
        driver.findElement(By.xpath(".//h1[text() = ' Pages']"));

        driver.findElement(By.xpath(".//span[contains (.,'Reports')]/..")).click(); //Reports
        driver.findElement(By.xpath(".//h1[text() = ' Monthly Sales']"));
        driver.findElement(By.xpath(".//li[@id ='doc-most_sold_products']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Most Sold Products']"));
        driver.findElement(By.xpath(".//li[@id ='doc-most_shopping_customers']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Most Shopping Customers']"));

        driver.findElement(By.xpath(".//span[contains (.,'Settings')]/..")).click(); //Settings
        driver.findElement(By.xpath(".//h1[text() = ' Settings']"));
        driver.findElement(By.xpath(".//li[@id ='doc-defaults']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Settings']"));
        driver.findElement(By.xpath(".//li[@id ='doc-general']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Settings']"));
        driver.findElement(By.xpath(".//li[@id ='doc-listings']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Settings']"));
        driver.findElement(By.xpath(".//li[@id ='doc-images']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Settings']"));
        driver.findElement(By.xpath(".//li[@id ='doc-checkout']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Settings']"));
        driver.findElement(By.xpath(".//li[@id ='doc-advanced']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Settings']"));
        driver.findElement(By.xpath(".//li[@id ='doc-security']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Settings']"));

        driver.findElement(By.xpath(".//span[contains (.,'Slides')]/..")).click(); //Slides
        driver.findElement(By.xpath(".//h1[text() = ' Slides']"));

        driver.findElement(By.xpath(".//span[contains (.,'Tax')]/..")).click(); //Tax
        driver.findElement(By.xpath(".//h1[text() = ' Tax Classes']"));
        driver.findElement(By.xpath(".//li[@id ='doc-tax_rates']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Tax Rates']"));

        driver.findElement(By.xpath(".//span[contains (.,'Translations')]/..")).click(); //Translations
        driver.findElement(By.xpath(".//h1[text() = ' Search Translations']"));
        driver.findElement(By.xpath(".//li[@id ='doc-scan']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' Scan Files For Translations']"));
        driver.findElement(By.xpath(".//li[@id ='doc-csv']/a")).click();
        driver.findElement(By.xpath(".//h1[text() = ' CSV Import/Export']"));

        driver.findElement(By.xpath(".//span[contains (.,'Users')]/..")).click(); //Users
        driver.findElement(By.xpath(".//h1[text() = ' Users']"));

        driver.findElement(By.xpath(".//span[contains (.,'vQmods')]/..")).click(); //vQmods
        driver.findElement(By.xpath(".//h1[text() = ' vQmods']"));
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

