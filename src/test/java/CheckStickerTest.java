import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckStickerTest extends TestBase{
    @Test
    public void checkStickerTest() {

        driver.get("http://localhost/litecart/en/");
        List<WebElement> ducks = driver.findElements(By.cssSelector("div.image-wrapper"));
        for (WebElement duck:  ducks) {
            duck.findElement(By.cssSelector("div.sticker"));
        }
    }
}
