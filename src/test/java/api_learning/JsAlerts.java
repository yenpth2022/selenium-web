package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

public class JsAlerts implements Urls {

    private final static By jsAlertSel = By.cssSelector("[onclick=\"jsAlert()\"]");
    private final static By jsAlertConfirmationSel = By.cssSelector("[onclick=\"jsConfirm()\"]");
    private final static By jsAlertPromptSel = By.cssSelector("[onclick=\"jsPrompt()\"]");
    private final static By resultSel = By.id("result");

    public static void main(String[] args) {

        // Get chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // navigate to target base
            driver.get(baseUrl.concat(jsAlertSlug));

            // js_alert | OKE
            handleAlert(driver, jsAlertSel, true);
            System.out.println("Result = " + driver.findElement(resultSel).getText());
            Thread.sleep(2000);

            // js_confirm | Cancel
            handleAlert(driver, jsAlertConfirmationSel, false);
            System.out.println("Result = " + driver.findElement(resultSel).getText());
            Thread.sleep(2000);

            // js_prompt
            handleAlert(driver, jsAlertPromptSel, "My name is Yen");
            System.out.println("Result = " + driver.findElement(resultSel).getText());
            Thread.sleep(2000);

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();
    }

    public static void handleAlert(WebDriver driver, By triggerAlertSel, boolean isAccepting) {
        Alert alert = getAlert(driver, triggerAlertSel);
        System.out.println("Alert content = " + alert.getText());
        if (isAccepting) alert.accept();
        else alert.dismiss();
    }

    public static void handleAlert(WebDriver driver, By triggerAlertSel, String contentToEnter) {
        Alert alert = getAlert(driver, triggerAlertSel);
        System.out.println("Alert content = " + alert.getText());
        alert.sendKeys(contentToEnter);
        alert.accept();

    }

    public static Alert getAlert(WebDriver driver, By triggerAlertSel) {
        WebElement triggerJsAlertBtnElem = driver.findElement(triggerAlertSel);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        triggerJsAlertBtnElem.click();
        return wait.until(ExpectedConditions.alertIsPresent());
    }
}
