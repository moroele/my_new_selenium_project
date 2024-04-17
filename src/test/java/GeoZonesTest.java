import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GeoZonesTest extends TestBase{
    @Test
    public void geoZonesTest() {
        driver.navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> countriesRows = driver.findElement(By.cssSelector(".dataTable")).findElements(By.tagName("tr"));
        int s = countriesRows.size();
        System.out.println(s);
        for (int i = 1;  (i<s-1); i++) {
            List<WebElement> countryCols = countriesRows.get(i).findElements(By.tagName("td"));
            countryCols.get(2).findElement(By.tagName("a")).click();
            //check zones
            List<WebElement> zonesRows = driver.findElement(By.cssSelector(".dataTable#table-zones")).findElements(By.tagName("tr"));
            int ss = zonesRows.size();
            System.out.println(ss);
            String lastZone = "A";
            for (int j = 1;  (j<ss-1); j++) {
                Select select = new Select(zonesRows.get(j).findElements(By.tagName("td")).get(2).findElement(By.tagName("select")));
                WebElement option = select.getFirstSelectedOption();
                String zoneName = option.getText();
                assert (lastZone.compareTo(zoneName) < 0);
                lastZone = zoneName;
            }
            //check end
            driver.navigate().to("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
            countriesRows = driver.findElement(By.cssSelector(".dataTable")).findElements(By.tagName("tr"));
        }
    }
}
