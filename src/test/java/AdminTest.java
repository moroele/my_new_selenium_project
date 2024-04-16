import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminTest extends TestBase{
    @Test
    public void adminTest() {
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> links = driver.findElements(By.cssSelector("#box-apps-menu-wrapper a"));
        System.out.println(links.size());
        for (WebElement link : links) {
            link.click();
            driver.findElement(By.tagName("h1"));

            return;
        }
    }

}
