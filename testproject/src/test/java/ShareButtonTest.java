import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ShareButtonTest {

    private WebDriver driver;

    @Before
    public void setUp() {
        // set the path to firefox gecko driver
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\zheny\\Downloads\\Compressed\\geckodriver-v0.33.0-win64\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void testShareButtonFunctionality() {
        // open the webpage
        driver.get("file:///C:/Users/zheny/Desktop/UNM-SQA-2023-24/index.html?v=XhFVtuNDAoM");

        // find and click the share button
        driver.findElement(By.id("shareButton")).click();

        // wait for the share modal to be displayed
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shareModal")));

        // check if the modal is displayed
        boolean isModalDisplayed = driver.findElement(By.id("shareModal")).isDisplayed();
        assertTrue("Share modal should be displayed", isModalDisplayed);


    }

    @After
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}