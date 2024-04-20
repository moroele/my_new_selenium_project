import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.util.List;

public class NoLogsTest extends TestBase{
    @Test
    public void noLogsTest() {
        driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        assert (driver.manage().logs().get("browser").getAll().size() ==0);
        List<WebElement> products = driver.findElements(By.cssSelector("#content > form > table  a[href*=product_id]"));
        for (int i = 0; (i < products.size()); i++){
            products.get(i).click();
            assert (driver.manage().logs().get("browser").getAll().size() ==0);
            driver.navigate().to("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
            products = driver.findElements(By.cssSelector("#content > form > table  a[href*=product_id]"));
        }
    }
}
