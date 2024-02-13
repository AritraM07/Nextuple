package Automation2;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;



public class Flip_Signup 
{
	private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // Setup ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        // Create instance of WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    
    @Test
    public void signup()
    {
    	driver.get("https://www.flipkart.com/#");
    	driver.findElement(By.xpath("//img[@alt='Grocery']")).click();
    	driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
    	try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	driver.findElement(By.xpath("//a[normalize-space()='New to Flipkart? Create an account']")).click();
    	try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	
    	
    	driver.findElement(By.xpath("//input[@maxlength='10']")).sendKeys("6291705332");
    	
    	try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	driver.findElement(By.xpath("//span[normalize-space()='CONTINUE']")).click();
    	
    	try {
            Thread.sleep(15000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	driver.findElement(By.xpath("//span[normalize-space()='Signup']")).click();
    	
    }
    
    @AfterMethod
    public void tearDown() 
    {
        // Close the browser
        driver.quit();
    }
}
