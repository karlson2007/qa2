package Test1;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * First test fot open page Javaguru.lv
 */
public class JavaguruRegistration {

    @Test
    public void firstTest() {
        System.setProperty("webdriver.chrome.driver", "C:/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();

        // Open page Javaguru.lv && Check title
        driver.get("http://javaguru.lv");
        Assert.assertEquals("JavaGuru - Software Development Courses", driver.getTitle());

        // Click link Java 1 && Check title
        driver.findElement(By.linkText("Курс Java 1")).click();
        Assert.assertEquals("JavaGuru - Software Development Courses", driver.getTitle());

        // Recieve current window handle - СТЫРЕНО
        String parentHandle = driver.getWindowHandle();

        // Click link Регистрация
        driver.findElement(By.linkText("Регистрация на курс")).click();

        // Switch to New window - Регистрация - СТЫРЕНО
        for(String childHandle : driver.getWindowHandles()){
            if (!childHandle.equals(parentHandle)){
                driver.switchTo().window(childHandle);
            }
        }

        // Сheck title for needed Tab
        Assert.assertEquals("Регистрация на курс: Java 1 - Introduction to Java", driver.getTitle());

        // Check page is loaded && elements exist
        WebElement elementx = (new WebDriverWait(driver, 10)) .until(ExpectedConditions.presenceOfElementLocated(By.id("entry_1000000")));

        // Enter data to the forms
        driver.findElement(By.id("entry_1000000")).sendKeys("Olegs");
        driver.findElement(By.id("entry_1000001")).sendKeys("Kucerenko");
        driver.findElement(By.id("entry_1000002")).sendKeys("22836726");
        driver.findElement(By.id("entry_1000003")).sendKeys("olegs.kucerenko@gmail.com");
        driver.findElement(By.id("group_1829995951_2")).click();
        driver.findElement(By.id("ss-submit")).click();

        // Close browser
        //driver.quit();
    }
}
