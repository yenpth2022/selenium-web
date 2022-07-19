package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ElementDisplaying {

    public static void main(String[] args) {

        // get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        driver.get("https://the-internet.herokuapp.com/login");

        List<WebElement> elementList = driver.findElements(By.tagName("taolao"));
        if (!elementList.isEmpty())
            //   Assert.fail("reason ...");

        // close browser - quit the browser session
        driver.quit();

    }
}
