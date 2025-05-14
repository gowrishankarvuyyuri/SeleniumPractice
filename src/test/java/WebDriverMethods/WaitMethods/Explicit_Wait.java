package WebDriverMethods.WaitMethods;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Explicit_Wait {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//Getting a NoSuchElementException, unable to trace the locator to send keys
		/*
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("input.oxd-input oxd-input--active")).sendKeys("Admin");
		
		driver.close();
		*/
		
		//declaration of explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//usage
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.oxd-input[name='username']")));
		
		//action
		username.sendKeys("Admin");
		
		
	}

}
