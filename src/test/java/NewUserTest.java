import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.SimpleDateFormat;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

public class NewUserTest extends TestBase{
    @Test
    public void newUserTest() {
        String timeStamp = new SimpleDateFormat("HH.mm.ss").format(new java.util.Date());
        String email = "ee" + timeStamp + "@ya.ru";
        System.out.println(email);
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.linkText("New customers click here")).click();
        wait.until(presenceOfElementLocated(By.name("firstname")));
        driver.findElement(By.name("firstname")).sendKeys("E");
        driver.findElement(By.name("lastname")).sendKeys("M");
        driver.findElement(By.name("address1")).sendKeys("A1");
        driver.findElement(By.name("postcode")).sendKeys("12345");
        driver.findElement(By.name("city")).sendKeys("S");
        driver.findElement(By.cssSelector("#create-account  span.select2-selection__arrow")).click();
        driver.findElement(By.cssSelector(".select2-results__option[id $=US]")).click();
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.name("phone")).sendKeys("777");
        driver.findElement(By.name("password")).sendKeys("123456");
        driver.findElement(By.name("confirmed_password")).sendKeys("123456");
        driver.findElement(By.cssSelector("button[name=create_account]")).click();
        wait.until(presenceOfElementLocated(By.cssSelector("#box-account a[href*=logout]")));
        driver.findElement(By.cssSelector("#box-account a[href*=logout]")).click();
        wait.until(presenceOfElementLocated(By.cssSelector("#box-account-login  input[name=email]")));
        driver.findElement(By.cssSelector("#box-account-login  input[name=email]")).sendKeys(email);
        driver.findElement(By.cssSelector("#box-account-login  input[name=password]")).sendKeys("123456");
        driver.findElement(By.cssSelector("#box-account-login  button[name=login]")).click();
        wait.until(presenceOfElementLocated(By.cssSelector("#box-account a[href*=logout]")));
        driver.findElement(By.cssSelector("#box-account a[href*=logout]")).click();
    }
}