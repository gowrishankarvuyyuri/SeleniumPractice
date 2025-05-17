package WebDriverMethods.SwitchTo;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alerts_PopUps {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//Normal Pop-Ups which has only OK
		/*
		driver.findElement(By.id("alertBtn")).click();
		driver.switchTo().alert().accept();
		*/
		
		// Confirmational Alert which has both Ok and Close
		/*
		driver.findElement(By.id("confirmBtn")).click();
		Alert alert = driver.switchTo().alert();
		
		System.out.println(alert.getText());
		alert.accept();
		//alert.dismiss();
		
		String result = driver.findElement(By.id("demo")).getText().trim();
		
		if(result.equals("You pressed OK!"))
			System.out.println("Test Case Passed");
		else
			System.out.println("Test Case Failed");
		*/
		
		//using  explicit wait for handling alert
		/*
		driver.findElement(By.id("confirmBtn")).click();
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		System.out.println(alert.getText());
		alert.accept();
		
		String result = driver.findElement(By.id("demo")).getText().trim();
		
		if(result.equals("You pressed OK!"))
			System.out.println("Test Case Passed");
		else
			System.out.println("Test Case Failed");
		*/
		
		//Promp Alerts
		/*
		driver.findElement(By.id("promptBtn")).click();
		Alert alert = driver.switchTo().alert();
		
		alert.sendKeys("Gowri Shankar");
		//alert.accept();
		alert.dismiss();
		
		String result = driver.findElement(By.id("demo")).getText().trim();
		
		if(result.equals("User cancelled the prompt."))
			System.out.println("Test Case Passed");
		else
			System.out.println("Test Case Failed");
		*/
		
	}

}
