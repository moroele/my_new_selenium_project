package app;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBe;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Application {

    private WebDriver driver;
    private WebDriverWait wait;

    public Application() {
        driver = new SafariDriver();
        wait = new WebDriverWait(driver, 10);
    }

    public void quit() {
        driver.quit();
    }

    public void selectProduct() {
        driver.get("http://localhost/litecart/en/");
        wait.until(presenceOfElementLocated(By.cssSelector("#cart > a.content > span.quantity")));
        driver.findElement(By.cssSelector("#box-most-popular  li:nth-child(1) > a.link")).click();
    }
    public void addSelectedProductToCart() {
        wait.until(presenceOfElementLocated(By.cssSelector("button[name=\"add_cart_product\"]")));
        int n = this.getNumberOfItemsInCart();
        driver.findElement(By.cssSelector("button[name=\"add_cart_product\"]")).click();
        wait.until((WebDriver d) -> d.findElement(By.cssSelector("#cart > a.content > span.quantity")).getText().equals(Integer.toString(n+1)));

    }

    public void removeProductFromCart() {
        driver.get("http://localhost/litecart/en/");
        wait.until(presenceOfElementLocated(By.cssSelector("#cart > a.link")));
        int n = this.getNumberOfItemsInCart();
        driver.findElement(By.cssSelector("#cart > a.link")).click();
        wait.until(presenceOfElementLocated(By.cssSelector("#box-checkout-cart li:nth-child(1)  button[value=\"Remove\"]")));
        driver.findElement(By.cssSelector("#box-checkout-cart li:nth-child(1)  button[value=\"Remove\"]")).click();
        wait.until(numberOfElementsToBe(By.cssSelector("#order_confirmation-wrapper > table td.item"), n-1));

    }

    public int getNumberOfItemsInCart() {
        if (driver.findElements(By.cssSelector("#cart > a.content > span.quantity")).size() < 0) {
            driver.get("http://localhost/litecart/en/");
            wait.until(presenceOfElementLocated(By.cssSelector("#cart > a.content > span.quantity")));}
        return Integer.parseInt(driver.findElement(By.cssSelector("#cart > a.content > span.quantity")).getText());
    }

}