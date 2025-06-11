package rxPeptideTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass{
    @Test
    public void loginTest() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	Thread.sleep(2000);
    	
        driver.findElement(By.xpath("//div[contains(@class,'h_account')]//a")).click();
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("pepi123@yopmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Testing@12345");
        driver.findElement(By.xpath("//input[@id='rememberme']")).click();
        driver.findElement(By.xpath("//button[@name='login']")).click();

        WebElement pageTitle = driver.findElement(By.xpath("//h1[@class='page-title']"));
        Assert.assertTrue(pageTitle.isDisplayed(), "Page title is not visible.");
        Assert.assertEquals(pageTitle.getText(), "My account");

        System.out.println("Login test passed");
    }

}
