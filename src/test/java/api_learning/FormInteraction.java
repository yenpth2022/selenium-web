package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormInteraction {

    public static void main(String[] args) {

        // get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");

            // define selector values
            By usernameSel = By.id("username");
            By passwordSel = By.cssSelector("#password");
            By loginBtnSel = By.cssSelector("[type='submit']");

            // find element
            WebElement userNameElem = driver.findElement(usernameSel);
            // WebElement userNameElem = driver.findElement(By.cssSelector("#username"));
            WebElement passwordElem = driver.findElement(passwordSel);
            WebElement loginBtnElem = driver.findElement(loginBtnSel);

            // get attribute values - in Login button element
            System.out.println(" Login button type = " + loginBtnElem.getAttribute("type"));
            System.out.println(" Login button background color = " + loginBtnElem.getCssValue("background-color"));

            // interaction
            // userNameElem.clear();
            userNameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("SuperSecretPassword!");
            loginBtnElem.click();

            // go back to the previous page
            driver.navigate().back();

            // refresh page
            driver.navigate().refresh();

            // re-interact with element again
            userNameElem = driver.findElement(usernameSel);
            passwordElem = driver.findElement(passwordSel);
            loginBtnElem = driver.findElement(loginBtnSel);
            userNameElem.sendKeys("usernamefake");
            passwordElem.sendKeys("123456");
            loginBtnElem.click();

            // DEBUG PURPOSE ONLY
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // close browser - quit the browser session
        driver.quit();

    }
}
