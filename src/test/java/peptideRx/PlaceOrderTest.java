package peptideRx;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PlaceOrderTest {

	public static void main(String[] args) throws InterruptedException {
		
		//base class
		WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rxpeptides.webgen.me/");

        driver.findElement(By.xpath("//input[@id='age-gate-m']")).sendKeys("12");
        driver.findElement(By.xpath("//input[@id='age-gate-d']")).sendKeys("12");
        driver.findElement(By.xpath("//input[@id='age-gate-y']")).sendKeys("1980");
        driver.findElement(By.xpath("//button[@name='ag_settings[submit]']")).click();
        
        //Place order test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	Thread.sleep(2000);
    	
        driver.findElement(By.xpath("//div[contains(@class,'h_account')]//a")).click();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("pepi123@yopmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testing@12345");
        driver.findElement(By.xpath("//input[@id='rememberme']")).click();
        driver.findElement(By.xpath("//button[@name='login']")).click();
        
        driver.findElement(By.xpath("//a[contains(text(),'Shop')]")).click();
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//a[@aria-label='Add to cart: “AOD-9604 (5MG)”']")));
        
        Thread.sleep(2000);
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", addToCartButton);
        js.executeScript("arguments[0].click();", addToCartButton);
//        addToCartButton.click();
        
        Thread.sleep(2000);
        js.executeScript("window.scrollTo(0, 0);");

        Thread.sleep(3000);
        WebElement miniCart = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[@class='wpr-mini-cart-btn-text']")));
        miniCart.click();
        
        WebElement proceedToCheckoutBtn = driver.findElement(By.xpath("//span[.='Proceed to Checkout']"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", proceedToCheckoutBtn);
        js.executeScript("arguments[0].click();", proceedToCheckoutBtn);
        
        WebElement paymentOptionRadioBtn = driver.findElement(By.xpath("//input[@id='radio-control-wc-payment-method-saved-tokens-14']"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", paymentOptionRadioBtn);
        js.executeScript("arguments[0].click();", paymentOptionRadioBtn);
        
        WebElement placeOrderBtn = driver.findElement(By.xpath("//div[.='Place Order']"));
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", placeOrderBtn);
        js.executeScript("arguments[0].click();", placeOrderBtn);
        
        WebElement orderReceivedTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[.='Order received']")));
        Assert.assertTrue(orderReceivedTitle.isDisplayed(),"Title not displayed");
        Assert.assertEquals(orderReceivedTitle.getText(), "Order received");
        System.out.println("Place order test passed");
        //base class
	    Thread.sleep(2000);
	    driver.quit();

	}

}
