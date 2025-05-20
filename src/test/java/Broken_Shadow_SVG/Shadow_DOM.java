package Broken_Shadow_SVG;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriver;

public class Shadow_DOM {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		
		ChromiumDriver driver = new ChromeDriver(options);
		driver.get("https://books-pwakit.appspot.com/");
		//driver.get("https://dev.automationtesting.in/shadow-dom");
		
		//This Element is inside single shadow DOM.
		/*
		SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		Thread.sleep(1000);
		shadow.findElement(By.cssSelector("#input")).sendKeys("Selenium");
		*/
		
					//	[OR]
		
		//Through WebElement		
		/*
		WebElement host = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']"));
		SearchContext shadowRoot = host.getShadowRoot();

		WebElement searchInput = shadowRoot.findElement(By.cssSelector("#input"));
		searchInput.sendKeys("Selenium");

		searchInput.sendKeys(Keys.ENTER);					
		*/
	}

}
