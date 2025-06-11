package brokenLinkHandle;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SVGHandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[name()='svg']//*[name()='circle']"))).isDisplayed()) {
			System.out.println("Circle svg is displayed");
		} else {
			System.out.println("svg is not displayed");
		}
		
		if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[name()='svg']//*[name()='rect' and @fill='green']"))).isDisplayed()) {
			System.out.println("Rectangular svg is displayed");
		} else {
			System.out.println("svg is not displayed");
		}
		if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[name()='svg']//*[name()='polygon']"))).isDisplayed()) {
			System.out.println("Polygon svg is displayed");
		} else {
			System.out.println("svg is not displayed");
		}
		
		Thread.sleep(2000);
		driver.quit();
	}

}
