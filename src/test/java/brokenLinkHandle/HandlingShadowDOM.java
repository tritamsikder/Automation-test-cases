package brokenLinkHandle;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingShadowDOM {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://dev.automationtesting.in/shadow-dom");
		driver.manage().window().maximize();
		
		
		//Element is inside single shadow
	 	SearchContext shadow = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
//	 	Thread.sleep(1000);
	 	WebElement el = shadow.findElement(By.cssSelector("#shadow-element"));
	 	
	 	if (el.isDisplayed()) {
			System.out.println("Shadow element located");
		} else {
			System.out.println("Shadow element not located");
		}
	 	
	 	//Element is inside two nested shadow DOM
	 	SearchContext shadow0 = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
//	 	Thread.sleep(1000);
	 	SearchContext shadow1 = shadow0.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
	 	WebElement shadowEl = shadow1.findElement(By.cssSelector("#nested-shadow-element"));
	 	 
	 	if (shadowEl.isDisplayed()) {
			System.out.println("Nested shadow element located");
		} else {
			System.out.println("Nested shadow element not located");
		}
	 	 
	 	
	 	//Element inside 3 nested shadow DOM
	 	SearchContext outterShadowRoot = driver.findElement(By.cssSelector("#shadow-root")).getShadowRoot();
//	 	Thread.sleep(1000);
	 	SearchContext innerShadowRoot = outterShadowRoot.findElement(By.cssSelector("#inner-shadow-dom")).getShadowRoot();
//	 	Thread.sleep(1000);
	 	SearchContext nestedShadowRoot = innerShadowRoot.findElement(By.cssSelector("#nested-shadow-dom")).getShadowRoot();
//	 	Thread.sleep(1000);
	 	WebElement nestedShadowEl = nestedShadowRoot.findElement(By.cssSelector("#multi-nested-shadow-element"));
	 	
	 	if (nestedShadowEl.isDisplayed()) {
			System.out.println("Multi-nested shadow element located");
		} else {
			System.out.println("Multi-nested shadow element not located");
		}	 		
		
		Thread.sleep(2000);
		driver.quit();
	}

}
