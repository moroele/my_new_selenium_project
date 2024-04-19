import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class NewProductTest extends TestBase{
    @Test
    public void newProductTest() {
        File file = new File("src/duck.jpeg");
        String absolutePath = file.getAbsolutePath();
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.cssSelector("#app-> a[href*=catalog]")).click();
        driver.findElement(By.cssSelector("#content .button[href*=edit_product]")).click();
        driver.findElement(By.cssSelector("#tab-general input[name=\"status\"][value=\"1\"]")).click();
        driver.findElement(By.cssSelector("#tab-general input[name=\"name[en]\"]")).sendKeys("Duck");
        driver.findElement(By.cssSelector("#tab-general input[name=\"quantity\"]")).sendKeys("5");
        driver.findElement(By.cssSelector("#tab-general input[name=\"new_images[]\"]")).sendKeys(absolutePath);
        driver.findElement(By.cssSelector("#tab-general  input[name=date_valid_from]")).sendKeys("01.01.2000");
        driver.findElement(By.cssSelector("#content a[href*=information]")).click();
        wait = new WebDriverWait(driver, 10/*seconds*/);
        driver.findElement(By.cssSelector("#tab-information > table  input[name=\"short_description[en]\"]")).sendKeys("Duck Short Description");
        driver.findElement(By.cssSelector("#tab-information > table  div.trumbowyg-editor")).sendKeys("Duck Description");
        driver.findElement(By.cssSelector("#tab-information > table  input[name=\"head_title[en]\"]")).sendKeys("Duck Title");
        driver.findElement(By.cssSelector("#content a[href*=prices]")).click();
        wait = new WebDriverWait(driver, 10/*seconds*/);
        driver.findElement(By.cssSelector("#tab-prices > table  input[name=\"purchase_price\"]")).sendKeys("1");
        Select select = new Select(driver.findElement(By.cssSelector("select[name=purchase_price_currency_code]")));
        select.selectByValue("USD");
        driver.findElement(By.cssSelector("#tab-prices > table  input[name=\"prices[USD]\"]")).sendKeys("5");
        driver.findElement(By.cssSelector("#content  button[name=\"save\"]")).click();
        driver.findElement(By.cssSelector("#app-> a[href*=catalog]")).click();
        driver.findElement(By.xpath("//a[.='Duck']"));
    }
}
