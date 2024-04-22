import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class CartTest extends TestBase {
    @Test
    public void cartTest() {
        for (int i = 1; i <=3; i++) {
            driver.get("http://localhost/litecart/en/");
            driver.findElement(By.cssSelector("#box-most-popular  li:nth-child(1) > a.link")).click();
            wait.until(presenceOfElementLocated(By.cssSelector("button[name=\"add_cart_product\"]")));
            if (driver.findElement(By.cssSelector("#box-product h1.title")).getText().equals("Yellow Duck")) {
                Select size = new Select(driver.findElement(By.name("options[Size]")));
                size.selectByValue("Small");
            }
            driver.findElement(By.cssSelector("button[name=\"add_cart_product\"]")).click();
            int n = i;
            wait.until((WebDriver d) -> d.findElement(By.cssSelector("#cart > a.content > span.quantity")).getText().equals(Integer.toString(n)));
        }
        int numOfPositions = driver.findElements(By.cssSelector("#order_confirmation-wrapper > table td.item")).size();
        for (int i = numOfPositions -1; i >=0; i--) {
            driver.findElement(By.cssSelector("#cart > a.link")).click();
            driver.findElement(By.cssSelector("#box-checkout-cart li:nth-child(1)  button[value=\"Remove\"]")).click();
            wait.until(numberOfElementsToBe(By.cssSelector("#order_confirmation-wrapper > table td.item"), i));
        }
    }
}