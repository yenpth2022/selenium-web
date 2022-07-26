package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

public class IFrame implements Urls {

    public static void main(String[] args) {

        // Get chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to target base
            driver.get(baseUrl.concat(iframeSlug));

            // locate the iframe
            By iFrameSel = By.cssSelector("[id$='ifr']");
            WebElement iFrameElem = driver.findElement(iFrameSel);

            // switch to the iframe
            driver.switchTo().frame(iFrameElem);

            // locate element inside the iframe
            WebElement editorInputElem = driver.findElement(By.id("tinymce"));
            editorInputElem.click();
            editorInputElem.clear();
            editorInputElem.sendKeys("New text value....");
            Thread.sleep(2000);

            // switch back to the parent frame
            driver.switchTo().defaultContent();
            driver.findElement(By.linkText("Elemental Selenium")).click();
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // close browser
        driver.quit();
    }
}
