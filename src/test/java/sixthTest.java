import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class sixthTest {
    private WebDriver driver;
    private WebDriverWait wait;

    public boolean isGrey (String rgbs) {                                                        //Проверка серого цвета
        int[] rgb =getRgb(rgbs);
        if (rgb[0] == (rgb[1] = rgb[2])) return true;
        return false;
    }

    public boolean isRed (String rgbs) {                                                        //проверка красного цвета
        int[] rgb =getRgb(rgbs);
        if (rgb[1] == 0 && rgb[2] == 0) return true;
        return false;
    }

    public boolean isStrikethrough (String tg) {                            // проверка зачеркнутого стиля
        if (tg.equals("s")) return true;
        return false;
    }

    public boolean isBold (String tg) {                                    // проверка жирного стиля
        if (tg.equals("strong")) return true;
        return false;
    }

    public boolean comp_font_size(String reg, String cam) {                 // преобразование размера ценников из строкового формата в числовой и сравнение
        char reg_ch[] = reg.toCharArray();
        String reg_size = "";
        for (int i = 0; i<reg_ch.length;i++) {
            if (Character.isDigit(reg_ch[i]) == true || reg_ch[i] == '.') reg_size = reg_size + reg_ch[i];
        }
        double regSize = Double.parseDouble(reg_size);
        char cam_ch[] = cam.toCharArray();
        String cam_size = "";
        for (int i = 0; i<cam_ch.length;i++) {
            if (Character.isDigit(cam_ch[i]) == true || cam_ch[i] == '.') cam_size = cam_size + cam_ch[i];
        }
        double camSize = Double.parseDouble(cam_size);
        if (camSize > regSize) return true;
        return false;
    }

    public int[] getRgb (String rgb_0) {                       // Преобразование цвета из строкового значение в массив целых чисел
        char rgb_ch[] = rgb_0.toCharArray();
        String[] rgbs = {"", "", ""};
        int[] rgb = new int[3];
        int cn = 0;
        for (int i = 0; i < rgb_ch.length; i++) {
            if (rgb_ch[i] == ',' || (rgb_ch[i] == ')' && cn == 2) ) {
                rgb[cn] = Integer.parseInt(rgbs[cn]);
                cn = cn + 1;
            }
            if (Character.isDigit(rgb_ch[i]) == true) rgbs[cn] = rgbs[cn] + rgb_ch[i];
            if (cn > 2) break;                                // Отсечение альфа канала
        }
        return rgb;
    }

    @Before
    public void start() {
        //driver = new FirefoxDriver();
        //driver = new ChromeDriver();
        driver = new InternetExplorerDriver();
        FirefoxOptions options = new FirefoxOptions().setBinary(new FirefoxBinary(new File("c:\\Program Files\\Firefox Nightly\\firefox.exe")));
        //driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver,10);
    }

    @Test
    public void fourthTest() {
        boolean names_matches = false;
        boolean reg_price_match = false;
        boolean cam_price_match = false;
        driver.get("http://localhost/litecart");
        WebElement item = driver.findElement(By.xpath(".//div[@id = 'box-campaigns']/div/ul/li"));
        WebElement name1 = item.findElement(By.xpath(".//a/div[@class = 'name']"));
        String name_1 = name1.getText();
        WebElement regPrice = item.findElement(By.xpath(".//a/div/*[@class = 'regular-price']"));
        String reg_price = regPrice.getText();
        String tg_reg_price = regPrice.getTagName();
        String cl_reg_price = regPrice.getCssValue("color");
        String regSize = regPrice.getCssValue("font-size");
        assertEquals(isGrey(cl_reg_price), true);                         //проверка серого цвета
        assertEquals(isStrikethrough(tg_reg_price), true);                // проверка зачеркнутого стиля
        WebElement camPrice = item.findElement(By.xpath(".//a/div/*[@class = 'campaign-price']"));
        String cam_price = camPrice.getText();
        String tg_cam_price = camPrice.getTagName();
        String cl_cam_price = camPrice.getCssValue("color");
        String camSize = camPrice.getCssValue("font-size");
        assertEquals(isRed(cl_cam_price), true);                         //проверка красного цвета
        assertEquals(isBold(tg_cam_price), true);                        // проверка жирного стиля
        assertEquals(comp_font_size(regSize, camSize), true);            // проверка на больший размер акционного ценника
        item.findElement(By.xpath(".//a")).click();
        String name_2 = driver.findElement(By.xpath(".//h1[@class = 'title']")).getText();
        WebElement regPrice2 = driver.findElement(By.xpath(".//*[@class = 'regular-price']"));
        String reg_price2 = regPrice2.getText();
        String tg_reg_price2 = regPrice2.getTagName();
        String cl_reg_price2 = regPrice2.getCssValue("color");
        String regSize2 = regPrice2.getCssValue("font-size");
        assertEquals(isGrey(cl_reg_price2), true);                       //проверка цвета
        assertEquals(isStrikethrough(tg_reg_price2), true);              // проверка  зачеркнутого стиля
        WebElement camPrice2 = driver.findElement(By.xpath(".//*[@class = 'campaign-price']"));
        String cam_price2 = camPrice2.getText();
        String tg_cam_price2 = camPrice2.getTagName();
        String cl_cam_price2 = camPrice2.getCssValue("color");
        String camSize2 = camPrice2.getCssValue("font-size");
        assertEquals(isRed(cl_cam_price2), true);                //проверка цвета
        assertEquals(isBold(tg_cam_price2), true);               // проверка  жирного стиля
        assertEquals(comp_font_size(regSize2, camSize2), true);   // проверка на больший размер акционного ценника
        if (name_1.equals(name_2)) names_matches = true;
        if (reg_price.equals(reg_price2)) reg_price_match = true;
        if (cam_price.equals(cam_price2)) cam_price_match = true;
        assertEquals(names_matches, true);                       // проверка на совпадение имен
        assertEquals(reg_price_match, true);                     // проверка на совпадение ценников
        assertEquals(cam_price_match, true);                     // проверка на совпадение акционных ценников
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

