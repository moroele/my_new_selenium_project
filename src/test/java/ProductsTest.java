import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class ProductsTest {
    public WebDriver driver;
    public WebDriverWait wait;
    public void productsTest() {
        driver.navigate().to("http://localhost/litecart/en/");
        WebElement duck = driver.findElement(By.cssSelector("#box-campaigns .product"));
        String name = duck.findElement(By.className("name")).getText();
        String price = duck.findElement(By.className("regular-price")).getText();
        String campaignPrice = duck.findElement(By.className("campaign-price")).getText();
        String priceColor = duck.findElement(By.className("regular-price")).getCssValue("color");
        String priceStyle = duck.findElement(By.className("regular-price")).getCssValue("text-decoration");
        String campaignPriceColor = duck.findElement(By.className("campaign-price")).getCssValue("color");
        String campaignPriceStyle = duck.findElement(By.className("campaign-price")).getCssValue("text-decoration");
        String priceSize = duck.findElement(By.className("regular-price")).getCssValue("font-size");
        String campaignPriceSize = duck.findElement(By.className("campaign-price")).getCssValue("font-size");
        System.out.println(name+ ' ' + price + ' ' + campaignPrice + ' ' + priceColor + ' ' + campaignPriceColor + ' ' + campaignPriceStyle + ' ' + priceSize);
        assert(priceStyle.contains("line-through"));
        assert(campaignPriceStyle.contains("solid"));
        assert(Float.parseFloat(campaignPriceSize.substring(0, campaignPriceSize.length()-2)) > Float.parseFloat(priceSize.substring(0, priceSize.length()-2)));
        int[] priceColorInt = parseColor(priceColor);
        assert(priceColorInt[0]==priceColorInt[1]);
        assert(priceColorInt[1]==priceColorInt[2]);
        int[] campaignPriceColorInt = parseColor(campaignPriceColor);
        assert(campaignPriceColorInt[1]==0);
        assert(campaignPriceColorInt[2]==0);

        //New page checks
        duck.findElement(By.tagName("a")).click();
        duck = driver.findElement(By.cssSelector("#box-product"));
        String newName = duck.findElement(By.className("title")).getText();
        assert(name.equals(newName));
        String newPrice = duck.findElement(By.className("regular-price")).getText();
        String newCampaignPrice = duck.findElement(By.className("campaign-price")).getText();
        assert(price.equals(newPrice));
        assert (campaignPrice.equals(newCampaignPrice));
        String newPriceColor = duck.findElement(By.className("regular-price")).getCssValue("color");
        String newPriceStyle = duck.findElement(By.className("regular-price")).getCssValue("text-decoration");
        String newCampaignPriceColor = duck.findElement(By.className("campaign-price")).getCssValue("color");
        String newCampaignPriceStyle = duck.findElement(By.className("campaign-price")).getCssValue("text-decoration");
        String newPriceSize = duck.findElement(By.className("regular-price")).getCssValue("font-size");
        String newCampaignPriceSize = duck.findElement(By.className("campaign-price")).getCssValue("font-size");
        assert(newPriceStyle.contains("line-through"));
        assert(newCampaignPriceStyle.contains("solid"));
        assert(Float.parseFloat(newCampaignPriceSize.substring(0, newCampaignPriceSize.length()-2)) > Float.parseFloat(newPriceSize.substring(0, newPriceSize.length()-2)));
        priceColorInt = parseColor(newPriceColor);
        assert(priceColorInt[0]==priceColorInt[1]);
        assert(priceColorInt[1]==priceColorInt[2]);
        campaignPriceColorInt = parseColor(newCampaignPriceColor);
        assert(campaignPriceColorInt[1]==0);
        assert(campaignPriceColorInt[2]==0);
    }
    public int[] parseColor(String input) {
        int[] color = new int[3];
//rgba(119, 119, 119, 1)
        int firstPoint = input.indexOf(',');
        int secondPoint = input.indexOf(',', firstPoint + 2);
        int thirdPoint = input.indexOf(',', secondPoint + 2);
        color[0] = Integer.parseInt(input.substring(5, firstPoint));
        color[1] = Integer.parseInt(input.substring(firstPoint + 2, secondPoint));
        color[2] = Integer.parseInt(input.substring(secondPoint + 2, thirdPoint));

        return color;
    }

    @Test
    public void inChromeProductsTest() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        productsTest();
    }

    @Test
    public void inSafariProductsTest() {
        driver = new SafariDriver();
        wait = new WebDriverWait(driver, 10);
        productsTest();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}
