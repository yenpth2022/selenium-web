package drivers;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver getChromeDriver() {

        String currentProjectLocation = System.getProperty("user.dir");
        String chromeDriverLocation = "";

        if(OS.isFamilyMac()){
            chromeDriverLocation = currentProjectLocation + "/src/test/resources/drivers/chromedriver";
        }

        if(OS.isFamilyWindows()) {
            chromeDriverLocation = currentProjectLocation + "\\src\\test\\resources\\drivers\\chromedriver.exe";
        }

        if(chromeDriverLocation.isEmpty()) {
            throw new IllegalArgumentException("Can't detect OS Type");
        }

        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        // chromeOptions.addArguments("--start-maximized");

        WebDriver driver = new ChromeDriver(chromeOptions);

        // Interval time | 500 milliseconds = 0.5 second
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        return driver;

    }
}
