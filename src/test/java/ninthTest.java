import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;

public class ninthTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private boolean elementIsPresent(String xpath) {          //метод для определения присутсвия элемента на странице
        try {
            driver.findElement(By.xpath(xpath));
        } catch (NoSuchElementException e) {
            return false;
        }
        return true;
    }



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
        driver.get("http://localhost/litecart");
        for (int i = 0; i < 3; i++) {
            driver.findElement(By.xpath(".//div[@id = 'box-most-popular']/div/ul/li")).click();
            WebElement cart = driver.findElement(By.xpath(".//span[@class = 'quantity']"));
            int oldQuantity = Integer.parseInt(cart.getText());
            if (elementIsPresent(".//select[@name = 'options[Size]']")) {           // определение есть ли на странице селектор размера товара(для желтой утки)
                WebElement sel = driver.findElement(By.xpath(".//select[@name = 'options[Size]']"));
                Select size = new Select(sel);
                size.selectByValue("Small");
            }
            driver.findElement(By.xpath(".//button[@name = 'add_cart_product']")).click();
            wait.until((WebDriver driver) -> Integer.parseInt(cart.getText()) - oldQuantity == 1);             // ожидание обновления корзины
            driver.navigate().back();
        }
        driver.findElement(By.xpath(".//a[contains(.,'Checkout')]")).click();
        List <WebElement> goods  = driver.findElements(By.xpath(".//td[@class= 'item']"));
        int j = goods.size();

        for (int i = 0; i < j;  i++) {
            List <WebElement> table  = driver.findElements(By.xpath(".//td[@class= 'item']"));
            int items = table.size();
            driver.findElement(By.xpath(".//button[@name = 'remove_cart_item']")).click();
            List <WebElement> after = wait.until(numberOfElementsToBe((By.xpath(".//td[@class= 'item']")), items-1)); //ожидание обновления таблицы
        }

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

