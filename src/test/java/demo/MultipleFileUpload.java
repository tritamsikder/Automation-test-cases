package demo;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleFileUpload {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		
		//Multiple file location
		String file1 = "D:\\New folder\\pic.jpg";
		String file2 = "D:\\New folder\\pic2.jpg";
		
		//Uploading Files
		WebElement uploadBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='filesToUpload']")));
		uploadBtn.sendKeys(file1 + "\n" + file2);
		
		//Counting number of files
	    int totalFilesUploaded = driver.findElements(By.xpath("//ul[@id='fileList']/li")).size();
	    
	    if (totalFilesUploaded == 2) {
			System.out.println("Files are uploaded");
		} else {
			System.out.println("Files are not uploaded");
		}
	    
	    Thread.sleep(2000);
	    driver.quit();
		
	}

}
