package Automation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Selenium 
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

    @Test(priority = 1)
    public void testSignup() {
        // Navigate to the registration page
        driver.get("https://magento.softwaretestingboard.com/customer/account/create/");
        
        // Fill out the form
        WebElement firstName = driver.findElement(By.id("firstname"));
        WebElement lastName = driver.findElement(By.id("lastname"));
        WebElement email = driver.findElement(By.id("email_address"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement confirmPassword = driver.findElement(By.id("password-confirmation"));
        
        firstName.sendKeys("Harvey");
        lastName.sendKeys("Spectre");
        email.sendKeys("harv.spec@example.com");
        password.sendKeys("f@Z3!234");
        confirmPassword.sendKeys("f@Z3!234");
        
        // Click on the 'Create an Account' button
        WebElement createAccountButton = driver.findElement(By.cssSelector("button[title='Create an Account']"));
        createAccountButton.click();
        
        // Add a wait here to wait for a specific element that confirms account creation
        
        // Assertion to verify that the signup was successful
        // This should be replaced with an appropriate success message or element check
        try {
            Thread.sleep(5000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebElement successMessage = driver.findElement(By.xpath("//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']"));

        // Assertion to verify that the signup was successful
        String expectedMessage = "Thank you for registering with Main Website Store.";
        String actualMessage = successMessage.getText();
        System.out.println(actualMessage);
        Assert.assertTrue(actualMessage.contains(expectedMessage), "The success message was not as expected.");
    }
    
    
    
    /*
    @Test(priority = 2)
    public void testSignin()
    {
    	driver.get("https://magento.softwaretestingboard.com/customer/account/login/referer/aHR0cHM6Ly9tYWdlbnRvLnNvZnR3YXJldGVzdGluZ2JvYXJkLmNvbS8%2C/");
    	
    	WebElement email = driver.findElement(By.id("email"));
        WebElement pwd = driver.findElement(By.id("pass"));
        
        email.sendKeys("harv.spec@example.com");
        pwd.sendKeys("f@Z3!234");
        
        WebElement Signin = driver.findElement(By.id("send2"));
        Signin.click();
        
        try {
            Thread.sleep(5000); // Static wait for 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        WebElement WelComeElement = driver.findElement(By.xpath("//div[@class='panel']//span[@class='logged-in'][normalize-space()='Welcome, Harvey Spectre!']"));
        String messagefound = WelComeElement.getText();
        String requiredMessage = "Welcome, Harvey Spectre!";
        Assert.assertTrue(messagefound.contains(requiredMessage), "The success message was not as expected.");
    }
*/
    @AfterMethod
    public void tearDown() {
        // Close the browser
        driver.quit();
    }
}
