package rxPeptideTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveFromCart extends BaseClass{

    @Test
    public void removeFromCart() throws InterruptedException {
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
        WebElement miniCart = driver.findElement(By.xpath("//span[@class='wpr-mini-cart-btn-text']"));
        miniCart.click();

        driver.findElement(By.xpath("//button[.='Remove item']")).click();
        
        WebElement emptyCartPageTitle = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[.='Your cart is currently empty!']")));
        Assert.assertTrue(emptyCartPageTitle.isDisplayed(), "Empty cart page title not displayed");
        Assert.assertEquals(emptyCartPageTitle.getText(), "Your cart is currently empty!");
        System.out.println("Remove from cart test passed");
    }

}
