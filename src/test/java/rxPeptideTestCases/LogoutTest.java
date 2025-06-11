package rxPeptideTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseClass{
    @Test
    public void logoutTest() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	Thread.sleep(2000);
    	
        driver.findElement(By.xpath("//div[contains(@class,'h_account')]//a")).click();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("pepi123@yopmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testing@12345");
        driver.findElement(By.xpath("//input[@id='rememberme']")).click();
        driver.findElement(By.xpath("//button[@name='login']")).click();

        driver.findElement(By.xpath("//p[contains(text(),'Hello')]//a[contains(text(),'Log out')]")).click();

        WebElement pageTitle = driver.findElement(By.xpath("//h2[normalize-space()='Register']"));
        Assert.assertTrue(pageTitle.isDisplayed(), "Register heading is not visible.");
        Assert.assertEquals(pageTitle.getText(), "Register");

        System.out.println("Logout test passed");
    }
}
