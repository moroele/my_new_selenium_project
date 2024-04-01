import org.junit.Test;
import org.openqa.selenium.By;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class LoginTest extends TestBase {

    @Test
    public void loginTest() {
        driver.navigate().to("http://localhost/litecart/admin/");
        driver.findElement(By.name("username")).sendKeys("moroele");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.name("login")).click();
    }
}
