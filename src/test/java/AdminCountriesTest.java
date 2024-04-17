import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AdminCountriesTest extends TestBase{
    @Test
    public void adminCountriesTest() {
        driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
        List<WebElement> countriesRows = driver.findElement(By.cssSelector("#content > form > table")).findElements(By.tagName("tr"));
        int s = countriesRows.size();
        System.out.println(s);
        String lastCountry = "A";
        for (int i = 1;  (i<s-1); i++) {
            List<WebElement> countryCols = countriesRows.get(i).findElements(By.tagName("td"));
            String countryName = countryCols.get(4).getText();
            String zone = countryCols.get(5).getText();
            System.out.println(countryName + ' ' + zone);
            assert(lastCountry.compareTo(countryName) < 0);
            lastCountry = countryName;

            if  (!zone.equals("0")) {
                System.out.println(countryCols.get(4).getAttribute("href"));
                driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=edit_country&country_code=CA");
                //check zones
                List<WebElement> zonesRows = driver.findElement(By.cssSelector("div #table-zones")).findElements(By.tagName("tr"));
                int ss = zonesRows.size();
                System.out.println(ss);
                String lastZone = "A";
                for (int j = 1;  (j<ss-1); j++) {
                    List<WebElement> zoneCols = zonesRows.get(j).findElements(By.tagName("td"));
                    String zoneName = zoneCols.get(2).getText();
                    System.out.println(zoneName);
                    assert (lastZone.compareTo(zoneName) < 0);
                    lastZone = zoneName;
                }
                //check end

                driver.navigate().to("http://localhost/litecart/admin/?app=countries&doc=countries");
                countriesRows = driver.findElement(By.cssSelector("#content > form > table")).findElements(By.tagName("tr"));
                System.out.println("Ok");
            }
        }
    }
}
