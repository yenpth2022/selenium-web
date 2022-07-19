package api_learning;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageTitleAndCurrentURL {

    public static void main(String[] args) {

        // get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());

        } catch (Exception e) {
            e.printStackTrace();
        }

        // close browser - quit the browser session
        driver.quit();

    }
}
