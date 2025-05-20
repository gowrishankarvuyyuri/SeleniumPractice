package Broken_Shadow_SVG;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SVG_Elements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		Thread.sleep(3000);
		
		WebElement element = driver.findElement(By.xpath("//*[name()='path' and contains(@d,'M293.5,60C')]"));
		
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
	}

}
