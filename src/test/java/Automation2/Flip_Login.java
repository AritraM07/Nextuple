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


public class Flip_Login 
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
    public void login()
    {    
    	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	driver.get("https://www.flipkart.com/#");
    	driver.findElement(By.xpath("//img[@alt='Grocery']")).click();
    	driver.findElement(By.xpath("//a[normalize-space()='Login']")).click();
    	try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	driver.findElement(By.xpath("//span[normalize-space()='Enter Email/Mobile number']/../..//input")).sendKeys("6291705332");
    	driver.findElement(By.xpath("//button[normalize-space()='Request OTP']")).click();
    	try {
            Thread.sleep(18000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	
    	driver.findElement(By.xpath("//button[normalize-space()='Verify']")).click();
    	try {
            Thread.sleep(2000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    	driver.findElement(By.xpath("")).click();
    	try {
            Thread.sleep(15000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	
    	driver.findElement(By.xpath("//button[normalize-space()='Verify']")).click();
    }
    
    
}
