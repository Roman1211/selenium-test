import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.Random;

public class seventhTest {
    private WebDriver driver;
    private WebDriverWait wait;
    Random r = new Random();
    int randNum = r.nextInt(99999);




    @Before
    public void start() {
        //driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        //driver = new InternetExplorerDriver();
        FirefoxOptions options = new FirefoxOptions().setBinary(new FirefoxBinary(new File("c:\\Program Files\\Firefox Nightly\\firefox.exe")));
        driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void fourthTest() {
        String passwrd = "Qwerty1234";
        String firstName = "Roman";
        String lastName = "Test";
        String address = "Omskaya 1";
        String city = "Anchorage";
        String postCode = "99501";
        String email = "sltest" + randNum +"@mail.ru";  // уникальнй email
        String phone = "+19991112233";
        driver.get("http://localhost/litecart");
        driver.findElement(By.xpath(".//td/a")).click();
        driver.findElement(By.xpath(".//input[@name = 'firstname']")).sendKeys(firstName);
        driver.findElement(By.xpath(".//input[@name = 'lastname']")).sendKeys(lastName);
        driver.findElement(By.xpath(".//input[@name = 'address1']")).sendKeys(address);
        driver.findElement(By.xpath(".//input[@name = 'postcode']")).sendKeys(postCode);
        driver.findElement(By.xpath(".//input[@name = 'city']")).sendKeys(city);
        driver.findElement(By.xpath(".//span[@class= 'select2-selection__rendered']")).click();
        driver.findElement(By.xpath(".//ul[@class='select2-results__options']/li[contains(.,'United States')]")).click();
        driver.findElement(By.xpath(".//select[@name = 'zone_code']")).click();
        driver.findElement(By.xpath(".//select[@name = 'zone_code']/option[@value = 'AK']")).click();
        driver.findElement(By.xpath(".//input[@name = 'phone']")).sendKeys(phone);
        driver.findElement(By.xpath(".//input[@name = 'email']")).sendKeys(email);
        driver.findElement(By.xpath(".//input[@name = 'password']")).sendKeys(passwrd);
        driver.findElement(By.xpath(".//input[@name = 'confirmed_password']")).sendKeys(passwrd);
        driver.findElement(By.xpath(".//button[@name = 'create_account']")).click();
        driver.findElement(By.xpath(".//div[@id = 'box-account']/div/ul/li/a[contains (.,'Logout')]")).click();
        driver.findElement(By.xpath(".//input[@name = 'email']")).sendKeys(email);
        driver.findElement(By.xpath(".//input[@name = 'password']")).sendKeys(passwrd);
        driver.findElement(By.xpath(".//button[@name = 'login']")).click();
        driver.findElement(By.xpath(".//div[@id = 'box-account']/div/ul/li/a[contains (.,'Logout')]")).click();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

