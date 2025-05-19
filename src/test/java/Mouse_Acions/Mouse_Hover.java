package Mouse_Acions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mouse_Hover {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.get("https://demo.opencart.com.gr/");
		
		WebElement desktop = driver.findElement(By.xpath("//a[text() = 'Desktops']"));
		WebElement Mac = driver.findElement(By.xpath("//a[text() = 'Mac (1)']"));
		
		Actions action = new Actions(driver);
		
		//fast driven
		action.moveToElement(desktop).moveToElement(Mac).build().perform();
		
		//halt for some seconds
		action.moveToElement(desktop).pause(Duration.ofSeconds(2)).moveToElement(Mac).perform();
		
		//halt with clicking the webelement
		action.moveToElement(desktop).pause(Duration.ofSeconds(2)).moveToElement(Mac).pause(Duration.ofSeconds(2)).click().perform();
		
		//navigate to webElement and sendKeys	
		WebElement search = driver.findElement(By.cssSelector("[placeholder='Search']"));
		action.moveToElement(search).pause(Duration.ofSeconds(2)).click().sendKeys("Selenium").perform();
	}
}
