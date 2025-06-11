package dataDrivenTesting;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FixedDipositCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		String filepath = System.getProperty("user.dir") + "\\TestData\\FixedInterest.xlsx";
		
		int rows = ExcelUtils.getRowCount(filepath, "Sheet1");
		
		for(int i = 1; i <= rows; i++) {
			// Read data from Excel
		    String Principle = ExcelUtils.getCellData(filepath, "Sheet1", i, 0);
		    String rateOfInterest = ExcelUtils.getCellData(filepath, "Sheet1", i, 1);
		    String period1 = ExcelUtils.getCellData(filepath, "Sheet1", i, 2);
		    String period2 = ExcelUtils.getCellData(filepath, "Sheet1", i, 3);
		    String frequency = ExcelUtils.getCellData(filepath, "Sheet1", i, 4);
		    String expectedValue = ExcelUtils.getCellData(filepath, "Sheet1", i, 5);

		    // Clear previous inputs
		    driver.findElement(By.xpath("//input[@id='principal']")).clear();
		    driver.findElement(By.xpath("//input[@id='interest']")).clear();
		    driver.findElement(By.xpath("//input[@id='tenure']")).clear();

		    // Send data to form
		    driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(Principle);
		    driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(rateOfInterest);
		    driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);

		    Select preDrop = new Select(driver.findElement(By.xpath("//select[@id='tenurePeriod']")));
		    preDrop.selectByVisibleText(period2);

		    Select freqDrop = new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
		    freqDrop.selectByVisibleText(frequency);

		    Thread.sleep(1000);
		    WebElement calculateBtn = driver.findElement(By.xpath("//div[@class='CTR PT15']//a[1]"));
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click();", calculateBtn);

		    // Handle alert if it appears
		    try {
		        Thread.sleep(500);
		        driver.switchTo().alert().accept(); // Accept and dismiss alert
		        System.out.println("Test Failed - Invalid Input Triggered Alert");
		        ExcelUtils.setCellData(filepath, "Sheet1", i, 7, "Fail - Invalid Input");
		        ExcelUtils.fillRedColour(filepath, "Sheet1", i, 7);
		        continue; // Skip to next row
		    } catch (Exception e) {
		        // No alert – continue to validation
		    }
			
			//validation
			String actualValue = driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			
			if (Double.parseDouble(expectedValue) == Double.parseDouble(actualValue)) {
				System.out.println("Test Passed");
				ExcelUtils.setCellData(filepath, "Sheet1", i, 7, "Pass");
				ExcelUtils.fillGreenColour(filepath, "Sheet1", i, 7);
			} else {
				System.out.println("Test Failed");
				ExcelUtils.setCellData(filepath, "Sheet1", i, 7, "Fail");
				ExcelUtils.fillRedColour(filepath, "Sheet1", i, 7);
			}
			
		}	
		
		driver.quit();
	}

}
