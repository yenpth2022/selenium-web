package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LinkTextInteraction {

    public static void main(String[] args) {

        // get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");

            // define selector values
            // By poweredByLinkTextInteraction = By.linkText("Elemental Selenium");
            By poweredByLinkTextInteraction = By.partialLinkText("Selenium");

            // find element
            WebElement poweredByLinkTextElem = driver.findElement(poweredByLinkTextInteraction);

            // interaction
            poweredByLinkTextElem.click();

            // DEBUG PURPOSE ONLY
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // close browser - quit the browser session
        driver.quit();

    }
}
