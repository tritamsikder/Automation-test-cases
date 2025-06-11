package rxPeptideTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseClass{

    @Test
    public void addToCartTest() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	Thread.sleep(2000);
    	
        driver.findElement(By.xpath("//div[contains(@class,'h_account')]//a")).click();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("pepi123@yopmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testing@12345");
        driver.findElement(By.xpath("//input[@id='rememberme']")).click();
        driver.findElement(By.xpath("//button[@name='login']")).click();
        
        driver.findElement(By.xpath("//a[contains(text(),'Shop')]")).click();
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

        WebElement productTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//a[.='AOD-9604 (5MG)']")));

        Assert.assertTrue(productTitle.isDisplayed(), "Product not present");
        Assert.assertEquals(productTitle.getText(), "AOD-9604 (5MG)");
        
        System.out.println("Add to cart test passed");
    }
    
}
