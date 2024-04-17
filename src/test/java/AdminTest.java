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
        List<WebElement> links = driver.findElements(By.cssSelector("#app-> a"));
        int s = links.size();
        System.out.println(s);
        List<WebElement> internalLinks;

        for (int i = 0;  (i<s); i++) {
            links = driver.findElements(By.cssSelector("#app-> a"));
            links.get(i).click();
            driver.findElement(By.tagName("h1"));
            internalLinks = driver.findElements(By.cssSelector("#app-.selected>.docs a"));
            int ss = internalLinks.size();
            System.out.println(ss);
            for (int j = 0;  (j<ss); j++) {
                internalLinks = driver.findElements(By.cssSelector("#app-.selected>.docs a"));
                internalLinks.get(j).click();
                driver.findElement(By.tagName("h1"));
            }

        }
    }

}
