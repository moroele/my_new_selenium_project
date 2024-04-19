import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;

public class CartTest extends TestBase {
    @Test
    public void cartTest() {
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("#box-most-popular  li:nth-child(1) > a.link")).click();
        driver.findElement(By.cssSelector("button[name=\"add_cart_product\"]")).click();
        wait.until((WebDriver d) -> d.findElement(By.cssSelector("#cart > a.content > span.quantity")).getText().equals("1"));
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("#box-most-popular  li:nth-child(1) > a.link")).click();
        driver.findElement(By.cssSelector("button[name=\"add_cart_product\"]")).click();
        wait.until((WebDriver d) -> d.findElement(By.cssSelector("#cart > a.content > span.quantity")).getText().equals("2"));
        driver.get("http://localhost/litecart/en/");
        driver.findElement(By.cssSelector("#box-most-popular  li:nth-child(1) > a.link")).click();
        driver.findElement(By.cssSelector("button[name=\"add_cart_product\"]")).click();
        wait.until((WebDriver d) -> d.findElement(By.cssSelector("#cart > a.content > span.quantity")).getText().equals("3"));
        driver.findElement(By.cssSelector("#cart > a.link")).click();
        driver.findElement(By.cssSelector("#box-checkout-cart li:nth-child(1)  button[value=\"Remove\"]")).click();
        wait.until(numberOfElementsToBe(By.cssSelector("#order_confirmation-wrapper > table td.item"), 2));
        driver.findElement(By.cssSelector("#box-checkout-cart li:nth-child(1)  button[value=\"Remove\"]")).click();
        wait.until(numberOfElementsToBe(By.cssSelector("#order_confirmation-wrapper > table td.item"), 1));
        driver.findElement(By.cssSelector("#box-checkout-cart li:nth-child(1)  button[value=\"Remove\"]")).click();
        wait.until(numberOfElementsToBe(By.cssSelector("#order_confirmation-wrapper > table td.item"), 0));
    }
}