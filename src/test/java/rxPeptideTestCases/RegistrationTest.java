package rxPeptideTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RegistrationTest extends BaseClass{
    @Test
    public void registrationTest() throws InterruptedException {
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	Thread.sleep(2000);
    	
        driver.findElement(By.xpath("//div[contains(@class,'h_account')]//a")).click();
        driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys(randomEmail());
        driver.findElement(By.xpath("//button[@name='register']")).click();

        WebElement registrationAlert = driver.findElement(By.xpath("//div[@role='alert']"));
        Assert.assertTrue(registrationAlert.isDisplayed(), "Alert message not displayed.");
        Assert.assertEquals(registrationAlert.getText().trim(),
                "Thank you for your registration. Your account has to be activated before you can login. Please check your email.");

        System.out.println("Registration test passed");
    }

}
