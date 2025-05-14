package WebDriverMethods.WaitMethods;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class Fluent_Wait {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//declaration
				Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					    					.withTimeout(Duration.ofSeconds(10))
					    					.pollingEvery(Duration.ofSeconds(2))
					    					.ignoring(NoSuchElementException.class);
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		//usage
		/*
		WebElement username = wait.until(new Function<WebDriver, WebElement>() {
									public WebElement apply(WebDriver driver) {
											//return driver.findElement(By.xpath("//a[@name='username' and contains(@placeholder, 'User')]"));
											//return driver.findElement(By.xpath("//a[contains(text(),'Orange')]"));
											//return driver.findElement(By.linkText("OrangeHRM, Inc"));
											return driver.findElement(By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']/parent::div/parent::form/parent::div/following-sibling::div[1]/descendant::p[2]/a"));
									}
								});
		*/
		//								[OR]
		WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("OrangeHRM, Inc")));
		
		//action
		username.sendKeys("Admin");
		
		driver.close();
	
	}

}