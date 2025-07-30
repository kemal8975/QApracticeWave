package utils;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

    private Driver() {}

    private static WebDriver driver;

    // normally we wouldn't hard code the "chrome"... must be in a config file etc.
    private static final String BROWSER = "chrome";

    public static WebDriver getDriver() {
        if (driver == null) {
            if ("chrome".equalsIgnoreCase(BROWSER)) {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }

        }
        return driver;
    }


}
