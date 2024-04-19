import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class NewWindowTest extends TestBase{
    @Test
    public void newWindowTest() {
        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        driver.findElement(By.cssSelector("#content > form > table  a[href*=AF]")).click();
        String mainWindow = driver.getWindowHandle();
        String newWindow = "";
        List<WebElement> externalLinks = driver.findElements(By.cssSelector("#content > form > table a>i"));
        int s = externalLinks.size();
        for (int i = 0;  (i<s); i++) {
            externalLinks.get(i).click();
            wait.until((WebDriver d) -> d.getWindowHandles().size()>1);
            Set<String> windows = driver.getWindowHandles();
            for (Iterator<String> iterator = windows.iterator(); iterator.hasNext();) {
                String w =  iterator.next();
                if (!w.equals(mainWindow)) {
                    newWindow = w;
                }
            }
            driver.switchTo().window(newWindow);
            driver.close();
            driver.switchTo().window(mainWindow);
        }
    }
}
