package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import support.ui.SelectEx;
import url.Urls;

public class Dropdown implements Urls {

    public static void main(String[] args) {

        // Get chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to target base
            driver.get(baseGuruUrl.concat(dropdownSlug));

            // dropdown locator & element
            By dropdownSel = By.name("country");
            WebElement dropdownEle = driver.findElement(dropdownSel);

            // Select dropdown - Basic
            // Select select = new Select(dropdownEle);

            // select dropdown - Customize
            SelectEx select = new SelectEx(dropdownEle);

            // select by visible text | Option 1
            // select.selectByVisibleText("ALBANIA");
            select.selectOption1();

            // debug purpose only
            Thread.sleep(3000);

            // select by index
            select.selectByIndex(2);
            Thread.sleep(3000);

            // select by value
            select.selectByValue("BANGLADESH");
            Thread.sleep(3000);

            // select by value
            select.selectByValue("VIETNAM");
            Thread.sleep(3000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // close browser
        driver.quit();
    }
}
