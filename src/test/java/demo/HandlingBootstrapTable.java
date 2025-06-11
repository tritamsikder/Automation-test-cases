package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandlingBootstrapTable {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']"))).sendKeys("Admin");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']"))).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		// Navigate to Admin tab
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Admin']/parent::a")));
		element.click();

		// Wait until table is loaded
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-table-body']")));

		// Locate all rows in the table
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='oxd-table-body']//div[@role='row']"));

		System.out.println("Username\t\tUser Role\t\tEmployee Name\t\tStatus");

		for (WebElement row : rows) {
			List<WebElement> cells = row.findElements(By.xpath(".//div[@role='cell']"));
			if (cells.size() >= 4) {
				String username = cells.get(1).getText();       // Username
				String userRole = cells.get(2).getText();       // User Role
				String empName = cells.get(3).getText();        // Employee Name
				String status = cells.get(4).getText();         // Status

				System.out.println(username + "\t\t" + userRole + "\t\t" + empName + "\t\t" + status);
			}
		}

		Thread.sleep(2000);
		driver.quit();
	}
}
