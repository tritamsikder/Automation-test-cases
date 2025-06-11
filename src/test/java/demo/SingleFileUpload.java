package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SingleFileUpload {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		//Uploading File
		WebElement uploadBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='filesToUpload']")));
		uploadBtn.sendKeys("D:\\New folder\\pic.jpg");
		
		//Checking file is uploaded or not
		if (driver.findElement(By.xpath("//ul[@id='fileList']/li")).getText().equals("pic.jpg")) {
			System.out.println("Test case pass");
		} else {
			System.out.println("Test case fail");
		}
		Thread.sleep(2000);
		driver.quit();
		
	}

}
