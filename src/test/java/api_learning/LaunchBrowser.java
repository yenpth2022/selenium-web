package api_learning;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {

    public static void main(String[] args) {

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

        WebDriver webDriver = new ChromeDriver(chromeOptions);
        // webDriver.manage().window().maximize();
        webDriver.get("https://learn.sdetpro.com/");

        // debug purpose only
        try {
            Thread.sleep(3000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        webDriver.quit();
    }
}
