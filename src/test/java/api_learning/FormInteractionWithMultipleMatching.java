package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FormInteractionWithMultipleMatching {
    public static void main(String[] args) {

        // get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");

            // define selector values
            By loginInputFieldsSel = By.tagName("input_");

            // interaction
            List<WebElement> loginFormFieldsElem = driver.findElements(loginInputFieldsSel);
            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;
            if(!loginFormFieldsElem.isEmpty()) {
                loginFormFieldsElem.get(USERNAME_INDEX).sendKeys("yen@sth.com");
                loginFormFieldsElem.get(PASSWORD_INDEX).sendKeys("12345678");
            } else {
                // Assert.fail("reason....");
            }

            // DEBUG PURPOSE ONLY
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // close browser - quit the browser session
        driver.quit();

    }
}
